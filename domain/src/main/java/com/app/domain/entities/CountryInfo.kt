package com.app.domain.entities

data class CountryInfo(
    val name: String = "",
    val region: String = "",
    val population: Int = 0,
    val area: Double = 0.0,
    val flag: String = "",
    val coatOfArms: String = "",
    val maps: String = "",
    val capital: String = "",

) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            name.contains(query, ignoreCase = true)
        )
        return matchingCombinations.any { it }
    }
}