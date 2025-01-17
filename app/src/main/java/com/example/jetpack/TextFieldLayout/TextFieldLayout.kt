package com.example.jetpack.TextFieldLayout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults

import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldLayout() {
    // Mutable state to hold the text input from the user
    var name by remember { mutableStateOf("") } // State variable to track the text input value

    Column(
        modifier = Modifier
            .fillMaxSize() // Makes the column fill the entire screen
            .padding(horizontal = 20.dp), // Adds padding to the left and right
        horizontalAlignment = Alignment.CenterHorizontally, // Centers children horizontally
        verticalArrangement = Arrangement.Center // Centers children vertically
    ) {
        // Standard TextField for user input
        TextField(
            value = name, // Current text in the TextField
            onValueChange = { name = it }, // Updates the state when the user types
            modifier = Modifier
                .fillMaxWidth() // Ensures the TextField spans the full width of its parent
                .padding(bottom = 16.dp), // Adds spacing below the TextField
            textStyle = TextStyle(
                color = Color.Black, // The color of the text
                fontSize = 14.sp // The size of the text
            ),
            label = {
                Text(text = "Username") // The label shown above the text input
            },
            placeholder = {
                Text(text = "Enter username") // Hint text shown when input is empty
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Person Icon")
                // An icon shown on the left of the TextField
            },
            trailingIcon = {
                // Logic to display a trailing icon based on text input
                if (name.isNotBlank()) { // If the input is not empty
                    Icon(
                        Icons.Default.Clear, // Display a clear icon
                        contentDescription = "Clear Icon",
                        modifier = Modifier.clickable { name = "" } // Clears input when clicked
                    )
                } else { // If the input is empty
                    Icon(Icons.Default.Info, contentDescription = "Info Icon")
                    // Display an info icon as a default
                }
            },
            isError = name.isBlank(), // Displays error style if the field is empty
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences, // Capitalizes the first letter of sentences
                keyboardType = KeyboardType.Text, // Shows a keyboard suited for text input
                imeAction = ImeAction.Done // Adds a "Done" action to the keyboard
            ),
            visualTransformation = VisualTransformation.None, // Keeps input as plain text
            shape = RoundedCornerShape(8.dp), // Gives the TextField rounded corners
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFF5F5F5), // Sets a light gray background
                focusedIndicatorColor = Color.Blue, // Underline color when focused
                unfocusedIndicatorColor = Color.Gray, // Underline color when not focused
                cursorColor = Color.Black // Cursor color
            )
        )

        // OutlinedTextField for a bordered input style
        OutlinedTextField(
            value = name, // Current text in the field
            onValueChange = { name = it }, // Updates the state on text input
            modifier = Modifier
                .fillMaxWidth() // Makes the field span the full width
                .padding(bottom = 16.dp), // Adds spacing below the field
            textStyle = TextStyle(fontSize = 14.sp), // Sets the text size
            label = {
                Text(text = "Username") // Label shown above the input
            },
            placeholder = {
                Text(text = "Enter username") // Hint text shown when input is empty
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Person Icon")
                // Displays an icon on the left of the field
            },
            trailingIcon = {
                // Logic for a clear icon
                if (name.isNotBlank()) { // If the input is not empty
                    Icon(
                        Icons.Default.Clear, // Clear icon
                        contentDescription = "Clear Icon",
                        modifier = Modifier.clickable { name = "" } // Clears input on click
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Border color when focused
                unfocusedBorderColor = Color.Gray, // Border color when not focused
                cursorColor = Color.Black // Cursor color
            )
        )
    }
}
