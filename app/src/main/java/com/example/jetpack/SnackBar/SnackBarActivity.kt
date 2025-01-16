package com.example.jetpack.SnackBar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.jetpack.state_management.ShowWidget
import com.example.jetpack.ui.theme.JetPackTheme

class StateActivity: ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class) // Using Experimental API for Material 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackTheme { // Set your app's theme
               Surface {
                   val scaffoldState = rememberScaffoldState()
                   Scaffold (
                      scaffoldState =
                      scaffoldState
                   ){
                       CreateSnackBar(scaffoldState)
                   }
               }
            }
        }
    }


}

