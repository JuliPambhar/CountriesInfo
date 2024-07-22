package com.app.data.di

import com.app.data.mapper.CountriesMapper
import com.app.data.network.CountriesApi
import com.app.data.repositories.CountriesRepositoryImpl
import com.app.domain.repositories.ICountriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCountriesRepository(
        countriesApi: CountriesApi,
        countryMapper: CountriesMapper
    ): ICountriesRepository {
        return CountriesRepositoryImpl(
            countriesApi = countriesApi,
            countryMapper = countryMapper
        )
    }
}