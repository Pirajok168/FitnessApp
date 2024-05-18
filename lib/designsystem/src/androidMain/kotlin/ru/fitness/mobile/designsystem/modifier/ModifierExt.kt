package ru.fitness.mobile.designsystem.modifier

import androidx.compose.ui.Modifier

fun <T> Modifier.optional(item: T?, modifier: (T) -> Modifier): Modifier =
    then(if (item != null) modifier(item) else Modifier)
