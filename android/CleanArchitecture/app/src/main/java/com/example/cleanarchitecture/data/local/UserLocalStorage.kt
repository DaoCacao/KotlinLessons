package com.example.cleanarchitecture.data.local

import com.example.cleanarchitecture.domain.model.UserModel

class UserLocalStorage {
    private var users = mutableMapOf<Int, UserModel>()

    fun saveUser(userId: Int, user: UserModel) {
        users[userId] = user
    }

    fun getUser(userId: Int): UserModel? {
        return users[userId]
    }
}