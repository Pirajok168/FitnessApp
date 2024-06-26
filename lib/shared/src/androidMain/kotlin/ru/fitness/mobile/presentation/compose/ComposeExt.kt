package ru.fitness.mobile.presentation.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Spacing(spase: Dp) {
    Spacer(Modifier.size(spase))
}