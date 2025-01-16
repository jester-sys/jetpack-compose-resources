package com.example.jetpack.SnackBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun CreateSnackBar(scaffoldState: ScaffoldState) {
 // A CoroutineScope to handle asynchronous operations within the composable.
 val scope = rememberCoroutineScope()

 // A Row layout to center the Button horizontally.
 Row(
  modifier = Modifier
   .fillMaxWidth() // Makes the Row span the full width of the screen.
   .padding(vertical = 20.dp), // Adds vertical padding around the Row.
  horizontalArrangement = Arrangement.Center // Centers the Button horizontally within the Row.
 ) {
  // A Button to trigger the Snackbar display.
  Button(onClick = {
   scope.launch {
    // Launches a coroutine to show the Snackbar.
    scaffoldState.snackbarHostState.showSnackbar("Hey, How are you")
    // Displays a Snackbar with the message "Hey, How are you".
   }
  }) {
   // Text displayed inside the Button.
   Text(text = "Show SnackBar")
  }
 }
}
