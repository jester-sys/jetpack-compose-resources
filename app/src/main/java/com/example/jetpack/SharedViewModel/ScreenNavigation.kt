package com.example.jetpack.SharedViewModel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenNavigation() {
    // Create a NavController to handle navigation between screens
    val navHostController = rememberNavController()
    // Create a ViewModel instance to share data between screens
    val viewModel: SharedViewModel = viewModel()

    // Define the NavHost, setting the start destination and composables for each screen
    NavHost(navController = navHostController, startDestination = FIRST_SCREEN) {
        composable(FIRST_SCREEN) {
            // First screen composable
            FirstScreen(navHostController, viewModel)
        }
        composable(SECOND_SCREEN) {
            // Second screen composable
            SecondScreen(viewModel)
        }
    }
}

// Define constants for navigation routes
const val FIRST_SCREEN = "FirstScreen"
const val SECOND_SCREEN = "SecondScreen"