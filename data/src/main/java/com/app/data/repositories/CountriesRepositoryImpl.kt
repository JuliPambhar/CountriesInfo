package com.app.data.repositories

import com.app.data.mapper.CountriesMapper
import com.app.data.network.CountriesApi
import com.app.domain.entities.CountryInfo
import com.app.domain.repositories.ICountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val countriesApi: CountriesApi,
    private val countryMapper: CountriesMapper
) :
    ICountriesRepository {

    override suspend fun getCountries(): List<CountryInfo> {
        return countryMapper.map(countriesApi.getCountries())
    }
}