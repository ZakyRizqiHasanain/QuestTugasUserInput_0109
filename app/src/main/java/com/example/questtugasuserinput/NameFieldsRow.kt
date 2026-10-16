package com.example.questtugasuserinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource

@Composable
fun NameFieldsRow(
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_standard))
    ) {
        CustomOutlinedTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            placeholderText = stringResource(R.string.hint_first_name),
            modifier = Modifier.weight(1f)
        )
        CustomOutlinedTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            placeholderText = stringResource(R.string.hint_last_name),
            modifier = Modifier.weight(1f)
        )
    }
}
