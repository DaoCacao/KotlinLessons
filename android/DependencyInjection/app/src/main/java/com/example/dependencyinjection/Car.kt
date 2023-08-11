package com.example.dependencyinjection

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named

abstract class Car {
    abstract fun name(): String
}

class Toyota @Inject constructor() : Car() {
    override fun name(): String {
        return "Toyota"
    }
}

class Honda @Inject constructor() : Car() {
    override fun name(): String {
        return "Honda"
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class CarModule {
    @Binds
    abstract fun bindToyota(toyota: Toyota): Car

    companion object {
        @Provides
        @Named("Honda")
        fun provideHonda(): Car = Honda()
    }
}
