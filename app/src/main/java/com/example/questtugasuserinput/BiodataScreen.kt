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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource

@Composable
fun BiodataScreen() {
    var formState by remember { mutableStateOf(BiodataFormState()) }
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = colorResource(id = R.color.bg_scaffold)
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
                    .offset(y = dimensionResource(id = R.dimen.floating_card_top_offset)),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen.card_top_corner_radius),
                    topEnd = dimensionResource(id = R.dimen.card_top_corner_radius),
                    bottomStart = dimensionResource(id = R.dimen.card_bottom_corner_radius),
                    bottomEnd = dimensionResource(id = R.dimen.card_bottom_corner_radius)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.bg_card_white)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(id = R.dimen.card_elevation)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                        .padding(
                            start = dimensionResource(id = R.dimen.spacing_xxl),
                            end = dimensionResource(id = R.dimen.spacing_xxl),
                            top = dimensionResource(id = R.dimen.spacing_xxl),
                            bottom = dimensionResource(id = R.dimen.floating_card_top_offset)
                        )
                ) {
                    FormHeader()
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                    NameFieldsRow(
                        firstName = formState.firstName,
                        onFirstNameChange = { formState = formState.copy(firstName = it) },
                        lastName = formState.lastName,
                        onLastNameChange = { formState = formState.copy(lastName = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_standard)))
                    EmailInputField(
                        email = formState.email,
                        onEmailChange = { formState = formState.copy(email = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_standard)))
                    DateAndExperienceRow(
                        birthDate = formState.birthDate,
                        onBirthDateChange = { formState = formState.copy(birthDate = it) },
                        experience = formState.experience,
                        onExperienceChange = { formState = formState.copy(experience = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_standard)))
                    SkillSelectionGroup(
                        isAndroid = formState.isAndroidChecked,
                        onAndroidChange = { formState = formState.copy(isAndroidChecked = it) },
                        isUiUx = formState.isUiUxChecked,
                        onUiUxChange = { formState = formState.copy(isUiUxChecked = it) },
                        isWeb = formState.isWebChecked,
                        onWebChange = { formState = formState.copy(isWebChecked = it) }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                    ProceedButton(
                        onClick = {
                        }
                    )
                }
            }
        }
    }
}