package com.example.questtugasuserinput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProceedButton(
    onClick: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val btnTextSp = with(density) { dimensionResource(R.dimen.font_size_button).toSp() }
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.button_height)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.btn_bg_active),
            contentColor = colorResource(R.color.btn_text_active),
            disabledContainerColor = colorResource(R.color.btn_bg_inactive),
            disabledContentColor = colorResource(R.color.btn_text_inactive)
        )
    ) {
        Text(
            text = stringResource(R.string.btn_proceed),
            fontSize = btnTextSp,
            fontWeight = FontWeight.Bold
        )
    }
}