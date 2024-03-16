package com.example.olympicsquest

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object SportPage: Screen(route = "sport_screen"+"/{event}")
}