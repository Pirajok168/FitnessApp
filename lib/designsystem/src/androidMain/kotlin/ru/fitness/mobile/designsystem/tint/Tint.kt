package ru.fitness.mobile.designsystem.tint

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class Tint {
    Green;

    @Composable
    fun color(): Color =
        when (this) {
            Green -> MaterialTheme.colorScheme.primary
        }

}