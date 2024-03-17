package com.example.olympicsquest

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object SportPage: Screen(route = "sport_screen"+"/{sport}"+"/{epreuve}"+"/{session}"+"/{date}"+"/{lieu}"+"/{startTime}"+"/{endTime}"+"/{geo_point}")
    //object SportPage: Screen(route = "sport_screen")
}