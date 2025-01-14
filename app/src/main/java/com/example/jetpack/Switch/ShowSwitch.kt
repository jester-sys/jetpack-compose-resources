package com.example.jetpack.Switch


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowSwitch() {
    // Step 1: Initialize the switch state
    // Using remember to retain state across recompositions (avoiding state reset).
    // Commit: Initialize a mutable state to handle the switch's checked state.
    val isChecked = remember { mutableStateOf(true) }

    // Step 2: Define the Switch composable
    // Commit: Create a Switch component that reacts to user interaction and updates its state dynamically.
    Switch(
        // Step 3: Bind the switch's state to isChecked.value
        // Commit: Ensure the Switch reflects the current state of isChecked.
        checked = isChecked.value,

        // Step 4: Update state when the switch is toggled
        // Commit: Provide an onCheckedChange callback to modify the isChecked state on user interaction.
        onCheckedChange = { isChecked.value = it },

        // Step 5: Apply modifiers to style the switch
        // Commit: Use Modifier to define padding and size for the Switch.
        modifier = Modifier
            .padding(8.dp) // Adds space around the switch for proper layout.
            .size(60.dp) // Ensures the switch has a consistent size.
    )
}
