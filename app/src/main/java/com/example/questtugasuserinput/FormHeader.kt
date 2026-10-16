package com.example.questtugasuserinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun FormHeader(modifier: Modifier = Modifier) {
    val density = LocalDensity.current
    val titleSp = with(density) { dimensionResource(R.dimen.font_size_title).toSp() }
    val subtitleSp = with(density) { dimensionResource(R.dimen.font_size_subtitle).toSp() }
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.form_title),
            color = colorResource(R.color.purple_primary),
            fontSize = titleSp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.form_subtitle),
            color = colorResource(R.color.text_subtitle),
            fontSize = subtitleSp,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.spacing_extra_small))
        )
    }
}