package com.example.jetpack.SharedViewModel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun FirstScreen(navHostController: NavHostController, viewModel: SharedViewModel) {
    // Center a button in the screen
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Button to navigate to the second screen
        Button(
            onClick = {
                viewModel.setData("Hello World") // Set data in the ViewModel
                navHostController.navigate(SECOND_SCREEN) // Navigate to the second screen
            }
        ) {
            Text(text = "Send Data") // Button label
        }
    }
}