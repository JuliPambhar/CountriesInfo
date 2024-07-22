package com.app.countriesinfo.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.countriesinfo.ui.connectivityUtils.ConnectivityObserver
import com.app.countriesinfo.utils.UiState
import com.app.domain.ResponseState
import com.app.domain.entities.CountryInfo
import com.app.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    val connectionState: ConnectivityObserver,
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    private val _viewData = MutableStateFlow(ViewData())
    val viewData: StateFlow<ViewData> get() = _viewData.asStateFlow()

    private val _selectedCountry = MutableStateFlow(CountryInfo())
    val selectedCountry = _selectedCountry.asStateFlow()

    private var _allCountries = mutableListOf<CountryInfo>()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearch(query: String) {
        viewModelScope.launch {
            _searchText.value = query
            // Perform the search (replace with actual search logic)
            val results = _allCountries.filter { it.doesMatchSearchQuery(query) }

            // Update the search results
            _viewData.value = _viewData.value.copy(
                state = UiState.LOADED,
                countries = results
            )
        }
    }

    @VisibleForTesting
    fun populateCountries(countries: List<CountryInfo>) {
        _allCountries = countries.toMutableList()
    }

    fun onCountrySelected(countryName: String): CountryInfo {
        _selectedCountry.value = _allCountries.find { it.name == countryName } ?: CountryInfo()
        return _selectedCountry.value
    }

    fun fetchCountries() {
        viewModelScope.launch {
            val flow = getCountriesUseCase.invoke()
            flow.collect { response ->
                when (response) {
                    is ResponseState.Loading -> {
                        _viewData.value = viewData.value.copy(
                            state = UiState.LOADING
                        )
                    }

                    is ResponseState.Success -> {
                        _viewData.value = viewData.value.copy(
                            state = UiState.LOADED,
                            countries = response.data
                        )
                        _allCountries = response.data.toMutableList()
                    }

                    is ResponseState.Error -> {
                        _viewData.value = viewData.value.copy(
                            state = UiState.ERROR,
                            errorMessage = response.throwable.message.orEmpty()
                        )
                    }

                    is ResponseState.NoInternet -> {
                        _viewData.value = viewData.value.copy(
                            state = UiState.NO_INTERNET
                        )
                    }

                    else -> {}
                }
            }
        }
    }

    fun setNoInternet() {
        _viewData.value = viewData.value.copy(
            state = UiState.NO_INTERNET
        )
    }

    data class ViewData(
        val state: UiState = UiState.LOADING,
        val countries: List<CountryInfo> = emptyList(),
        val errorMessage: String = ""
    )

}