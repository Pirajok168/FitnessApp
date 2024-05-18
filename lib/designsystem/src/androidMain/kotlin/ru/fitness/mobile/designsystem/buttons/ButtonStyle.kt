package ru.fitness.mobile.designsystem.buttons

import androidx.compose.ui.graphics.Color
import ru.fitness.mobile.designsystem.tint.Tint

data class ButtonStyle(
    val color: Tint = Tint.Green,
    val type: Type = Type.PRIMARY,
    val size: Size = Size.MEDIUM,
    val isFillMaxWidth: Boolean = true
) {

    enum class Type {

        PRIMARY,
        GHOST,
        OUTLINE
    }

    /**
     * Размеры.
     *
     * [MEDIUM] 48dp
     * [SMALL]  28dp
     */
    enum class Size {

        MEDIUM,
        SMALL,
    }
}