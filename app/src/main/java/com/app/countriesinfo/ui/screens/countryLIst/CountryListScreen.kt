package com.app.countriesinfo.ui.screens.countryLIst

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.app.countriesinfo.ui.component.ErrorView
import com.app.countriesinfo.ui.component.NoInternetView
import com.app.countriesinfo.ui.screens.CountryListViewModel
import com.app.countriesinfo.utils.UiState
import com.app.domain.entities.CountryInfo

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CountryListScreen(
    viewData: CountryListViewModel.ViewData,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onCountrySelect: (CountryInfo) -> Unit,
    transitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.White)
        ) {
            when (viewData.state) {
                UiState.LOADING -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .testTag("viewLoader")
                    )
                }

                UiState.LOADED -> {
                    CountryListComponent(
                        modifier = Modifier,
                        searchText,
                        viewData.countries,
                        onSearchTextChange,
                        onCountrySelect,
                        transitionScope,
                        animatedVisibilityScope

                    )
                }

                UiState.ERROR -> {
                    ErrorView(modifier = Modifier)
                }

                UiState.NO_INTERNET -> {
                    NoInternetView(
                        modifier = Modifier
                            .testTag("noInternetView")
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}


