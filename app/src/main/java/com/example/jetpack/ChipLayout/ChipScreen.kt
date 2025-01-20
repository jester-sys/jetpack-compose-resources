package com.example.jetpack.ChipLayout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpack.ui.theme.Purple80
import com.example.jetpack.ui.theme.PurpleGrey40
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun FilterChipLayout() {
    // A mutable state holding a list of chip labels
    var list by remember {
        mutableStateOf(
            listOf(
                "chip1", // Chip label 1
                "chip2", // Chip label 2
                "chip 3", // Chip label 3
                "chip 4", // Chip label 4
                "chip 5"  // Chip label 5
            )
        )
    }

    // A temporary set to hold the indices of selected chips, initially empty
    val tempList: Set<Int> = emptySet()

    // Center-aligned Box layout to contain the chips
    Box(
        modifier = Modifier.fillMaxSize(), // Makes the Box fill the entire screen
        contentAlignment = Alignment.Center // Aligns its content to the center
    ) {
        // Calls the ChipEachRow function to render chips with the provided list and tempList
        ChipEachRow(list = list, tempList = tempList)
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Opting in to use experimental Material3 APIs
@Composable
fun ChipEachRow(
    list: List<String>, // List of chip labels
    tempList: Set<Int> // Set of indices for selected chips
) {
    // A mutable state holding the current selection of chips, initialized with tempList
    var multipleChecked by rememberSaveable { mutableStateOf(tempList) }

    // A FlowRow layout to display chips in a flow pattern
    FlowRow(
        modifier = Modifier
            .fillMaxWidth() // Ensures the row spans the entire width
            .padding(20.dp), // Adds padding around the FlowRow
        crossAxisSpacing = 16.dp, // Space between rows
        mainAxisSpacing = 16.dp  // Space between chips in the same row
    ) {
        // Iterates over the chip list, assigning an index and label to each chip
        list.forEachIndexed { index, s ->
            FilterChip(
                selected = multipleChecked.contains(index), // Marks the chip as selected if its index is in `multipleChecked`
                onClick = {
                    // Toggles chip selection state
                    multipleChecked = if (multipleChecked.contains(index))
                        multipleChecked.minus(index) // Deselects the chip by removing its index
                    else
                        multipleChecked.plus(index)  // Selects the chip by adding its index
                },
                enabled = true, // Makes the chip clickable
                label = {
                    Text(text = s) // Displays the chip's label text
                },
                border = FilterChipDefaults.filterChipBorder(
                    // Sets the chip's border based on its selection state
                    borderColor = if (multipleChecked.contains(index)) Color.Transparent else PurpleGrey40,
                    borderWidth = if (multipleChecked.contains(index)) 0.dp else 2.dp,
                    selected = multipleChecked.contains(index), // Highlights the border if selected
                    enabled = true // Keeps the border enabled
                ),
                colors = FilterChipDefaults.filterChipColors(
                    // Sets the background color based on selection state
                    containerColor = if (multipleChecked.contains(index)) Purple80 else Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp), // Gives the chip rounded corners
                trailingIcon = {
                    // Adds a trailing check icon for selected chips
                    if (multipleChecked.contains(index)) Icon(
                        Icons.Default.Check, // Default checkmark icon
                        contentDescription = null // No description for accessibility
                    ) else null
                }
            )
        }
    }
}


