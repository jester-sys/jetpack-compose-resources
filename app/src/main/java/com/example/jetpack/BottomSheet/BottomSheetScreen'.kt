package com.example.jetpack.BottomSheet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator



// BottomSheetScreen object is the entry point for the main screen
object BottomSheetScreen : Screen {
    @Composable
    override fun Content() {
        // Get the current bottom sheet navigator instance
        val navigator = LocalBottomSheetNavigator.current

        // Button to open the bottom sheet
        Button(onClick = {
            // Show the bottom sheet by passing the SheetContent
            navigator.show(SheetContent)
        }) {
            // Text inside the button
            Text(text = "Click Here")
        }
    }
}

// SheetContent object defines what will appear in the bottom sheet
object SheetContent : Screen {
    @Composable
    override fun Content() {
        // LazyColumn allows creating a scrollable list
        LazyColumn(
            modifier = Modifier.fillMaxSize() // Ensures the LazyColumn takes full space of the sheet
        ) {
            // First item: Close button at the top of the bottom sheet
            item {
                // Access the bottom sheet navigator
                val navigator = LocalBottomSheetNavigator.current
                // IconButton for closing the sheet
                IconButton(onClick = {
                    // Hide the bottom sheet when clicked
                    navigator.hide()
                }) {
                    // Display a close icon inside the button
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
            // Add 10 items to the list dynamically
            items(10) { data ->
                // Each item displays text with a number
                Text(text = "Count $data")
            }
        }
    }
}
