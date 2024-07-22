package com.app.countriesinfo.ui.screens.countryDetail

import android.content.Context
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.app.countriesinfo.ui.screens.utils.rememberMockAnimatedVisibilityScope
import com.app.countriesinfo.ui.theme.CountriesInfoTheme
import com.app.domain.entities.CountryInfo
import org.junit.Rule
import org.junit.Test

class CountryDetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @OptIn(ExperimentalSharedTransitionApi::class)
    private fun initView(fakeCountry: CountryInfo) {
        composeTestRule.setContent {
            CountriesInfoTheme {
                SharedTransitionLayout {
                    CountryDetailsScreen(
                        countryInfo = fakeCountry,
                        onBackPress = {},
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = rememberMockAnimatedVisibilityScope(),
                    )
                }
            }
        }
    }

    @Test
    fun testAllViewsAreVisible() {
        val fakeCountry = CountryInfo()
        initView(fakeCountry)
        composeTestRule.onNodeWithTag("allInfo").assertIsDisplayed()
    }

    @OptIn(ExperimentalSharedTransitionApi::class)
    @Test
    fun testBackButtonPress() {
        val fakeCountry = CountryInfo()
        var onBackPressTrigger = false
        composeTestRule.setContent {
            CountriesInfoTheme {
                SharedTransitionLayout {
                    CountryDetailsScreen(
                        fakeCountry,
                        onBackPress = { onBackPressTrigger = true },
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = rememberMockAnimatedVisibilityScope(),
                    )
                }
            }
        }

        composeTestRule.onNodeWithTag("backButton").performClick()
        assert(onBackPressTrigger)
    }
}