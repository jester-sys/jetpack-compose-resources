package com.example.jetpack.Radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RadioButtonUi() {
    // A list of gender options for the Radio Buttons.
    val genderList by remember { mutableStateOf(listOf("Male", "Female", "Others")) }

    // State variable to hold the currently selected gender.
    var genderState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Makes the column span the entire screen height and width.
            .padding(), // Adds default padding around the column.
        horizontalAlignment = Alignment.CenterHorizontally, // Centers child elements horizontally.
        verticalArrangement = Arrangement.Center // Aligns child elements vertically in the center.
    ) {
        Row(
            modifier = Modifier.fillMaxWidth() // Makes the row span the entire screen width.
        ) {
            genderList.forEach { genderOption ->
                // Loops through the gender list to create a RadioButton for each gender.
                Row {
                    // A row for each radio button and its associated label.

                    Text(
                        text = genderOption, // Displays the gender option text.
                        Modifier.align(Alignment.CenterVertically) // Aligns the text vertically with the RadioButton.
                    )

                    RadioButton(
                        selected = genderState == genderOption,
                        // Sets the selected state to true if the current genderOption matches the selected state.
                        onClick = {
                            genderState = genderOption
                            // Updates the state with the selected gender.
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Red // Sets the color of the selected RadioButton to red.
                        )
                    )
                }
            }
        }
        Text(text = genderState)
        // Displays the currently selected gender below the RadioButtons.
    }
}
