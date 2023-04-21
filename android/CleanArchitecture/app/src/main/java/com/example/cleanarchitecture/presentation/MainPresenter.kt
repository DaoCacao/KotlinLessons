package com.example.cleanarchitecture.presentation

import com.example.cleanarchitecture.domain.GetUserUseCase

class MainPresenter(
    private val view: Main.View,
    private val getUserUseCase: GetUserUseCase,
) : Main.Presenter {

    private var userId: Int? = null

    override fun updateId(userId: String) {
        this.userId = userId.toIntOrNull()
    }

    override fun loadUser() {
        val user = getUserUseCase.getUser(userId ?: return)
        view.showUser(user)
    }
}