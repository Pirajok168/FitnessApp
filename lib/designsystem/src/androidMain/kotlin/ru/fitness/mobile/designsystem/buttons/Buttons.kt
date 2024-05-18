package ru.fitness.mobile.designsystem.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import ru.fitness.mobile.designsystem.buttons.util.styledButtonSize

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    style: ButtonStyle = ButtonStyle(),
    onClick: () -> Unit
) {
    when(style.type){
        ButtonStyle.Type.PRIMARY -> PrimaryButton(modifier, text, style, onClick)
        ButtonStyle.Type.GHOST -> GhostButton(modifier, text, style, onClick)
        ButtonStyle.Type.OUTLINE -> OutlinedButton(modifier, text, style, onClick)
    }

}


@Composable
private fun OutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    style: ButtonStyle = ButtonStyle(),
    onClick: () -> Unit
){
    androidx.compose.material3.OutlinedButton(onClick = onClick,
        modifier = modifier
            .styledButtonSize(style),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(text = text)
    }
}

@Composable
private fun GhostButton(
    modifier: Modifier = Modifier,
    text: String,
    style: ButtonStyle = ButtonStyle(),
    onClick: () -> Unit
){
    TextButton(
        onClick = onClick,
        modifier = modifier
            .styledButtonSize(style),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(text = text)
    }
}

@Composable
private fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    style: ButtonStyle = ButtonStyle(),
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = modifier
            .styledButtonSize(style),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(text = text)
    }
}