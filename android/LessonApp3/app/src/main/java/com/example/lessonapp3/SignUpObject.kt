package com.example.lessonapp3

object SignUpObject {
    interface View{
        fun navigationToEnterActivity()
        fun navigationToMainActivity()
    }
    interface Presenter{
        fun signUp_interface()
        fun loginInput(data: String): String
        fun nameInput(data: String): String
        fun passwordInput(data: String): String
        fun confirmPasswordInput(data: String): String

    }
}