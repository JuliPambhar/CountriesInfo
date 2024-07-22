package com.app.data.network.entities

data class CountryDTO(
    val name: Name,
    val region: String?,
    val capital: List<String>,
    val population: Int?,
    val area: Double?,
    val flags: Flags,
    val coatOfArms: CoatOfArms,
    val maps: Maps,
)

data class Name(
    val common: String?,
)

data class Flags(
    val png: String?
)

data class CoatOfArms(
    val png: String?,
)

data class Maps(
    val googleMaps: String?,
)
