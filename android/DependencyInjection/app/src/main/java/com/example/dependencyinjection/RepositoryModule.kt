package com.example.dependencyinjection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class RepositoryModule {
//
//    @Provides
//    @Singleton
//    fun provideRepository(): Repository {
//        return RepositoryImpl()
//    }
//}

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideRepository(impl: RepositoryImpl): Repository
}