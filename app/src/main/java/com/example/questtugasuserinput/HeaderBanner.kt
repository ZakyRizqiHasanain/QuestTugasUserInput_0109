package com.example.questtugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


@Composable
fun HeaderBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.header_banner_height))
    ) {
        Image(
            painter = painterResource(R.drawable.bg_header_spider),
            contentDescription = stringResource(R.string.desc_header_banner),
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        PagerIndicator(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(
                    start = dimensionResource(R.dimen.spacing_standard),
                    top = dimensionResource(R.dimen.spacing_large)
                )
        )
    }
}