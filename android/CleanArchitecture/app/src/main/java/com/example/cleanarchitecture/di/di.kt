package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.UserRepositoryImpl
import com.example.cleanarchitecture.data.local.UserLocalStorage
import com.example.cleanarchitecture.data.remote.UserRemoteStorage
import com.example.cleanarchitecture.data.remote.UserService
import com.example.cleanarchitecture.data.remote.mapper.UserMapper
import com.example.cleanarchitecture.domain.GetUserUseCase
import com.example.cleanarchitecture.domain.boundaries.UserRepository
import com.example.cleanarchitecture.presentation.Main
import com.example.cleanarchitecture.presentation.MainPresenter

fun providePresenter(view: Main.View): Main.Presenter = MainPresenter(view, provideGetUserUseCase())
fun provideGetUserUseCase() = GetUserUseCase(provideUserRepository())
fun provideUserRepository(): UserRepository = UserRepositoryImpl(provideUserLocalStorage(), provideUserRemoteStorage())
fun provideUserLocalStorage() = UserLocalStorage()
fun provideUserRemoteStorage() = UserRemoteStorage(provideUserService(), provideUserMapper())
fun provideUserService() = UserService()
fun provideUserMapper() = UserMapper()