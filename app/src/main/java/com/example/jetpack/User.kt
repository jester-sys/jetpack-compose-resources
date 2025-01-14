package com.example.jetpack

data class User(
    val Title :String
)
fun dummyData() :List<User>{
    return  listOf(
        User(
            "Title 1"
        ),
        User(
            "Title 2"
        ),
        User(
            "Title 3"
        ),
        User(
            "Title 4"
        ),
        User(
            "Title 5"
        )
    )
}