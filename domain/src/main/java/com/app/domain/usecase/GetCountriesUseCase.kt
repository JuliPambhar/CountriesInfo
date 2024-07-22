package com.app.domain.usecase

import com.app.domain.ResponseState
import com.app.domain.entities.CountryInfo
import com.app.domain.repositories.ICountriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(private val countriesRepository: ICountriesRepository) {

    suspend fun invoke(): Flow<ResponseState<List<CountryInfo>>> {
        return flow {
            try {
                emit(ResponseState.Loading())
                emit(ResponseState.Success(countriesRepository.getCountries()))
            } catch (ioException: IOException) {
                emit(ResponseState.NoInternet())
            } catch (exception: Exception) {
                emit(ResponseState.Error(exception))
            }
        }

    }
}