package com.app.countriesinfo.ui.screens.countryLIst

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.countriesinfo.R
import com.app.domain.entities.CountryInfo

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CountryListComponent(
    modifier: Modifier,
    searchText: String,
    countries: List<CountryInfo>,
    onSearchTextChange: (String) -> Unit,
    onCountrySelect: (CountryInfo) -> Unit,
    transitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {

    Column(
        modifier = modifier
            .testTag("successView")
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") }
        )
        Spacer(modifier = Modifier.height(5.dp))
        if (countries.isEmpty()) {
            Text(
                text = stringResource(R.string.no_data),
                modifier = Modifier
                    //.align(Alignment.Center)
                    .testTag("noData")
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
            ) {
                items(
                    items = countries,
                    key = { it.name }
                ) { item ->
                    CountriesItem(
                        countryInfo = item,
                        onCountrySelect = onCountrySelect,
                        transitionScope = transitionScope,
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                }
            }
        }
    }
}