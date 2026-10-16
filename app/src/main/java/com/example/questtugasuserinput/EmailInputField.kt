package com.example.questtugasuserinput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun EmailInputField(
    email: String,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    CustomOutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        placeholderText = stringResource(id = R.string.hint_email),
        modifier = modifier.fillMaxWidth()
    )
}