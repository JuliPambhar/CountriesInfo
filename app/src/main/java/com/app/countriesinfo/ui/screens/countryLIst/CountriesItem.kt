package com.app.countriesinfo.ui.screens.countryLIst

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.countriesinfo.R
import com.app.domain.entities.CountryInfo

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CountriesItem(
    countryInfo: CountryInfo,
    onCountrySelect: (CountryInfo) -> Unit,
    transitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Card(
        elevation = cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .clickable {
                onCountrySelect(countryInfo)
            }

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 5.dp),
        ) {
            with(transitionScope) {
                AsyncImage(
                    model = countryInfo.flag,
                    contentDescription = stringResource(R.string.ic_flag),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(30.dp)
                        .height(20.dp)
                        .sharedElement(
                            state = rememberSharedContentState(key = "image/${countryInfo.flag}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ ->
                                tween(1000)
                            }
                        )
                )
            }
            Text(
                text = countryInfo.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(10.dp)
            )
        }

    }
}