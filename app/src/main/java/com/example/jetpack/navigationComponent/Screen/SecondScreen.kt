package com.example.jetpack.navigationComponent.Screen

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetpack.navigationComponent.AnotherActivity
import com.example.jetpack.navigationComponent.utils.NavigationScreen


// Composable function for the second screen
@Composable
fun SecondScreen(navHostController: NavHostController) {
    // Button to navigate to the third screen
    Button(
        onClick = {
            // Navigate to ThirdScreen with custom navigation behavior
            navHostController.navigate(NavigationScreen.ThirdScreen.route) {
                launchSingleTop = true // Ensure only one instance of ThirdScreen is created
                popUpTo(NavigationScreen.FirstScreen.route) {
                    inclusive = true // Remove FirstScreen from the back stack
                }
            }

            // Uncomment this block to navigate to AnotherActivity using an Intent
            // val intent = Intent(context, AnotherActivity::class.java)
            // context.startActivity(intent)
        }
    ) {
        Text(text = "Go to Another Activity") // Button label
    }
}