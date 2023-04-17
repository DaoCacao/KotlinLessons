package com.example.lessonapp3

object SignUpObject {
    interface View{
        fun navigationToEnterActivity()
        fun navigationToMainActivity(id: Int)
        fun invalidLogin()
        fun inavalidName()
        fun invalidPassword()
        fun invalidConfirmPassword()
        fun userAlreadyExist()
        fun disableErrors()
    }
    interface Presenter{
        fun signUp_interface()
//        fun idInitialization(id: Int): Int
        fun loginInput(data: String): String
        fun nameInput(data: String): String
        fun passwordInput(data: String): String
        fun confirmPasswordInput(data: String): String
        fun getId():Int

    }
}