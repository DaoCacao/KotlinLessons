package com.example.lessonapp3

import android.app.Activity
import io.reactivex.rxjava3.disposables.Disposable


class SignInPresenter(private val _view: SignInActivity, private val _userService: UserService) :
    SignInObject.Presenter {

    private var _login = ""
    private var _password = ""
    private var _id = 0
    private lateinit var disposable: Disposable

    override fun loginInput(data: String): String {
        _login = data
        return _login
    }

    override fun passwordInput(data: String): String {
        _password = data
        return data
    }

    override fun getId(): Int {
        return _id
    }

    override fun signInInterface() {
        var disposable = _userService.signIn(_login, _password).subscribe({ user ->
            _id = user.id
            _view.navigationToMainActivity()
        },
            {
                _view.disableErrors()
                println("ХУИТА")
                when (it) {
                    SignInException.UserNotFound -> {_view.userNotFoundException()}
                    SignInException.InvalidPassword -> {_view.invalidPAsswordException()}
                }
            })

    }

    override fun dispose() {
        disposable.dispose()
    }
}