package com.example.jetpack.SharedViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {
    // MutableState to hold data
    private val _res: MutableState<String> = mutableStateOf("")
    // Immutable State exposed to the UI
    val res: State<String> = _res

    // Function to update data
    fun setData(data: String) {
        _res.value = data
    }
}