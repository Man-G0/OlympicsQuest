package com.example.olympicsquest

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object SportPage: Screen(route = "sport_screen"+"{sport}"+"/{epreuve}"+"/{session}"+"/{date}"+"/{lieu}"+"/{horaire_debut}"+"/{horaire_fin}"+"/{geo_point}")
}