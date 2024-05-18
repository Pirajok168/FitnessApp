package ru.fitness.mobile.designsystem.buttons.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.fitness.mobile.designsystem.buttons.ButtonStyle

internal fun Modifier.styledButtonSize(buttonStyle: ButtonStyle): Modifier {
    val widthModifier = if (buttonStyle.size == ButtonStyle.Size.SMALL &&
        !buttonStyle.isFillMaxWidth) {
        wrapContentWidth()
    } else {
        fillMaxWidth()
    }
    return height(buttonStyle.buttonHeight())
        .then(widthModifier)
}

@Composable
internal fun styledBorderButton(buttonStyle: ButtonStyle): BorderStroke? =
    BorderStroke(2.dp, buttonStyle.color.color()).takeIf {
        buttonStyle.type == ButtonStyle.Type.OUTLINE
    }