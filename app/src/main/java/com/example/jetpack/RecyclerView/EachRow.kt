package com.example.jetpack.RecyclerView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

// Step 5: Create the EachRow Composable for list items
// Commit: Define a composable to represent each row in the RecyclerView, with a Card containing a Row layout.
@Composable
fun EachRow(user: User) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp) // Add horizontal and vertical padding.
            .fillMaxWidth(), // Make the Card take up the full width of the screen.
        shape = RoundedCornerShape(CornerSize(10.dp)) // Round the corners of the Card.
    ) {
        Row(
            modifier = Modifier.padding(5.dp) // Add padding inside the Row.
        ) {
            // Step 6: Add an Image in the Row
            // Commit: Display an image with a circular clip for better aesthetics.
            Image(
                imageVector = Icons.Filled.Home, // Placeholder icon for the image.
                contentDescription = "", // Content description for accessibility.
                modifier = Modifier
                    .padding(8.dp) // Padding around the image.
                    .size(80.dp) // Set a fixed size for the image.
                    .align(Alignment.CenterVertically) // Center the image vertically in the Row.
                    .clip(RoundedCornerShape(8.dp)) // Clip the image to have rounded corners.
            )

            // Step 7: Add a Text element
            // Commit: Display the title of the User object next to the image.
            Text(
                text = user.Title, // Bind the User's title to the Text.
                modifier = Modifier.padding(8.dp) // Add padding around the Text.
            )
        }
    }
}
