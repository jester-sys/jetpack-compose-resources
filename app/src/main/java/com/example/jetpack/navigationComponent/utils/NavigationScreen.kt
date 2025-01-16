package com.example.jetpack.navigationComponent.utils

// Sealed class representing navigation routes
sealed class NavigationScreen(val route: String) {
    // Define the route for the first screen
    data object FirstScreen : NavigationScreen("firstScreen")

    // Define the route for the second screen
    data object SecondScreen : NavigationScreen("secondScreen")

    // Define the route for the third screen
    data object ThirdScreen : NavigationScreen("thirdScreen")
}