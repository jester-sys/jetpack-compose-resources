package com.example.jetpack.navigationComponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.jetpack.navigationComponent.navigation.StartNavigation
import com.example.jetpack.state_management.ShowWidget
import com.example.jetpack.ui.theme.JetPackTheme


// Another activity demonstrating the same navigation setup
class NavigationActivity : ComponentActivity() {

    // Enable experimental Material 3 features
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity
        setContent {
            JetPackTheme { // Apply the app's theme
                Surface(
                    color = MaterialTheme.colorScheme.background // Set the background color
                ) {
                    StartNavigation(this) // Call the StartNavigation composable
                }
            }
        }
    }
}
