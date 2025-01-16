package com.example.jetpack.Drawer

import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch


@Composable
fun CreateDrawer(scaffoldState: ScaffoldState) {
    // Function to create a drawer and open it when the button is clicked.
    // It takes `scaffoldState` as a parameter, which controls the drawer state.

    val scope = rememberCoroutineScope()
    // Creates a coroutine scope that survives recomposition, used to handle asynchronous operations.

    IconButton(onClick = {
        // Button with an icon. When clicked, it triggers the logic inside the block.
        scope.launch {
            // Launches a coroutine to perform the drawer opening operation.
            scaffoldState.drawerState.open()
            // Opens the drawer using `scaffoldState.drawerState`.
        }
    }) {
        Icon(
            Icons.Default.List,
            // Displays a default list icon from the Material Icons library.
            contentDescription = "",
            // Description for accessibility, empty string here means no description.
            tint = Color.Blue
            // Sets the icon's color to blue.
        )
    }
}
