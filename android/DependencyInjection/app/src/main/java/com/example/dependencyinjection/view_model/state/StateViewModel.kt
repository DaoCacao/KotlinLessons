package com.example.dependencyinjection.view_model.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StateViewModel @Inject constructor() : ViewModel() {

    var content by mutableStateOf<String?>(null) // if null - loading, else - show content

    var error by mutableStateOf<String?>(null) // if null - no error, else - show error
    var content1 by mutableStateOf<String?>(null) // if null - no content, else - show content
    var isLoading get() = content1 == null && error == null
        set(value) {
            if (value) {
                content1 = null
                error = null
            }
        }

    var text2 by mutableStateOf("Hello World!")
    var text3 = mutableStateOf("Hello World!")
    var isProfileUpdated by mutableStateOf(false)

    var stateState = mutableStateOf<State>(State.Loading)
    var stateFlow = MutableStateFlow<State>(State.Loading)
    var stateLiveData = MutableLiveData<State>(State.Loading)

    init {
        viewModelScope.launch {
            isLoading = true
            delay(2000) // fetching
            isLoading = false
            updateState(State.Success(text4 = "Hello World!"))
        }
    }

    fun onText2Change(text: String) {
        this.text2 = text
    }

    fun onText3Change(text: String) {
        this.text3.value = text
    }

    fun onText4Change(text: String) {
        if (text == "Error") updateState(State.Error("Oops Error"))
        else updateState(State.Success(text4 = text))
    }

    private fun updateState(state: State) {
        stateState.value = state
        stateFlow.value = state
        stateLiveData.value = state
    }
}

sealed class State {
    object Loading : State()
    data class Success(
        val text4: String,
    ) : State()

    data class Error(val message: String) : State()
}