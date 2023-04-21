package com.example.cleanarchitecture.data.remote.mapper

import com.example.cleanarchitecture.data.remote.model.UserRaw
import com.example.cleanarchitecture.domain.model.UserModel

class UserMapper {

    fun mapUser(raw: UserRaw) = UserModel(
        id = raw.id,
        name = raw.name,
        password = raw.password,
    )
}

fun UserRaw.map() = UserModel(
    id = this.id,
    name = this.name,
    password = this.password,
)