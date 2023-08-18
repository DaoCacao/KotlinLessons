package com.example.dependencyinjection.view_model.navigator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Screen(
    viewModel: ScreenViewModel = viewModel(),
    title: String,
    action: String,
    onNextScreenClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title)
                },
            )
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            Column {
                Text(text = "Arg from viewModel: ${viewModel.arg}")
                Button(
                    onClick = onNextScreenClick,
                ) {
                    Text(text = action)
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Screen(
        title = "Screen",
        action = "Next",
        onNextScreenClick = {},
    )
}