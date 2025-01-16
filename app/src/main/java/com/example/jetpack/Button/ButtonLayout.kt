package com.example.jetpack.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonLayout() {
    Column( // Creates a vertical column layout.
        modifier = Modifier.fillMaxSize(), // Makes the column occupy the entire screen.
        horizontalAlignment = Alignment.CenterHorizontally, // Aligns children horizontally to the center of the column.
        verticalArrangement = Arrangement.Center // Aligns children vertically in the center of the column.
    ) {
        Button( // Creates a clickable button.
            onClick = {
                // Add your click logic here
                // This is where the action on button click will be defined.
            },
            elevation = ButtonDefaults.buttonElevation(pressedElevation = 10.dp),
            // Defines button elevation when pressed, giving a shadow effect.
            shape = RoundedCornerShape(10.dp),
            // Gives the button rounded corners with a radius of 10dp.
            border = BorderStroke(2.dp, color = Color.Red),
            // Adds a border around the button with a width of 2dp and color red.
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                // Sets the background color of the button to yellow.
                contentColor = Color.Black
                // Sets the text/content color of the button to black.
            )
        ) {
            Text(text = "Simple Button")
            // Displays the text "Simple Button" inside the button.
        }
    }
}
