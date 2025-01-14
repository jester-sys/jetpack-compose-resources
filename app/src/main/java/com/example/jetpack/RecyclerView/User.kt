package com.example.jetpack.RecyclerView

// Step 1: Define the User data model
// Commit: Create a data class to represent each item in the list.
data class User(
    val Title: String // Holds the title of each item.
)

// Step 2: Create a function to generate dummy data
// Commit: Add a function that returns a list of User objects for demonstration purposes.
fun dummyData(): List<User> {
    return listOf(
        User("Title 1"),
        User("Title 2"),
        User("Title 3"),
        User("Title 4"),
        User("Title 5")
    )
}



