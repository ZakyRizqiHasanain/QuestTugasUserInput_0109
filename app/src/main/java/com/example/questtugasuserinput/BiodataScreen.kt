package com.example.questtugasuserinput

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BiodataScreen() {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberScrollState()
    var formState by remember { mutableStateOf(BiodataFormState()) }
    var snackbarJob by remember { mutableStateOf<Job?>(null) }
    val durationMs = integerResource(R.integer.snackbar_duration_ms).toLong()
    val resultTemplate = stringResource(R.string.snackbar_result_format)
    val skillAndroid = stringResource(R.string.skill_android)
    val skillUiUx = stringResource(R.string.skill_ui_ux)
    val skillWeb = stringResource(R.string.skill_web)
    val commaSeparator = stringResource(R.string.separator_comma)
    val emptyDash = stringResource(R.string.empty_dash)
    Scaffold(
        containerColor = colorResource(R.color.bg_scaffold),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.spacing_standard))
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HeaderBanner(
                modifier = Modifier.align(Alignment.TopCenter)
            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = dimensionResource(R.dimen.floating_card_top_offset)),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.card_top_corner_radius),
                    topEnd = dimensionResource(R.dimen.card_top_corner_radius),
                    bottomStart = dimensionResource(R.dimen.card_bottom_corner_radius),
                    bottomEnd = dimensionResource(R.dimen.card_bottom_corner_radius)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(R.color.bg_card_white)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(R.dimen.card_elevation)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                        .padding(
                            start = dimensionResource(R.dimen.spacing_xxl),
                            end = dimensionResource(R.dimen.spacing_xxl),
                            top = dimensionResource(R.dimen.spacing_xxl),
                            bottom = dimensionResource(R.dimen.floating_card_top_offset)
                        )
                ) {
                    FormHeader()
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_large)))
                    NameFieldsRow(
                        firstName = formState.firstName,
                        onFirstNameChange = { formState = formState.copy(firstName = it) },
                        lastName = formState.lastName,
                        onLastNameChange = { formState = formState.copy(lastName = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_standard)))
                    EmailInputField(
                        email = formState.email,
                        onEmailChange = { formState = formState.copy(email = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_standard)))
                    DateAndExperienceRow(
                        birthDate = formState.birthDate,
                        onBirthDateChange = { formState = formState.copy(birthDate = it) },
                        experience = formState.experience,
                        onExperienceChange = { formState = formState.copy(experience = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_standard)))
                    SkillSelectionGroup(
                        isAndroid = formState.isAndroidChecked,
                        onAndroidChange = { formState = formState.copy(isAndroidChecked = it) },
                        isUiUx = formState.isUiUxChecked,
                        onUiUxChange = { formState = formState.copy(isUiUxChecked = it) },
                        isWeb = formState.isWebChecked,
                        onWebChange = { formState = formState.copy(isWebChecked = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_large)))

                    val isFormComplete = formState.firstName.isNotBlank() &&
                            formState.lastName.isNotBlank() &&
                            formState.email.isNotBlank() &&
                            formState.birthDate.isNotBlank() &&
                            formState.experience.isNotBlank() &&
                            (formState.isAndroidChecked || formState.isUiUxChecked || formState.isWebChecked)

                    ProceedButton(
                        isEnabled = isFormComplete,
                        onClick = {
                            val selectedSkills = mutableListOf<String>()
                            if (formState.isAndroidChecked) selectedSkills.add(skillAndroid)
                            if (formState.isUiUxChecked) selectedSkills.add(skillUiUx)
                            if (formState.isWebChecked) selectedSkills.add(skillWeb)

                            val skillsText = if (selectedSkills.isEmpty()) emptyDash else selectedSkills.joinToString(commaSeparator)

                            val message = resultTemplate.format(
                                formState.firstName,
                                formState.lastName,
                                formState.email,
                                formState.birthDate,
                                formState.experience,
                                skillsText
                            )

                            snackbarJob?.cancel()
                            snackbarJob = coroutineScope.launch {
                                val showJob = launch {
                                    snackbarHostState.showSnackbar(
                                        message = message,
                                        duration = SnackbarDuration.Indefinite
                                    )
                                }
                                delay(durationMs)
                                snackbarHostState.currentSnackbarData?.dismiss()
                                showJob.cancel()
                            }
                        }
                    )
                }
            }
        }
    }
}