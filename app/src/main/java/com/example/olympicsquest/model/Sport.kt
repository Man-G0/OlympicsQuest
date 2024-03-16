package com.example.olympicsquest.model

class Sport(
    val name: String,
    val startTime : String,
    val endTime : String,
    val cession : String,
    val localisation : String) {
    override fun toString(): String {
        return "Sport(name='$name', startTime='$startTime', endTime='$endTime', cession='$cession', localisation='$localisation')"
    }
}