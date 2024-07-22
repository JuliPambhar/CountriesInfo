package com.app.domain.repositories

import com.app.domain.entities.CountryInfo

interface ICountriesRepository {
    suspend fun getCountries(): List<CountryInfo>
}