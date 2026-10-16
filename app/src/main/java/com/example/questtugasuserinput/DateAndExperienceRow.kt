package com.example.questtugasuserinput

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun DateAndExperienceRow(
    birthDate: String,
    onBirthDateChange: (String) -> Unit,
    experience: String,
    onExperienceChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val expOptions = listOf(
        stringResource(id = R.string.exp_junior),
        stringResource(id = R.string.exp_mid),
        stringResource(id = R.string.exp_senior)
    )
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_standard))
    ) {
        CustomOutlinedTextField(
            value = birthDate,
            onValueChange = onBirthDateChange,
            placeholderText = stringResource(id = R.string.hint_birth_date),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = stringResource(id = R.string.desc_calendar_icon),
                    tint = colorResource(id = R.color.text_field_label)
                )
            },
            modifier = Modifier.weight(1f)
        )
        Box(modifier = Modifier.weight(1f)) {
            CustomOutlinedTextField(
                value = experience,
                onValueChange = {},
                readOnly = true,
                placeholderText = stringResource(id = R.string.hint_experience),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_drop_down),
                        contentDescription = stringResource(id = R.string.desc_dropdown_icon),
                        tint = colorResource(id = R.color.text_field_label),
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                expOptions.forEach { opt ->
                    DropdownMenuItem(
                        text = { Text(text = opt) },
                        onClick = {
                            onExperienceChange(opt)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
