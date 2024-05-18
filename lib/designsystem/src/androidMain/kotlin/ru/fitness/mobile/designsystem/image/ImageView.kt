package ru.fitness.mobile.designsystem.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import ru.fitness.mobile.designsystem.icon.InternalIcon

@Composable
fun ImageView(modifier: Modifier = Modifier, icon: InternalIcon) {
    when (icon) {
        is InternalIcon.Painter -> Image(
            modifier = modifier,
            painter = icon.painter,
            contentDescription = icon.contentDescription,
            colorFilter = icon.tint?.let(ColorFilter.Companion::tint)
        )
        is InternalIcon.Vector -> Image(
            modifier = modifier,
            imageVector = icon.vector,
            contentDescription = icon.contentDescription,
            colorFilter = icon.tint?.let(ColorFilter.Companion::tint)
        )
    }
}
