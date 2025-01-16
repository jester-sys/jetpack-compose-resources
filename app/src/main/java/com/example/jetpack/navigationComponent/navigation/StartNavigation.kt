package com.example.jetpack.navigationComponent.navigation

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack.navigationComponent.Screen.FirstScreen
import com.example.jetpack.navigationComponent.Screen.SecondScreen
import com.example.jetpack.navigationComponent.Screen.ThirdScreen
import com.example.jetpack.navigationComponent.utils.NavigationScreen

// Composable function that sets up the navigation graph
@Composable
fun StartNavigation(context: Activity) {
    // Creates a navigation controller to manage navigation between screens
    val navController = rememberNavController()

    // Defines the navigation host, starting with the FirstScreen
    NavHost(
        navController = navController, // Navigation controller for managing back stack
        startDestination = NavigationScreen.FirstScreen.route // Initial screen
    ) {
        // Define the route and corresponding composable for FirstScreen
        composable(NavigationScreen.FirstScreen.route) {
            FirstScreen(navController) // Navigates to FirstScreen
        }

        // Define the route and corresponding composable for SecondScreen
        composable(NavigationScreen.SecondScreen.route) {
            SecondScreen(navController) // Navigates to SecondScreen
        }

        // Define the route and corresponding composable for ThirdScreen
        composable(NavigationScreen.ThirdScreen.route) {
            ThirdScreen() // Navigates to ThirdScreen
        }
    }
}