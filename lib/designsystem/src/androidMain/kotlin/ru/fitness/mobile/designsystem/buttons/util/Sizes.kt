package ru.fitness.mobile.designsystem.buttons.util

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.fitness.mobile.designsystem.buttons.ButtonStyle



internal fun ButtonStyle.buttonHeight(): Dp = when (size) {

    ButtonStyle.Size.MEDIUM -> 48.dp
    ButtonStyle.Size.SMALL -> 32.dp
}
