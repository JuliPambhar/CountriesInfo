package com.app.data.repositories

import com.app.data.mapper.CountriesMapper
import com.app.data.network.CountriesApi
import com.app.data.network.entities.CoatOfArms
import com.app.data.network.entities.CountryDTO
import com.app.data.network.entities.Flags
import com.app.data.network.entities.Maps
import com.app.data.network.entities.Name
import com.app.domain.entities.CountryInfo
import com.app.domain.repositories.ICountriesRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class CountriesRepositoryImplTest {
    @Mock
    private lateinit var countriesApi: CountriesApi

    @Mock
    private lateinit var countriesMapper: CountriesMapper

    private lateinit var repository: ICountriesRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = CountriesRepositoryImpl(countriesApi, countriesMapper)
    }


    @Test
    fun testCountriesInfo() {
        runTest {
            val countriesDTO =
                listOf(
                    CountryDTO(
                        name = Name("a"),
                        region = "Region",
                        population = 1000000,
                        area = 10000.0,
                        flags = Flags("https://flag.com/flag.png"),
                        coatOfArms = CoatOfArms("Coat of Arms"),
                        maps = Maps(""),
                        capital = listOf()
                    ),
                    CountryDTO(
                        name = Name("b"),
                        region = "Region",
                        population = 1000000,
                        area = 10000.0,
                        flags = Flags("https://flag.com/flag.png"),
                        coatOfArms = CoatOfArms("Coat of Arms"),
                        maps = Maps(""),
                        capital = listOf()
                    ),
                    CountryDTO(
                        name = Name("c"),
                        region = "Region",
                        population = 1000000,
                        area = 10000.0,
                        flags = Flags("https://flag.com/flag.png"),
                        coatOfArms = CoatOfArms("Coat of Arms"),
                        maps = Maps(""),
                        capital = listOf()
                    )
                )
            val countriesInfo =
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

            `when`(countriesApi.getCountries()).thenReturn(countriesDTO)
            `when`(countriesMapper.map(countriesDTO)).thenReturn(countriesInfo)
            val result = repository.getCountries()
            assert(result == countriesInfo)
            verify(countriesMapper).map(countriesDTO)
        }
    }


}