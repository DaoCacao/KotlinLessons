package com.example.cleanarchitecture.domain.boundaries

import com.example.cleanarchitecture.domain.model.UserModel

interface UserRepository {
    fun getUser(userId: Int): UserModel
}