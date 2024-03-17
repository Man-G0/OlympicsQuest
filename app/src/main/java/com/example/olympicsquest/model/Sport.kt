package com.example.olympicsquest.model

class Sport(

    val date: String = "",
    val epreuve : String = "",
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
    """.trimIndent()
    }
}