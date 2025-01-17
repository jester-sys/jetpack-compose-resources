package com.example.jetpack.BoxLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BoxLayout() {
    // Creating a Box composable which acts as the container for the other elements
    Box(
        modifier = Modifier.fillMaxSize() // Makes the Box occupy the entire available space
            .background(Color.Yellow), // Sets the background color of the Box to Yellow
        contentAlignment = Alignment.Center // Default alignment for all child elements is Center (aligns to the center of the Box)
    ) {
        // This Text element will be placed at the center of the Box because of the default contentAlignment
        Text(text = "Hello World 1")

        // This Text element is aligned to the top-center of the Box
        Text(
            text = "Hello World 2", // Text content
            color = Color.Red, // Sets the text color to Red
            modifier = Modifier.align(Alignment.TopCenter) // Aligns this Text to the top center of the Box
        )

        // This Button is aligned to the center-end (right-center) of the Box
        Button(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)) {
            Text(text = "Button") // Button's text
        }

        // This Text is aligned to the bottom-center of the Box
        Text(
            text = "Hello World 3 ", // Text content
            modifier = Modifier.align(Alignment.BottomCenter) // Aligns this Text to the bottom center of the Box
        )

        // This Text is aligned to the top-start (top-left) of the Box
        Text(
            text = "Hello World 4 ", // Text content
            modifier = Modifier.align(Alignment.TopStart) // Aligns this Text to the top left of the Box
        )
    }
}
