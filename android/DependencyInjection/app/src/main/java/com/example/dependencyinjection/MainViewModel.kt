package com.example.dependencyinjection

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    init {
        println(this)
    }

    fun getGreeting(): String {
        return "Hello ${repository.getName()}!"
    }
}