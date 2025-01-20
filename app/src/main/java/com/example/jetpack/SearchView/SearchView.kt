package com.example.jetpack.SearchView

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun SearchView() {
    // Create a mutable state variable to hold the user's search query.
    var search by remember { mutableStateOf("") }

    // Define a static list of items to display and filter.
    val lists = listOf(
        "Lion",     // Item 1 in the list
        "Apple",    // Item 2 in the list
        "Monkey",   // Item 3 in the list
        "Money",    // Item 4 in the list
        "Cheetah",  // Item 5 in the list
        "Banana",   // Item 6 in the list
        "Beer"      // Item 7 in the list
    )

    // LazyColumn is used to display a scrollable list of items efficiently.
    LazyColumn(
        modifier = Modifier.padding(20.dp) // Adds padding around the LazyColumn
    ) {
        // Filter the list based on the search query.
        val filterList: List<String> = if (search.isEmpty()) {
            // If search query is empty, show the full list.
            lists
        } else {
            // Otherwise, filter the list to show only items matching the query.
            val result = arrayListOf<String>()
            for (temp in lists) {
                // Check if the item contains the search query (case-insensitive).
                if (temp.lowercase(Locale.getDefault()).contains(
                        search.lowercase(Locale.getDefault())
                    )
                ) {
                    result.add(temp) // Add the matching item to the result list.
                }
            }
            result
        }

        // Add a custom search bar at the top of the LazyColumn.
        item {
            CustomSearchView(
                text = search, // Pass the current search query to the search bar.
                onValueChange = {
                    search = it // Update the search query when the text changes.
                }
            )
        }

        // Add the filtered list items to the LazyColumn.
        items(filterList) { data ->
            // Display each item as a Text composable with some padding.
            Text(
                text = data, // Display the filtered item.
                modifier = Modifier.padding(top = 8.dp) // Add spacing between items.
            )
        }
    }
}

@Composable
fun CustomSearchView(
    text: String, // The current search query.
    onValueChange: (String) -> Unit // Callback to notify the parent of text changes.
) {
    // TextField to allow the user to input the search query.
    TextField(
        value = text, // Bind the current text to the TextField.
        onValueChange = {
            onValueChange(it) // Notify the parent composable of the text change.
        },
        modifier = Modifier.fillMaxWidth(), // Make the TextField span the full width.
        placeholder = {
            // Placeholder text is shown when the TextField is empty.
            Text(text = "Search")
        },
        leadingIcon = {
            // Add a search icon to the left of the TextField.
            Icon(Icons.Default.Search, contentDescription = "", tint = Color.Black)
        },
        colors = TextFieldDefaults.textFieldColors(
            // Set the TextField background color to transparent.
            backgroundColor = Color.Transparent
        )
    )
}
