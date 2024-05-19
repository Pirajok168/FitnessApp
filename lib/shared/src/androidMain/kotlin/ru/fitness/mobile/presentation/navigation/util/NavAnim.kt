package ru.fitness.mobile.presentation.navigation.util

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable


fun enterTransition() =
    slideInHorizontally(
        initialOffsetX = {
            it
        }
    )


fun exitTransition() =
    slideOutHorizontally {
        it
    }