package com.app.countriesinfo.ui.screens

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.app.countriesinfo.ui.connectivityUtils.ConnectivityObserver
import com.app.countriesinfo.utils.UiState
import com.app.domain.ResponseState
import com.app.domain.entities.CountryInfo
import com.app.domain.usecase.GetCountriesUseCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class CountryListViewModelTest {

    @Mock
    private lateinit var getCountriesUseCase: GetCountriesUseCase

    private lateinit var viewModel: CountryListViewModel

    private val testDispatcher = StandardTestDispatcher()

    private val viewData = CountryListViewModel.ViewData()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var connectivityObserver: ConnectivityObserver

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)

        viewModel = CountryListViewModel(connectivityObserver, getCountriesUseCase)
    }

    @OptIn(DelicateCoroutinesApi::class)
    @After
    fun close() {
        Dispatchers.shutdown()
    }

    @Test
    fun testViewModelWithDefaultData() {
        assertEquals(viewData.state, viewModel.viewData.value.state)
        assertEquals(viewData.errorMessage, viewModel.viewData.value.errorMessage)
        assertEquals(viewData.countries.size, viewModel.viewData.value.countries.size)
    }

    @Test
    fun `test fetchCountries emits loading and success states`() {
        runTest {
            val mockCountries = getFakeCountryInfo()
            `when`(getCountriesUseCase.invoke()).then {
                val flow = flowOf(
                    ResponseState.Loading(),
                    ResponseState.Success(mockCountries)
                )
                return@then flow
            }

            viewModel.fetchCountries()
            viewModel.viewData.test {
                var emittedItem = awaitItem()
                assertEquals(UiState.LOADING, emittedItem.state)

                emittedItem = awaitItem()
                assertEquals(UiState.LOADED, emittedItem.state)
                assertEquals(mockCountries, emittedItem.countries)
                //it will not wait for other event and exit the testcase.
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `when fetchCountries fails, then populate viewData with Error state`() {
        runTest {
            val fakeFailureMsg = "Fake Failure"
            `when`(getCountriesUseCase.invoke()).thenReturn(
                flowOf(
                    ResponseState.Loading(),
                    ResponseState.Error(Throwable(fakeFailureMsg))
                )
            )
            viewModel.fetchCountries()

            viewModel.viewData.test {
                var emittedItem = awaitItem()
                assertEquals(UiState.LOADING, emittedItem.state)

                emittedItem = awaitItem()
                assertEquals(UiState.ERROR, emittedItem.state)
                assertEquals(fakeFailureMsg, emittedItem.errorMessage)

                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `when fetchCountries fails with no internet, then populate viewData with No Internet state`() {
        runTest {
            `when`(getCountriesUseCase.invoke()).thenReturn(
                flowOf(
                    ResponseState.Loading(),
                    ResponseState.NoInternet()
                )
            )
            viewModel.fetchCountries()

            viewModel.viewData.test {
                var emittedItem = awaitItem()
                assertEquals(UiState.LOADING, emittedItem.state)

                emittedItem = awaitItem()
                assertEquals(UiState.NO_INTERNET, emittedItem.state)

                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `onSearch should update viewData with filtered countries`() = runTest {
        val mockCountries = getFakeCountryInfo()
        viewModel.populateCountries(mockCountries)
        viewModel.onSearch("Country1")
        viewModel.viewData.test {
            var emittedItem = awaitItem()
            assertEquals(UiState.LOADING, emittedItem.state)
            emittedItem = awaitItem()
            assertEquals(mockCountries.filter { it.name == "Country1" }, emittedItem.countries)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `setNoInternet should update viewData with No Internet state`() {
        runTest {
            viewModel.setNoInternet()

            viewModel.viewData.test {
                val emittedItem = awaitItem()

                assertEquals(UiState.NO_INTERNET, emittedItem.state)

                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `getCountryByName should update selectedCountry value`() = runTest {
        // Given
        val mockCountries = listOf(CountryInfo(name = "Country1"), CountryInfo(name = "Country2"))
        viewModel.populateCountries(mockCountries)
        // When
        val selectedCountry = viewModel.getCountryByName("Country1")

        // Then
        assertEquals(CountryInfo(name = "Country1"), selectedCountry)
        assertEquals(CountryInfo(name = "Country1"), viewModel.selectedCountry.value)
    }

    private fun getFakeCountryInfo() = listOf(
        CountryInfo(
            name = "Country1",
            region = "Region",
            population = 1000000,
            area = 10000.0,
            flag = "https://flag.com/flag.png",
            coatOfArms = "Coat of Arms",
            maps = "",
            capital = "abc"
        ), CountryInfo(
            name = "Country2",
            region = "Region",
            population = 1000000,
            area = 10000.0,
            flag = "https://flag.com/flag.png",
            coatOfArms = "Coat of Arms",
            maps = "",
            capital = "abc"
        ), CountryInfo(
            name = "Country3",
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