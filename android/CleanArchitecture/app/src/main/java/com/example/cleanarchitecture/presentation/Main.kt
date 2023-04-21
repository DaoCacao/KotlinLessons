package com.example.cleanarchitecture.presentation

import com.example.cleanarchitecture.domain.model.UserModel

object Main {
    interface View {
        fun showUser(user: UserModel)
    }

    interface Presenter {
        fun updateId(userId: String)
        fun loadUser()
    }
}