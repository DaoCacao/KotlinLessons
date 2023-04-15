package com.example.lessonapp3

object SignUpObject {
    interface View{
        fun navigationToEnterActivity()
        fun navigationToMainActivity()
        fun invalidLogin()
        fun inavalidName()
        fun invalidPassword()
        fun invalidConfirmPassword()
    }
    interface Presenter{
        fun signUp_interface()
        fun idToMainActivity(): Int
        fun loginInput(data: String): String
        fun nameInput(data: String): String
        fun passwordInput(data: String): String
        fun confirmPasswordInput(data: String): String

    }
}