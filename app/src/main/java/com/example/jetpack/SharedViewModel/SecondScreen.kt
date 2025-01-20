package com.example.jetpack.SharedViewModel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SecondScreen(viewModel: SharedViewModel) {
    // Center a button in the screen
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Button displaying data from ViewModel
        Button(onClick = { }) {
            Text(text = viewModel.res.value) // Display shared data from ViewModel
        }
    }
}
