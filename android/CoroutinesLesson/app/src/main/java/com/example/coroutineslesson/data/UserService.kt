package com.example.coroutineslesson.data

import java.util.Date

class UserService {
    private val users = List(100)
    {
        UserRaw(
            id = "$it",
            firstName = "John",
            lastName = "$it",
            email = "email+$it@gmail.com",
        )
    }

    fun getUsers(): List<UserRaw> = users
    fun getUser(id: String): UserRaw = users.first { it.id == id }
}

// easy testable
fun isTomorrow(date: Date, now: Date = Date()) = date > now

// not testable
fun isTomorrow(date: Date) = date > Date()