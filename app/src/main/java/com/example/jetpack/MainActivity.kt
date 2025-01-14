package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.ui.LoginScreen
import com.example.jetpack.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ensure this method is defined
        setContent {
            JetPackTheme { // Ensure JetPackTheme is properly defined in your app
                Surface(color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text("App Name") // Set your app name here
                                },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        // Navigation icon click logic here
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Menu,
                                            contentDescription = "Menu"
                                        )
                                    }
                                },
                                actions = {
                                    IconButton(onClick = {
                                        // Search icon click logic here
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = "Search"
                                        )
                                    }
                                    IconButton(onClick = {
                                        // Notifications icon click logic here
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Notifications,
                                            contentDescription = "Notifications"
                                        )
                                    }
                                }
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {
                                // Floating Action Button click logic here
                            }) {
                                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                            }
                        }
                    ) { innerPadding ->

                        RecyclerView(data = dummyData())
                        // Content inside the Scaffold
//                        LoginScreen(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        JetPackTheme {
            Greeting("Android")
        }

    }

    @Composable
    fun ShowSwitch(modifier: PaddingValues) {
        val isChecked = remember {
            mutableStateOf(true)
        }
        Switch(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it
            },
            modifier = Modifier.run {
                size(20.dp)
                padding(100.dp)
            }
        )
    }
}

@Composable
fun EachRow(user: User) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)),
//        elevation = CardElevation(2.dp)
    ) {
        Row (
            modifier = Modifier.padding(5.dp)
        ){
            Image(imageVector = Icons.Filled.Home, contentDescription = "",
                 modifier = Modifier
                     .padding(8.dp)
                     .size(80.dp)
                     .align(Alignment.CenterVertically)
                     .clip(
                         RoundedCornerShape(8.dp)
                     )
            )
            Text(text = user.Title, modifier = Modifier.padding(8.dp))
        }
    }


}


@Composable
fun RecyclerView(data:List<User>) {
    LazyColumn (){
        items(data){ user ->
            EachRow(user = user)
        }
    }

}
