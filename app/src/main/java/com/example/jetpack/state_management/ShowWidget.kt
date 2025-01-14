package com.example.jetpack.state_management

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ShowWidget() {
    // Create a mutable state that will remember the value across recompositions.
    val name = rememberSaveable { mutableStateOf("") }

    // A Column to arrange items vertically
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // If 'name' is not empty, show the value of 'name' as a Text
        if (name.value.isNotEmpty()) {
            Text(text = name.value, color = Color.Red)
        }

        // OutlinedTextField: A basic input field
        OutlinedTextField(
            value = name.value,  // The value of the input field is tied to the 'name' state.
            onValueChange = {
                name.value = it  // Update 'name' state whenever the user types something.
            },
            label = { Text(text = "Demo") }  // Label for the input field
        )
    }
}
