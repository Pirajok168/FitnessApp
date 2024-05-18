package ru.fitness.mobile.designsystem.icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource


sealed class InternalIcon {

    abstract val contentDescription: String?

    data class Vector(
        val vector: ImageVector,
        val tint: Color?,
        override val contentDescription: String?
    ) : InternalIcon()

    data class Painter(
        val painter: androidx.compose.ui.graphics.painter.Painter,
        val tint: Color?,
        override val contentDescription: String?
    ) : InternalIcon()
}

fun ImageVector.toIcon(
    tint: Color? = null,
    contentDescription: String? = null
) = InternalIcon.Vector(
    vector = this,
    tint = tint,
    contentDescription = contentDescription
)

fun Painter.toIcon(
    tint: Color? = null,
    contentDescription: String? = null
) = InternalIcon.Painter(
    painter = this,
    tint = tint,
    contentDescription = contentDescription
)

@Composable
fun Int.toIcon(
    tint: Color? = null,
    contentDescription: String? = null
): InternalIcon =
    painterResource(id = this).toIcon(tint, contentDescription)

