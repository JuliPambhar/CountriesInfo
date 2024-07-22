package com.app.countriesinfo.ui.screens.countryLIst

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.platform.app.InstrumentationRegistry
import com.app.countriesinfo.R
import com.app.countriesinfo.ui.screens.CountryListViewModel
import com.app.countriesinfo.ui.screens.utils.rememberMockAnimatedVisibilityScope
import com.app.countriesinfo.ui.theme.CountriesInfoTheme
import com.app.countriesinfo.utils.UiState
import org.junit.Rule
import org.junit.Test


class CountryListScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @OptIn(ExperimentalSharedTransitionApi::class)
    private fun initView(fakeViewData: CountryListViewModel.ViewData) {
        composeTestRule.setContent {
            CountriesInfoTheme {
                SharedTransitionLayout {
                    CountryListScreen(
                        viewData = fakeViewData,
                        searchText = "",
                        onSearchTextChange = {},
                        onCountrySelect = {},
                        transitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = rememberMockAnimatedVisibilityScope(),
                    )

                }

            }
        }
    }

    @Test
    fun showLoaderWhenFetchingCountries() {
        initView(CountryListViewModel.ViewData(state = UiState.LOADING))
        composeTestRule.onNodeWithTag("viewLoader").assertIsDisplayed()
        composeTestRule.onNodeWithTag("successView").assertDoesNotExist()
        composeTestRule.onNodeWithTag("errorView").assertDoesNotExist()
        composeTestRule.onNodeWithTag("noInternetView").assertDoesNotExist()
    }

    @Test
    fun showSuccessViewAfterFetchingCountries() {
        initView(CountryListViewModel.ViewData(state = UiState.LOADED))
        composeTestRule.onNodeWithTag("viewLoader").assertDoesNotExist()
        composeTestRule.onNodeWithTag("successView").assertIsDisplayed()
        composeTestRule.onNodeWithTag("errorView").assertDoesNotExist()
        composeTestRule.onNodeWithTag("noInternetView").assertDoesNotExist()
    }

    @Test
    fun showNoInternetViewWhenNoInternetConnection() {
        initView(CountryListViewModel.ViewData(state = UiState.NO_INTERNET))
        composeTestRule.onNodeWithTag("viewLoader").assertDoesNotExist()
        composeTestRule.onNodeWithTag("successView").assertDoesNotExist()
        composeTestRule.onNodeWithTag("errorView").assertDoesNotExist()
        composeTestRule.onNodeWithTag("noInternetView").assertIsDisplayed()
    }

    @Test
    fun showErrorViewAfterFetchingCountriesListFailed() {
        initView(CountryListViewModel.ViewData(state = UiState.ERROR))
        composeTestRule.onNodeWithTag("viewLoader").assertDoesNotExist()
        composeTestRule.onNodeWithTag("successView").assertDoesNotExist()
        composeTestRule.onNodeWithTag("errorView").assertIsDisplayed()
        composeTestRule.onNodeWithTag("noInternetView").assertDoesNotExist()
        composeTestRule.onNodeWithTag("errorView")
            .assertTextEquals(context.getString(R.string.something_went_wrong))
    }

    @Test
    fun showEmptyCountriesListViewWhenThereIsNoCountries() {
        initView(CountryListViewModel.ViewData(state = UiState.LOADED))
        composeTestRule.onNodeWithTag("noData").assertIsDisplayed()
        composeTestRule.onNodeWithTag("noData")
            .assertTextEquals(context.getString(R.string.no_data))
    }
}