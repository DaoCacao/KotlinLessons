package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.data.local.UserLocalStorage
import com.example.cleanarchitecture.data.remote.UserRemoteStorage
import com.example.cleanarchitecture.domain.boundaries.UserRepository
import com.example.cleanarchitecture.domain.model.UserModel

class UserRepositoryImpl(
    private val localStorage: UserLocalStorage,
    private val remoteStorage: UserRemoteStorage,
) : UserRepository {
    override fun getUser(userId: Int): UserModel {
        val user = localStorage.getUser(userId)
        return if (user == null) {
            val newUser = remoteStorage.getUser(userId)
            localStorage.saveUser(userId, newUser)
            newUser
        } else {
            user
        }
    }
}