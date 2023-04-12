package com.example.lessonapp3

import android.app.Activity

class SignInPresenter(_view: Activity, _userService: UserService): SignUpObject.Presenter {

    var _login=""
    var _password=""



    override fun signUp_interface() {
        TODO("Not yet implemented")
    }
}