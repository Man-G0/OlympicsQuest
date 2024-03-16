package com.example.olympicsquest.ui.theme

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Meteo: Screen(route = "meteo_screen"+"/{cityName}"+"/{temp}"+"/{meteo}"+"/{highTemp}"+"/{lowTemp}")
}