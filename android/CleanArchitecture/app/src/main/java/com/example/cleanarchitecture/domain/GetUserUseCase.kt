package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.domain.boundaries.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository,
) {
    fun getUser(userId: Int) = userRepository.getUser(userId)
}