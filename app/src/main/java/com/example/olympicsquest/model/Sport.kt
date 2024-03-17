package com.example.olympicsquest.model

class Sport(

    val date: String = "",
    val epreuve : String = "",
    val geo_point : String = "",
    val horaire_debut : String = "",
    val horaire_fin : String = "",
    val lieu : String = "",
    val session : String = "",
    val sport : String = "") {
    override fun toString(): String {
        return """
        Sport: $sport
        Épreuve: $epreuve
        Session: $session
        Date: $date
        Lieu: $lieu
        Horaire de début: $horaire_debut
        Horaire de fin: $horaire_fin
        Geographic point : $geo_point
    """.trimIndent()
    }
    fun doesMatchSearchQuery(query: String): Boolean{
        val matchingCombination = listOf(
            "$date",
            "$horaire_debut",
            "${horaire_debut.first()}",
            "$horaire_fin",
            "$lieu",
            "${lieu.first()}",
            "$session",
            "${session.first()}",
            "$sport",
            "${sport.first()}",
        )
        return matchingCombination.any {
            it.contains(query, ignoreCase = true)
        }
    }
}