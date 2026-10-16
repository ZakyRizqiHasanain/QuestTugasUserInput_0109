package com.example.questtugasuserinput

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource

@Composable
fun PagerIndicator(
    pageCount: Int = 4,
    currentPageIndex: Int = 0,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_extra_small))
    ) {
        repeat(pageCount) { index ->
            val dotColor = if (index == currentPageIndex) {
                colorResource(id = R.color.indicator_active)
            } else {
                colorResource(id = R.color.indicator_inactive)
            }
            Box(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.indicator_dot_size))
                    .background(color = dotColor, shape = CircleShape)
            )
        }
    }
}