package com.example.jetpack.RecyclerView

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable


// Step 3: Define the main RecyclerView Composable
// Commit: Create a LazyColumn to act as a RecyclerView for displaying a list of items.
@Composable
fun RecyclerView(data: List<User>) {
    LazyColumn {
        // Step 4: Use the `items` function to bind the data
        // Commit: Iterate over the list of User objects and display each using the `EachRow` composable.
        items(data) { user ->
            EachRow(user = user)
        }
    }
}