package com.example.dependencyinjection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Dependency Injection") })
        },
        content = {
            Box(
                modifier = Modifier.padding(it),
            ) {
                Text(text = viewModel.getGreeting())
            }
        }
    )
}