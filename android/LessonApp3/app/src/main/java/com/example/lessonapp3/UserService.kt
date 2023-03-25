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
        TODO("Implement this function using reactive way")
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
        TODO("Implement this function using reactive way")
    }

    /**
     * Returns user with given [userId].
     *
     * Conditions:
     * - If user with given [userId] does not exist, [GetUserException.UserNotFound] is thrown.
     * - Else [User] is returned.
     */
    fun getUser(userId: Int): Single<User> {
        TODO("Implement this function using reactive way")
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