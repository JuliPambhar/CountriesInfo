package com.app.domain.usecase

import app.cash.turbine.test
import com.app.domain.ResponseState
import com.app.domain.entities.CountryInfo
import com.app.domain.repositories.ICountriesRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.IOException

class GetCountriesUseCaseTest {
    @Mock
    private lateinit var repository: ICountriesRepository

    private lateinit var getCountriesUseCase: GetCountriesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getCountriesUseCase = GetCountriesUseCase(repository)
    }

    @Test
    fun `when getCountries is called then return success with data`() {
        runTest {
            val successData = getFakeCountryInfo()
            `when`(repository.getCountries()).then { successData }

            val flow = getCountriesUseCase.invoke()

            flow.test {
                var emittedItem = awaitItem()
                assertEquals(true, emittedItem is ResponseState.Loading)

                emittedItem = awaitItem()
                assertEquals(true, emittedItem is ResponseState.Success)

                emittedItem = emittedItem as ResponseState.Success

                assertEquals(successData.size, emittedItem.data.size)

                cancelAndIgnoreRemainingEvents()
            }

            verify(repository).getCountries()

        }
    }

    @Test
    fun `when getCountries is throws exception then return error response state`() {
        runTest {
            val fakeThrowable = Exception("Something went wrong")
            `when`(repository.getCountries()).thenAnswer {
                throw fakeThrowable
            }
            val flow = getCountriesUseCase.invoke()

            flow.test {
                var emittedItem = awaitItem()
                assertEquals(true, emittedItem is ResponseState.Loading)

                emittedItem = awaitItem()
                assertEquals(true, emittedItem is ResponseState.Error)
                emittedItem = emittedItem as ResponseState.Error
                assertEquals(fakeThrowable.message, emittedItem.throwable.message)

                cancelAndIgnoreRemainingEvents()
            }

            verify(repository, times(1)).getCountries()

        }
    }

    @Test
    fun `when getCountries is throws IOException then return noInternet response state`() {
        runTest {
            `when`(repository.getCountries()).then {
                throw IOException()
            }
            val flow = getCountriesUseCase.invoke()

            flow.test {
                var emittedItem = awaitItem()
                assertEquals(true, emittedItem is ResponseState.Loading)

                emittedItem = awaitItem()
                assertEquals(true, emittedItem is ResponseState.NoInternet)

                cancelAndIgnoreRemainingEvents()
            }



        }
    }

    private fun getFakeCountryInfo() =
        listOf(
        CountryInfo(
            name = "a",
            region = "Region",
            population = 1000000,
            area = 10000.0,
            flag = "https://flag.com/flag.png",
            coatOfArms = "Coat of Arms",
            maps = "",
            capital = "abc"
        ),
        CountryInfo(
            name = "b",
            region = "Region",
            population = 1000000,
            area = 10000.0,
            flag = "https://flag.com/flag.png",
            coatOfArms = "Coat of Arms",
            maps = "",
            capital = "abc"
        ),
        CountryInfo(
            name = "c",
            region = "Region",
            population = 1000000,
            area = 10000.0,
            flag = "https://flag.com/flag.png",
            coatOfArms = "Coat of Arms",
            maps = "",
            capital = "abc"
        )
    )
}