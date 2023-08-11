package com.example.dependencyinjection

import javax.inject.Inject
import javax.inject.Named

class RepositoryImpl @Inject constructor(
    @Named("Honda") private val car: Car,
) : Repository {

    init {
        println(this)
    }

    override fun getName(): String {
        return car.name()
    }
}

interface Repository {
    fun getName(): String
}