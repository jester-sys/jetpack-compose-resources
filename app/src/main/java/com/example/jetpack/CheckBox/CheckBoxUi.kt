package com.example.jetpack.CheckBox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxUi() {
    var isChecked by remember { mutableStateOf(false) }
    // Tracks the state of the default checkbox (checked or unchecked).

    Column(
        modifier = Modifier
            .fillMaxSize() // Makes the column fill the entire screen.
            .padding(), // Adds padding to the column (default padding).
        horizontalAlignment = Alignment.CenterHorizontally, // Aligns children horizontally to the center.
        verticalArrangement = Arrangement.Center // Aligns children vertically to the center.
    ) {
        Checkbox(
            checked = isChecked, // Binds the checkbox state to `isChecked`.
            onCheckedChange = {
                isChecked = it // Updates `isChecked` when the checkbox is toggled.
            },
//            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(8.dp))
            // (Commented) Custom size and shape for the checkbox.
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue, // Checkbox color when checked.
                checkmarkColor = Color.Cyan // Color of the checkmark when checked.
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        // Adds vertical space between the default checkbox and the custom checkbox.
        CustomCheckBox()
        // Invokes the custom checkbox composable defined below.
    }
}

@Composable
fun CustomCheckBox() {
    var isCheck by remember { mutableStateOf(false) }
    // Tracks the state of the custom checkbox (checked or unchecked).

    Row(
        modifier = Modifier
            .fillMaxWidth() // Makes the row stretch to fill the screen width.
            .padding(), // Adds default padding to the row.
        horizontalArrangement = Arrangement.Center // Centers the row's children horizontally.
    ) {
        Card(
            shape = RoundedCornerShape(8.dp), // Gives the card rounded corners with a radius of 8.dp.
            backgroundColor = Color.White, // Sets the card's background color to white.
            border = BorderStroke(1.dp, color = Color.Black)
            // Adds a black border around the card with a thickness of 1.dp.
        ) {
            Box(
                modifier = Modifier
                    .background(
                        if (isCheck) Color.Green else Color.Gray
                        // Changes the background color based on `isCheck` state.
                    )
                    .clickable {
                        isCheck = !isCheck
                        // Toggles the state of `isCheck` when the box is clicked.
                    }
                    .size(25.dp), // Sets the size of the box to 25.dp x 25.dp.
                contentAlignment = Alignment.Center // Centers the content inside the box.
            ) {
                if (isCheck) // If the checkbox is checked:
                    Icon(
                        Icons.Default.Check, // Displays a checkmark icon.
                        contentDescription = "", // No description for accessibility.
                        tint = Color.White // Sets the color of the icon to white.
                    )
            }
        }
        Text(
            text = "Accept All terms & conditions", // Displays the checkbox label.
            modifier = Modifier
                .padding(start = 5.dp) // Adds space between the box and the text.
                .align(Alignment.CenterVertically)
            // Aligns the text vertically in the center of the row.
        )
    }
}
