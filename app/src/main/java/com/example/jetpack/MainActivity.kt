package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.RecyclerView.User
import com.example.jetpack.RecyclerView.dummyData
import com.example.jetpack.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class) // Opt-in for Experimental API usage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // A method that could be for enabling edge-to-edge display (ensure it's defined in your project)

        setContent {
            JetPackTheme { // Applies your app's custom theme
                Surface(color = MaterialTheme.colorScheme.background) { // Surface for the background color
                    Scaffold(
                        modifier = Modifier.fillMaxSize(), // Fills the screen
                        topBar = { // Top app bar with title and navigation icons
                            TopAppBar(
                                title = {
                                    Text("App Name") // The app's title
                                },
                                navigationIcon = { // Icon on the left side (menu button)
                                    IconButton(onClick = {
                                        // Logic for opening menu
                                    }) {
                                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                                    }
                                },
                                actions = { // Icons on the right side (search and notifications)
                                    IconButton(onClick = {
                                        // Logic for search
                                    }) {
                                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                                    }
                                    IconButton(onClick = {
                                        // Logic for notifications
                                    }) {
                                        Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications")
                                    }
                                }
                            )
                        },
                        floatingActionButton = { // Floating action button at the bottom right
                            FloatingActionButton(onClick = {
                                // Action for FAB click
                            }) {
                                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                            }
                        }
                    ) { innerPadding -> // Content inside the Scaffold
                        Greeting("Android") // Calls Greeting composable
                    }
                }
            }
        }
    }

    // Greeting composable
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!", // Displays a greeting message
            modifier = modifier
        )
    }

    // Preview of the Greeting composable for Android Studio
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        JetPackTheme { // Applies theme in the preview
            Greeting("Android") // Preview of the greeting with "Android" name
        }
    }
}


