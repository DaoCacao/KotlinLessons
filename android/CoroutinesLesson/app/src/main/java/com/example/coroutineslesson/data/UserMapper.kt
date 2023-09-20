package com.example.coroutineslesson.data

import com.example.coroutineslesson.domain.UserModel

class UserMapper {

    fun mapUser(raw: UserRaw) = UserModel(
        id = raw.id,
        name = "${raw.firstName} ${raw.lastName}".trim(),
        email = raw.email,
    )
}