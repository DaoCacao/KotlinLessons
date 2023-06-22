package com.example.lessonapp3

object SignInObject {
    interface View{
        fun navigationToEnterActivity()
        fun navigationToMainActivity()
        fun userNotFoundException()
        fun invalidPAsswordException()
        fun disableErrors()
    }
    interface Presenter{

        fun loginInput(data: String): String
        fun passwordInput(data: String): String
        fun signInInterface()
        fun getId(): Int
        fun dispose()
    }
}