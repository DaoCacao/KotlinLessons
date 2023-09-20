package com.example.coroutineslesson.data

import com.example.coroutineslesson.domain.UserModel
import org.junit.Assert
import org.junit.Test

class UserMapperTest {

    private val mapper = UserMapper()

    @Test
    fun mapUserReturnsCorrectValue() {
        // Given

        val raw = UserRaw(
            id = "1",
            firstName = "John",
            lastName = "Doe",
            email = "email@gmail.com",
        )
        val expected = UserModel(
            id = "1",
            name = "John Doe",
            email = "email@gmail.com",
        )

        // Then

        Assert.assertEquals(expected, mapper.mapUser(raw))
    }

    @Test
    fun mapUserShouldTrimLastName() {
        // Given

        val raw = UserRaw(
            id = "1",
            firstName = "John",
            lastName = "",
            email = "email@gmail.com",
        )
        val expected = UserModel(
            id = "1",
            name = "John",
            email = "email@gmail.com",
        )

        // Then

        Assert.assertEquals(expected, mapper.mapUser(raw))
    }

    @Test
    fun mapUserShouldTrimFirstName() {
        // Given

        val raw = UserRaw(
            id = "1",
            firstName = "",
            lastName = "Doe",
            email = "email@gmail.com",
        )
        val expected = UserModel(
            id = "1",
            name = "Doe",
            email = "email@gmail.com",
        )

        // Then

        Assert.assertEquals(expected, mapper.mapUser(raw))
    }
}