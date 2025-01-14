package com.example.jetpack.LoginScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    // State variables for username and password
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current // For showing Toast messages

    // Main layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Welcome messages
        Text(
            text = "Hello Again!!",
            color = Color.Red,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Welcome",
            color = Color.Red,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Back",
            color = Color.Red,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        // Username input
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Person Icon")
            },
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Enter the Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp)) // Spacing

        // Password input
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "Info Icon")
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter the Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp)) // Spacing

        // Login button
        OutlinedButton(
            onClick = {
                logged(context, username.value, password.value)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

// Function to validate login credentials
private fun logged(context: Context, username: String, password: String) {
    if (username == "jks" && password == "1234") {
        Toast.makeText(context, "Logged in!", Toast.LENGTH_LONG).show()
    } else {
        Toast.makeText(context, "Wrong credentials", Toast.LENGTH_LONG).show()
    }
}
