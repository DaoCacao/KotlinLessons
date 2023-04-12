package com.example.lessonapp3

object SignInObject {
    interface View{
        fun navigationToEnterActivity()
        fun navigationToMainActivity()
    }
    interface Presenter{
        fun signInInterface()
    }
}