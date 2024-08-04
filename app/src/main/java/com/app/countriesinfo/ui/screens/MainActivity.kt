package com.app.countriesinfo.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.countriesinfo.ui.connectivityUtils.ConnectivityObserver
import com.app.countriesinfo.ui.screens.countryDetail.CountryDetailsScreen
import com.app.countriesinfo.ui.screens.countryLIst.CountryListScreen
import com.app.countriesinfo.ui.theme.CountriesInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesInfoTheme {

                SharedTransitionLayout {
                    val navController = rememberNavController()
                    val sharedViewModel = hiltViewModel<CountryListViewModel>()
                    val connectionState by sharedViewModel.connectionState
                        .observe()
                        .collectAsState(
                            initial = ConnectivityObserver.Status.Unknown
                        )
                    NavHost(
                        navController = navController,
                        startDestination = Routes.COUNTRY_LIST
                    ) {

                        composable(Routes.COUNTRY_LIST) {
                            val viewState = sharedViewModel.viewData.collectAsState()
                            val searchText = sharedViewModel.searchText.collectAsState()
                            LaunchedEffect(key1 = connectionState) {
                                if (viewState.value.countries.isEmpty() && connectionState == ConnectivityObserver.Status.Available) {
                                    sharedViewModel.fetchCountries()
                                } else if (connectionState == ConnectivityObserver.Status.Unavailable ) {
                                    sharedViewModel.setNoInternet()
                                }

                            }
                            CountryListScreen(
                                viewData = viewState.value,
                                searchText = searchText.value,
                                onSearchTextChange = sharedViewModel::onSearch,
                                onCountrySelect = { countryInfo ->
                                    val route =
                                        Routes.COUNTRY_DETAILS.replace("{name}", countryInfo.name)
                                    navController.navigate(route)
                                },
                                transitionScope = this@SharedTransitionLayout,
                                animatedVisibilityScope = this
                            )
                        }
                        composable(Routes.COUNTRY_DETAILS) {

                            val countryName = it.arguments?.getString("name")
                            sharedViewModel.getCountryByName(countryName.orEmpty())
                            val countryInfo = sharedViewModel.selectedCountry.collectAsState()

                            CountryDetailsScreen(
                                countryInfo = countryInfo.value,
                                onBackPress = {
                                    navController.popBackStack()
                                },
                                sharedTransitionScope = this@SharedTransitionLayout,
                                animatedVisibilityScope = this
                            )
                        }
                    }
                }
            }
        }

    }
}