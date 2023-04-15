package com.example.lessonapp3

object MainObject {
    interface View{
        fun navigationToEnterActivity()
    }
    interface Presenter{
        fun signOut()
    }
}