package com.example.olympicsquest.sealed

import com.example.olympicsquest.model.Sport

sealed class DataState {
    class Success (val data:MutableList<Sport>): DataState()
    class Failure (val message: String): DataState()
    object Loading: DataState()
    object Empty: DataState()
}