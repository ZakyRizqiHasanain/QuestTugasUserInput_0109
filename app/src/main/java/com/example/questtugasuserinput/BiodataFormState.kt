package com.example.questtugasuserinput

data class BiodataFormState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val birthDate: String = "",
    val experience: String = "",
    val isAndroidChecked: Boolean = false,
    val isUiUxChecked: Boolean = false,
    val isWebChecked: Boolean = false
)