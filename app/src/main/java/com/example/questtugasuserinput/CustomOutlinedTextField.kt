package com.example.questtugasuserinput

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false
) {
    val density = LocalDensity.current
    val textSp = with(density) { dimensionResource(R.dimen.font_size_input).toSp() }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        readOnly = readOnly,
        modifier = modifier,
        placeholder = {
            Text(
                text = placeholderText,
                color = colorResource(R.color.text_field_label),
                fontSize = textSp
            )
        },
        trailingIcon = trailingIcon,
        shape = RoundedCornerShape(dimensionResource(R.dimen.input_corner_radius)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.border_field_focused),
            unfocusedBorderColor = colorResource(R.color.border_field_unfocused),
            focusedTextColor = colorResource(R.color.text_primary),
            unfocusedTextColor = colorResource(R.color.text_primary)
        ),
        singleLine = true
    )
}