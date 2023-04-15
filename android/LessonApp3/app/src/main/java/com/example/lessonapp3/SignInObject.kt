package com.example.lessonapp3

object SignInObject {
    interface View{
        fun navigationToEnterActivity()
        fun navigationToMainActivity()
        fun userNotFoundException()
        fun invalidPAsswordException()
    }
    interface Presenter{

        fun loginInput(data: String): String
        fun passwordInput(data: String): String
        fun signInInterface()
    }
}