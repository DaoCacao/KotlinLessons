package com.example.lessonapp3

object MainObject {
    interface View{
        fun navigationToEnterActivity()
        fun welcomText(user: Boolean)
    }
    interface Presenter{
        fun signOut()
        fun userInitialization(id:Int): User
    }
}