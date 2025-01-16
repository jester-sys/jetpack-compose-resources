package com.example.jetpack.DialogBox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.jetpack.ui.theme.JetPackTheme

@OptIn(ExperimentalMaterial3Api::class) // Enable experimental features for Material3
class DialogActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class) // Enable experimental features for Material
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the UI content of the activity
        setContent {
            JetPackTheme { // Apply the JetPack theme for consistent styling

                Surface(

                    color = MaterialTheme.colorScheme.background // Set the background color


                ) {
                  //  DialogScreen()
                    AlertDialogScreen()
                }
            }
        }
    }
}
