package com.example.jetpack.SearchView

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.jetpack.ChipLayout.SuggestionChipLayout
import com.example.jetpack.ui.theme.JetPackTheme


class SearchViewActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class) // Using Experimental API for Material 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackTheme { // Set your app's theme
                Surface(
                    color = MaterialTheme.colorScheme.background // Set the background color from Material Theme
                ) {
                   SearchView() // Pass innerPadding to the composable
                }
            }
        }
    }

}