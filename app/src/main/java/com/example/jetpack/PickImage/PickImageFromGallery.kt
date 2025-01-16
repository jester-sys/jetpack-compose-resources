package com.example.jetpack.PickImage

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun PickImageFromGallery() {
    // Function to pick an image from the gallery and display it in the UI.

    val context = LocalContext.current
    // Access the current context for operations like resolving content URIs.

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    // A mutable state to store the URI of the selected image.
    // `remember` ensures the state is preserved across recompositions.

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    // A mutable state to hold the `Bitmap` representation of the image.

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
        // Defines a contract to pick content from the gallery.
    ) {
        imageUri = it
        // Updates the `imageUri` state with the URI of the selected image.
    }

    Column(
        modifier = Modifier
            .fillMaxWidth() // Makes the column span the full width of the screen.
            .padding(vertical = 20.dp), // Adds vertical padding of 20dp.
        horizontalAlignment = Alignment.CenterHorizontally // Aligns child components to the center horizontally.
    ) {
        Button(
            onClick = {
                launcher.launch("image/*")
                // Launches the gallery picker with the MIME type filter for images.
            }
        ) {
            Text(text = "Pick image from gallery")
            // Button text prompting the user to pick an image.
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Adds vertical spacing between the button and the image preview.

        imageUri?.let {
            // Executes this block only if `imageUri` is not null (an image has been selected).

            bitmap = if (Build.VERSION.SDK_INT < 28) {
                // For Android versions below API 28:
                MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                // Retrieves the `Bitmap` from the image URI using the `MediaStore` API.
            } else {
                // For Android versions API 28 and above:
                val source = ImageDecoder.createSource(context.contentResolver, it)
                // Creates an `ImageDecoder.Source` from the image URI.
                ImageDecoder.decodeBitmap(source)
                // Decodes the image source into a `Bitmap`.
            }

            Image(
                bitmap = bitmap?.asImageBitmap()!!,
                // Converts the `Bitmap` to `ImageBitmap` for displaying.
                contentDescription = null,
                // Content description (useful for accessibility, left null here).
                modifier = Modifier.size(200.dp)
                // Sets the displayed image size to 200dp x 200dp.
            )
        }
    }
}
