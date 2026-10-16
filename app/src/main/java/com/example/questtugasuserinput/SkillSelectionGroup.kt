package com.example.questtugasuserinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SkillSelectionGroup(
    isAndroid: Boolean,
    onAndroidChange: (Boolean) -> Unit,
    isUiUx: Boolean,
    onUiUxChange: (Boolean) -> Unit,
    isWeb: Boolean,
    onWebChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val labelSp = with(density) { dimensionResource(id = R.dimen.font_size_label).toSp() }
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.label_skills),
            fontWeight = FontWeight.Bold,
            fontSize = labelSp,
            color = colorResource(id = R.color.text_primary),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_small))
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(
                Triple(stringResource(id = R.string.skill_android), isAndroid, onAndroidChange),
                Triple(stringResource(id = R.string.skill_ui_ux), isUiUx, onUiUxChange),
                Triple(stringResource(id = R.string.skill_web), isWeb, onWebChange)
            ).forEach { (skillName, checked, onChecked) ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = onChecked,
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.purple_primary),
                            uncheckedColor = colorResource(id = R.color.border_field_unfocused)
                        )
                    )
                    Text(
                        text = skillName,
                        fontSize = labelSp,
                        color = colorResource(id = R.color.text_primary)
                    )
                }
            }
        }
    }
}