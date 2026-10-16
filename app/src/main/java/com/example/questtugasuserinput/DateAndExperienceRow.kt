package com.example.questtugasuserinput

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import java.util.Calendar
import java.util.TimeZone

@SuppressLint("LocalContextGetResourceValueCall")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateAndExperienceRow(
    birthDate: String,
    onBirthDateChange: (String) -> Unit,
    experience: String,
    onExperienceChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var expandedDropdown by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val expOptions = listOf(
        stringResource(id = R.string.exp_junior),
        stringResource(id = R.string.exp_mid),
        stringResource(id = R.string.exp_senior)
    )
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
                                timeInMillis = millis
                            }
                            val day = calendar.get(Calendar.DAY_OF_MONTH)
                            val month = calendar.get(Calendar.MONTH) + 1
                            val year = calendar.get(Calendar.YEAR)
                            val formatted = context.getString(R.string.date_display_format, day, month, year)
                            onBirthDateChange(formatted)
                        }
                        showDatePicker = false
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.btn_ok),
                        color = colorResource(id = R.color.purple_primary)
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text(
                        text = stringResource(id = R.string.btn_cancel),
                        color = colorResource(id = R.color.text_subtitle)
                    )
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_standard))
    ) {
        Box(modifier = Modifier.weight(1f)) {
            CustomOutlinedTextField(
                value = birthDate,
                onValueChange = {},
                readOnly = true,
                placeholderText = stringResource(id = R.string.hint_birth_date),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = stringResource(id = R.string.desc_calendar_icon),
                        tint = colorResource(id = R.color.text_field_label),
                        modifier = Modifier.clickable { showDatePicker = true }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { showDatePicker = true }
            )
        }
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
                        modifier = Modifier.clickable { expandedDropdown = !expandedDropdown }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { expandedDropdown = !expandedDropdown }
            )
            DropdownMenu(
                expanded = expandedDropdown,
                onDismissRequest = { expandedDropdown = false }
            ) {
                expOptions.forEach { opt ->
                    DropdownMenuItem(
                        text = { Text(text = opt) },
                        onClick = {
                            onExperienceChange(opt)
                            expandedDropdown = false
                        }
                    )
                }
            }
        }
    }
}