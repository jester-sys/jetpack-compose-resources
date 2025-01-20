package com.example.jetpack.SharedViewModel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.jetpack.Switch.ShowSwitch
import com.example.jetpack.ui.theme.JetPackTheme


// Main Activity that hosts the Composable content
class ShareViewModelActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class) // Using experimental API for Material 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Set the theme for the app
            JetPackTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background // App background color
                ) {
                    ScreenNavigation() // Launch navigation composable
                }
            }
        }
    }
}
