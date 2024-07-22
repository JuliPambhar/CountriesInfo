package com.app.data.network

import com.app.data.network.entities.CountryDTO
import retrofit2.http.GET

interface CountriesApi {

    @GET("independent?status=true")
    suspend fun getCountries(): List<CountryDTO>
}