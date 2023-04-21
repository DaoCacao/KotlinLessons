package com.example.cleanarchitecture.data.remote

import com.example.cleanarchitecture.data.remote.mapper.UserMapper
import com.example.cleanarchitecture.domain.model.UserModel

class UserRemoteStorage(
    private val service: UserService,
    private val mapper: UserMapper,
) {

    fun getUser(userId: Int): UserModel {
        val raw = service.getUser(userId)
        return mapper.mapUser(raw.results)
    }
}

