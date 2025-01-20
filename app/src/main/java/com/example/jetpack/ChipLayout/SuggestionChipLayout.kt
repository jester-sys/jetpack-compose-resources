package com.example.jetpack.ChipLayout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpack.ui.theme.Purple40
import com.example.jetpack.ui.theme.Purple80

@Composable
fun SuggestionChipLayout() {
    // Mutable state holding the list of chip labels
    var chipsData by remember { mutableStateOf(listOf("India", "France", "Spain")) }
    // Mutable state to track which chip is selected
    var chipState by remember { mutableStateOf("") }

    // Main layout container
    Column(
        modifier = Modifier
            .fillMaxSize() // Makes the Column fill the entire available screen space
            .padding(horizontal = 15.dp), // Adds horizontal padding to the Column
        horizontalAlignment = Alignment.CenterHorizontally, // Aligns child elements horizontally at the center
        verticalArrangement = Arrangement.Center // Aligns child elements vertically at the center
    ) {
        // A horizontal row to arrange the chips
        Row(
            modifier = Modifier.fillMaxWidth(), // Makes the Row fill the width of the screen
            horizontalArrangement = Arrangement.SpaceBetween // Adds equal spacing between chips
        ) {
            // Iterates through the list of chips and displays each one
            chipsData.forEach { chip ->
                SuggestionChipEachRow(
                    label = chip, // Passes the label of the chip
                    selected = chip == chipState // Determines if the current chip is selected
                ) { selectedChip ->
                    chipState = selectedChip // Updates the selected chip state
                }
            }
        }
    }
}

@Composable
fun SuggestionChipEachRow(
    label: String, // Text label for the chip
    selected: Boolean, // Whether the chip is currently selected
    onChipChange: (String) -> Unit // Callback to notify when the chip state changes
) {
    SuggestionChip(
        onClick = {
            if (!selected) {
                onChipChange(label) // If not selected, set this chip as selected
            } else {
                onChipChange("") // If already selected, deselect it
            }
        },
        label = {
            Text(text = label) // Displays the chip label text
        },
        modifier = Modifier.padding(horizontal = 10.dp), // Adds horizontal padding around the chip
        shape = RoundedCornerShape(8.dp), // Sets the chip shape to have rounded corners
        colors = SuggestionChipDefaults.suggestionChipColors(
            // Changes chip color based on selection state
            containerColor = if (selected) Purple80 else Color.Transparent
        ),
        border = if (selected) null else BorderStroke(1.dp, Purple40) // Adds a border only if the chip is not selected
    )
}
