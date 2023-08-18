package com.example.dependencyinjection.view_model.state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun StateScreen(
    viewModel: StateViewModel = viewModel(),
    onNavigateToNextScreenClick: () -> Unit = { println("Navigate fun") },
) {
    var text1 by remember { mutableStateOf("") } // by rememberSaveable { mutableStateOf("") }

    val stateState by viewModel.stateState
    val stateFlow by viewModel.stateFlow.collectAsState()
    // val stateLiveData by viewModel.stateLiveData.observeAsState()

    if (viewModel.isProfileUpdated) {
        viewModel.isProfileUpdated = false
        onNavigateToNextScreenClick()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("State Screen")
                },
            )
        },
    ) {
        stateState.let { state ->
            when (state) {
                State.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is State.Success -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column {
                            TextField(
                                value = text1,
                                onValueChange = { text1 = it },
                            )
                            TextField(
                                value = viewModel.text2,
                                onValueChange = { viewModel.onText2Change(it) },
                            )
                            TextField(
                                value = state.text4,
                                onValueChange = { viewModel.onText4Change(it) },
                            )
                        }
                    }
                }
                is State.Error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(text = state.message)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    StateScreen()
}