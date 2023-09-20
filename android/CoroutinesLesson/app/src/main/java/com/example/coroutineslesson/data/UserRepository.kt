package com.example.coroutineslesson.data

import com.example.coroutineslesson.domain.UserModel

class UserRepository(
    private val service: UserService,
    private val mapper: UserMapper,
) {

    fun getUsers(): List<UserModel> = service.getUsers().map(mapper::mapUser)

    fun getUser(id: String): UserModel = mapper.mapUser(service.getUser(id))
}