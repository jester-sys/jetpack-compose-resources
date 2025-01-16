package com.example.jetpack.PickImage

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp


@Composable
fun CameraPickImage() {
    // Function to pick an image from the camera using `ActivityResultContracts.TakePicturePreview`.
    // The image is displayed in the UI once captured.

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    // Declares a mutable state to hold the captured image as a `Bitmap`.
    // The `remember` function ensures the state survives recomposition.

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
        // Defines an `ActivityResultContract` to take a picture and return a `Bitmap`.
    ) {
        bitmap = it
        // Updates the `bitmap` state when the image is captured.
    }

    Column(
        modifier = Modifier
            .fillMaxSize() // Makes the column fill the entire screen.
            .padding(vertical = 20.dp) // Adds vertical padding of 20dp around the column.
    ) {
        Button(
            onClick = {
                launcher.launch()
                // Launches the camera intent when the button is clicked.
            }
        ) {
            Text(text = "Pick image from camera")
            // Text displayed inside the button.
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Adds vertical spacing between the button and the image preview.

        bitmap?.let {
            // If a `bitmap` is available (non-null), this block is executed.
            Image(
                bitmap = it.asImageBitmap(),
                // Converts the `Bitmap` to `ImageBitmap` for displaying.
                contentDescription = null,
                // No content description provided (useful for accessibility purposes).
                modifier = Modifier.size(200.dp)
                // Sets the size of the displayed image to 200dp x 200dp.
            )
        }
    }
}
