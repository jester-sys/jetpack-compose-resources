package com.example.jetpack.DialogBox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
fun DialogScreen() {
    var isDialog by remember { mutableStateOf(false) }
    // Tracks whether the dialog is visible (true) or hidden (false).

    Column(
        modifier = Modifier.fillMaxSize(), // Makes the column fill the entire screen.
        horizontalAlignment = Alignment.CenterHorizontally, // Centers children horizontally.
        verticalArrangement = Arrangement.Center // Centers children vertically.
    ) {
        Button(onClick = {
            isDialog = true // Sets the dialog visibility to true when the button is clicked.
        }) {
            Text(text = "Click here") // Text displayed on the button.
        }
    }

    if (isDialog) // Checks if `isDialog` is true to show the dialog.
        Dialog(onDismissRequest = {
            isDialog = false // Closes the dialog when it's dismissed.
        }) {
            // Empty dialog content here. Add your UI inside this block if needed.
        }
}

@Composable
fun AlertDialogScreen() {
    var isDialog by remember { mutableStateOf(false) }
    // Tracks whether the alert dialog is visible (true) or hidden (false).

    Column(
        modifier = Modifier.fillMaxSize(), // Makes the column fill the entire screen.
        horizontalAlignment = Alignment.CenterHorizontally, // Centers children horizontally.
        verticalArrangement = Arrangement.Center // Centers children vertically.
    ) {
        Button(onClick = {
            isDialog = true // Sets the dialog visibility to true when the button is clicked.
        }) {
            Text(text = "Click here") // Text displayed on the button.
        }

        if (isDialog) { // Checks if `isDialog` is true to show the alert dialog.
            AlertDialog(
                onDismissRequest = {
                    isDialog = false // Closes the alert dialog when it's dismissed.
                },
                title = {
                    Text(text = "Dialog Box") // Title of the alert dialog.
                },
                text = {
                    Text(text = "This is Dialog Box") // Main message of the alert dialog.
                },
                modifier = Modifier.fillMaxWidth(), // Makes the dialog take the full width of its parent.
                buttons = {
                    // Buttons section of the alert dialog.
                    Box(
                        modifier = Modifier.fillMaxWidth(), // Fills the width for centering the button.
                        contentAlignment = Alignment.Center // Centers the button horizontally.
                    ) {
                        Button(onClick = {
                            isDialog = false // Closes the alert dialog when the button is clicked.
                        }) {
                            Text("Ok") // Text displayed on the button.
                        }
                    }
                }
            )
        }
    }
}
