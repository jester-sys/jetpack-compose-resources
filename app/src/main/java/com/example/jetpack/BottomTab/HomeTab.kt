package com.example.jetpack.BottomTab

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.VectorPainter

// Define the HomeTab object
object HomeTab : Tab {
    // Provide tab options for HomeTab
    override val options: TabOptions
        @Composable
        get() {
            // Define the title and icon for the HomeTab
            val title = "Home"
            val icon: VectorPainter = rememberVectorPainter(Icons.Default.Home)
            // Return the options (title and icon) for HomeTab
            return remember {
                TabOptions(
                    index = 0u, // Index for HomeTab
                    title = title,
                    icon = icon
                )
            }
        }

    // Define the content to display when HomeTab is selected
    @Composable
    override fun Content() {
        Box {
            // Display "Home" text inside the HomeTab
            Text(text = "Home")
        }
    }
}

// Define the ProfileTab object
object ProfileTab : Tab {
    // Provide tab options for ProfileTab
    override val options: TabOptions
        @Composable
        get() {
            // Define the title and icon for the ProfileTab
            val title = "Profile"
            val icon: VectorPainter = rememberVectorPainter(Icons.Default.Person)
            // Return the options (title and icon) for ProfileTab
            return TabOptions(
                index = 1u, // Index for ProfileTab
                title = title,
                icon = icon
            )
        }

    // Define the content to display when ProfileTab is selected
    @Composable
    override fun Content() {
        // Display "Profile" text inside the ProfileTab
        Text(text = "Profile")
    }
}