package com.example.coroutineslesson.domain

import com.example.coroutineslesson.data.UserRepository

class GetUsersUseCase(
    private val repository: UserRepository,
) {
    operator fun invoke(): List<UserModel> = repository.getUsers()
}