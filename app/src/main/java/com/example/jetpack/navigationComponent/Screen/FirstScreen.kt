package com.example.jetpack.navigationComponent.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetpack.navigationComponent.utils.NavigationScreen


// Composable function for the first screen
@Composable
fun FirstScreen(navController: NavHostController) {
    // Center the content inside a full-screen Box
    Box(
        contentAlignment = Alignment.Center, // Align content to the center
        modifier = Modifier.fillMaxSize() // Fill the entire screen size
    ) {
        // A button to navigate to the second screen
        Button(
            onClick = {
                navController.navigate(NavigationScreen.SecondScreen.route) // Navigate to SecondScreen
            }
        ) {
            Text(text = "Click here..") // Button label
        }
    }
}
