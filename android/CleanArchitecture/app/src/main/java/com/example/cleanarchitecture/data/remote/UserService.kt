package com.example.cleanarchitecture.data.remote

import com.example.cleanarchitecture.data.remote.model.BaseRaw
import com.example.cleanarchitecture.data.remote.model.UserRaw
import java.util.UUID

class UserService {
    fun getUser(userId: Int): BaseRaw<UserRaw> {
        return BaseRaw(
            count = 1,
            next = null,
            previous = null,
            results = UserRaw(
                id = userId,
                name = "User $userId",
                password = UUID.randomUUID().toString(),
            ),
        )
    }
}