package com.example.coroutineslesson.data

import com.example.coroutineslesson.domain.UserModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class UserRepositoryTest {

    lateinit var repository: UserRepository
    lateinit var service: UserService
    lateinit var mapper: UserMapper

    @Before
    fun setUp() {
        service = Mockito.mock()
        mapper = Mockito.mock()
        repository = UserRepository(
            service = service,
            mapper = mapper,
        )
    }

    @Test
    fun getUsersReturnsCorrectValue() {
        // Given

        val raw = Mockito.mock<UserRaw>()
        val expected = Mockito.mock<UserModel>()

        // When

        Mockito.`when`(service.getUsers()).thenReturn(listOf(raw, raw))
        Mockito.`when`(mapper.mapUser(raw)).thenReturn(expected)

        // Then

        Assert.assertEquals(listOf(expected, expected), repository.getUsers())
        Mockito.verify(service).getUsers()
        Mockito.verify(mapper, Mockito.times(2)).mapUser(raw)
    }

    @Test
    fun getUserReturnsCorrectValue() {
        // Given

        val raw = Mockito.mock<UserRaw>()
        val expected = Mockito.mock<UserModel>()

        // When

        Mockito.`when`(service.getUser("1")).thenReturn(raw)
        Mockito.`when`(mapper.mapUser(raw)).thenReturn(expected)

        // Then

        Assert.assertEquals(expected, repository.getUser("1"))
        Mockito.verify(service).getUser("1")
        Mockito.verify(mapper).mapUser(raw)
    }

    @Test
    fun getUserThrowsErrorIfUserNotFound() {
        // Given

        val raw = Mockito.mock<UserRaw>()
        val expected = Mockito.mock<UserModel>()

        // When

        Mockito.`when`(service.getUser("1")).thenThrow(RuntimeException())

        // Then

        Assert.assertThrows(RuntimeException::class.java) { repository.getUser("1") }
        Mockito.verify(service).getUser("1")
        Mockito.verify(mapper, Mockito.never()).mapUser(raw)
    }
}