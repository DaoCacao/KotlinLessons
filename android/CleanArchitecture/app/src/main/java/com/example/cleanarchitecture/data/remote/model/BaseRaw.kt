package com.example.cleanarchitecture.data.remote.model

data class BaseRaw<R>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: R,
)

data class UserRaw(
    val id: Int,
    val name: String,
    val password: String,
)