package com.example.lessonapp3

import io.reactivex.rxjava3.disposables.Disposable


class SignUpPresenter(
    private val _view: SignUpActivity,
    private val _userService: UserService
) : SignUpObject.Presenter {


    private var _login = ""
    private var _name: String = ""
    private var _password: String = ""
    private var _confirmPassword = ""
    private var _id = 0
    private lateinit var disposable: Disposable


    override fun loginInput(data: String): String {
        _login = data
        return _login
    }

    override fun nameInput(data: String): String {
        _name = data
        return _name
    }

    override fun passwordInput(data: String): String {
        _password = data
        return _password
    }

    override fun confirmPasswordInput(data: String): String {
        _confirmPassword = data
        return _confirmPassword
    }


    override fun signUp_interface() {

        if (_confirmPassword == _password) {

            disposable = _userService.signUp(
                _login,
                _password,
                _name,
            ).subscribe(
                { user ->
                    _id = user.id
                    _view.navigationToMainActivity()
                },
                {
                    println("ХУИТА")
                    when (it) {
                        SignUpException.InvalidLogin -> {}
                        SignUpException.UserAlreadyExists -> {}
                        SignUpException.InvalidName -> {}
                        SignUpException.InvalidPassword -> {}
                    }
                })
            //disposable.dispose()

        } else {
            throw SignUpDeviceException.InvalidConfirmePassword
        }
    }

    override fun idToMainActivity(): Int {
        return _id
    }


    sealed class SignUpDeviceException : Exception() {
        object InvalidConfirmePassword : SignUpDeviceException()
    }
}