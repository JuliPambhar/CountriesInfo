package com.app.countriesinfo.ui.screens.countryDetail

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.countriesinfo.R
import com.app.domain.entities.CountryInfo

@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CountryDetailsScreen(
    countryInfo: CountryInfo,
    onBackPress: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        countryInfo.name,
                    )
                },
                modifier = Modifier.shadow(elevation = 5.dp),
                navigationIcon = {
                    IconButton(onClick = onBackPress, modifier = Modifier.testTag("backButton")) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.ic_back),
                        )
                    }
                },
            )
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .background(Color.White)
                .testTag("allInfo")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 5.dp),
            ) {
                with(sharedTransitionScope) {
                    AsyncImage(
                        model = countryInfo.flag,
                        contentDescription = stringResource(R.string.ic_flag),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(200.dp)
                            .padding(10.dp)
                            .sharedElement(
                                state = rememberSharedContentState(key = "image/${countryInfo.flag}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(1000)
                                }
                            )
                    )
                }
                Box(
                    modifier = Modifier
                        .height(250.dp)
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            Column(
                                Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.population),
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = countryInfo.population.toString(), fontSize = 14.sp)
                            }
                            VerticalDivider(
                                color = Color.Black,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .height(50.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Column(
                                Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.region),
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = countryInfo.region, fontSize = 14.sp)
                            }
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            AsyncImage(
                                model = countryInfo.coatOfArms,
                                alignment = Alignment.Center,
                                contentDescription = stringResource(R.string.ic_flag),
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(60.dp)
                            )
                            Text(
                                text = stringResource(R.string.coatOfArms),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                        ) {
                            Column(
                                Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.capital),
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = countryInfo.capital, fontSize = 14.sp)
                            }
                            VerticalDivider(
                                color = Color.Black,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .height(50.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Column(
                                Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.area),
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = countryInfo.area.toString(), fontSize = 14.sp)
                            }
                        }
                    }

                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 30.dp),
                    onClick = {
                        uriHandler.openUri(countryInfo.maps)
                    }) {
                    Text(text = stringResource(R.string.go_to_map), fontSize = 14.sp)
                }
            }
        }
    }
}