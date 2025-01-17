package com.example.jetpack.ToggleButton

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.R

@Composable
fun CustomToggleButton() {
    // `isToggle` keeps track of the toggle button state (true for "On", false for "Off").
    var isToggle by remember { mutableStateOf(false) }

    // Outer Box to center the Card in the middle of the screen.
    Box(
        modifier = Modifier.fillMaxSize(), // Makes the Box fill the entire screen.
        contentAlignment = Alignment.Center // Centers its child composable.
    ) {
        // Card provides a rounded shape background for the toggle button.
        Card(
            shape = RoundedCornerShape(40.dp), // Makes the corners rounded with 40.dp radius.
        ) {
            // Inner Box serves as the clickable toggle area with background color changes.
            Box(
                modifier = Modifier
                    .background(
                        // Background color changes based on `isToggle` state.
                        if (isToggle) Color.Green else Color.Black
                    )
                    .clickable {
                        isToggle = !isToggle // Toggles the state when clicked.
                    },
                contentAlignment = Alignment.Center // Centers content within the Box.
            ) {
                if (isToggle) {
                    // When toggle is "On", display the "On" text and icon.
                    Row(
                        modifier = Modifier.padding(5.dp) // Adds padding to the Row.
                    ) {
                        // "On" text displayed when toggle is active.
                        Text(
                            text = "On",
                            style = TextStyle(
                                fontSize = 12.sp, // Sets text size.
                                fontWeight = FontWeight.W400 // Sets font weight.
                            ),
                            color = Color.Red, // Text color is red.
                            modifier = Modifier
                                .padding(start = 10.dp) // Adds padding to the start of the text.
                                .align(Alignment.CenterVertically) // Aligns text vertically in the Row.
                        )
                        // Icon representing the "On" state.
                        Icon(
                            painter = painterResource(id = R.drawable.on), // Loads "On" icon.
                            contentDescription = "", // Content description for accessibility.
                            modifier = Modifier.padding(start = 10.dp) // Adds padding to the start of the icon.
                        )
                    }
                } else {
                    // When toggle is "Off", display the "Off" icon and text.
                    Row(
                        modifier = Modifier.padding(5.dp) // Adds padding to the Row.
                    ) {
                        // Icon representing the "Off" state.
                        Icon(
                            painter = painterResource(R.drawable.off), // Loads "Off" icon.
                            contentDescription = "", // Content description for accessibility.
                            tint = Color.Unspecified // Icon color is not modified.
                        )
                        // "Off" text displayed when toggle is inactive.
                        Text(
                            text = "On", // Text "On" (misnamed, should likely be "Off").
                            style = TextStyle(
                                fontSize = 12.sp, // Sets text size.
                                fontWeight = FontWeight.W400 // Sets font weight.
                            ),
                            color = Color.White, // Text color is white.
                            modifier = Modifier
                                .padding(end = 5.dp) // Adds padding to the end of the text.
                                .align(Alignment.CenterVertically) // Aligns text vertically in the Row.
                        )
                    }
                }
            }
        }
    }
}
