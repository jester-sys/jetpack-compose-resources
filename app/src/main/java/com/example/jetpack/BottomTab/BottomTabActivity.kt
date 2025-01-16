package com.example.jetpack.BottomTab

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.jetpack.navigationComponent.navigation.StartNavigation
import com.example.jetpack.ui.theme.JetPackTheme



class BottomTabActivity : ComponentActivity() {

    // Suppresses warnings about unused scaffold padding
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class) // Enable experimental Material 3 features
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Apply the JetPack theme to the UI
            JetPackTheme {
                // Set the background color using Material 3 theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Initialize a TabNavigator with the HomeTab as the default tab
                    TabNavigator(tab = HomeTab) {
                        // Scaffold provides a structure with a bottom navigation bar
                        Scaffold(
                            bottomBar = {
                                // Create a BottomNavigation component
                                BottomNavigation {
                                    // Add navigation items for HomeTab and ProfileTab
                                    TabNavigationItems(tab = HomeTab)
                                    TabNavigationItems(tab = ProfileTab)
                                }
                            }
                        ) {
                            // Display the currently selected tab's content
                            CurrentTab()
                        }
                    }
                }
            }
        }
    }
}

// Function to add items to the bottom navigation bar
@Composable
fun RowScope.TabNavigationItems(tab: Tab) {
    // Retrieve the current tab navigator
    val tabNavigator = LocalTabNavigator.current
    // Create a BottomNavigationItem for the given tab
    BottomNavigationItem(
        selected = tabNavigator.current == tab, // Highlight if this tab is selected
        onClick = {
            // Change to the selected tab
            tabNavigator.current = tab
        },
        icon = {
            // Display the icon for the tab
            Icon(tab.options.icon!!, contentDescription = tab.options.title)
        }
    )
}