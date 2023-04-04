package com.example.lessonapp3

import io.reactivex.rxjava3.core.Single

/**
 * Service that emulates user authentication.
 *
 * You can use this service to sign up and sign in users.
 */
class UserService {

    /**
     * Signs up user with given [login], [password] and [name].
     *
     * Validations:
     * - [login] must be at least 3 characters long.
     * - [password] must be at least 6 characters long.
     * - [name] must be at least 3 characters long.
     *
     * Conditions:
     * - If user with given [login] already exists, [SignUpException.UserAlreadyExists] is thrown.
     * - If [login] is invalid, [SignUpException.InvalidLogin] is thrown.
     * - If [password] is invalid, [SignUpException.InvalidPassword] is thrown.
     * - If [name] is invalid, [SignUpException.InvalidName] is thrown.
     * - Else [User] with given [login], [password] and [name] is created, saved and returned.
     *
     */
    fun signUp(login: String, password: String, name: String): Single<User> {

        return Single.create {
            if (login.length < 3) {
                it.onError(SignUpException.InvalidLogin)
                return@create
            }
            if (password.length < 6) {
                it.onError(SignUpException.InvalidPassword)
                return@create
            }
            if (name.length < 3) {
                it.onError(SignUpException.InvalidName)
                return@create
            }
            for (_userNames in users.values) {
                if (_userNames.name == name) {
                    it.onError(SignUpException.UserAlreadyExists)
                    return@create
                }
            }
            val id = users.values.map { it.id }.max()

            it.onSuccess(User(1 + id, name))

        }
    }

    /**
     * Signs in user with given [login] and [password].
     *
     * Conditions:
     * - If user with given [login] does not exist, [SignInException.UserNotFound] is thrown.
     * - If [password] is invalid, [SignInException.InvalidPassword] is thrown.
     * - Else [User] is signed in and returned.
     */
    fun signIn(login: String, password: String): Single<User> {
        return Single.create {

            var loginCheck = false
            var passwordCheck = false

            for (_user in users.keys) {
                if (_user.login == login) {
                    loginCheck = true
                }
            }
            if (!loginCheck) {
                it.onError(SignInException.UserNotFound)
                return@create
            }

            for (_user in users.keys) {
                if (_user.password == password)
                    passwordCheck = true
            }
            if (!passwordCheck) {
                it.onError(SignInException.UserNotFound)
                return@create
            }

            it.onSuccess(users[Credentials(login, password)]!!)
        }
    }


    /**
     * Returns user with given [userId].
     *
     * Conditions:
     * - If user with given [userId] does not exist, [GetUserException.UserNotFound] is thrown.
     * - Else [User] is returned.
     */
    fun getUser(userId: Int): Single<User> {
        return Single.create {
            for (_users in users.values) {
                if (_users.id == userId) {
                    it.onSuccess(_users)
                    return@create
                }
            }
            it.onError(GetUserException.UserNotFound)
            return@create
        }
    }
}

/**
 * Login and password pair for user authentication.
 */
private data class Credentials(
    val login: String,
    val password: String,
)

sealed class SignUpException : Exception() {
    object UserAlreadyExists : SignUpException()
    object InvalidLogin : SignUpException()
    object InvalidPassword : SignUpException()
    object InvalidName : SignUpException()
}

sealed class SignInException : Exception() {
    object UserNotFound : SignInException()
    object InvalidPassword : SignInException()
}

sealed class GetUserException : Exception() {
    object UserNotFound : GetUserException()
}

/**
 * Static map of users, emulates persistent user database.
 *
 * In real app you would use some database or network service.
 * But for this example we will use simple in-memory map.
 */
private val users = HashMap<Credentials, User>()