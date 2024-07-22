package com.app.countriesinfo.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.countriesinfo.R
@Composable
fun ErrorView(modifier: Modifier) {

    Text(
        modifier = modifier
            .testTag("errorView")
            .padding(16.dp),
        text = stringResource(R.string.something_went_wrong),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
}