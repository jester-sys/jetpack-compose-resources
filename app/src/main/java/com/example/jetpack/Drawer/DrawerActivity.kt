package com.example.jetpack.Drawer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.example.jetpack.Radio.RadioButtonUi
import com.example.jetpack.SnackBar.CreateSnackBar
import com.example.jetpack.ui.theme.JetPackTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class) // Enable experimental features for Material3
class DrawerActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterialApi::class) // Enable experimental features for Material
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the UI content of the activity
        setContent {
            JetPackTheme { // Apply the JetPack theme for consistent styling
                Surface {
                    val  scope = rememberCoroutineScope()
                    val scaffoldState = rememberScaffoldState()
                    Scaffold (
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            Column {
                                IconButton(onClick = {
                                    scope.launch {

                                        scaffoldState.drawerState.close()
                                    }
                                }) {
                                    Icon(Icons.Default.Close, contentDescription = "", tint = Color.Blue)

                                }
                                Text(text = "Drawer Content")
                            }
                        },
                        drawerGesturesEnabled = false
                    ){
                        CreateSnackBar(scaffoldState)
                    }
                }
            }
        }
    }
}