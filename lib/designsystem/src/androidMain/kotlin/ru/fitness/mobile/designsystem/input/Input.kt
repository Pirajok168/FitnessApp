package ru.fitness.mobile.designsystem.input

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.fitness.mobile.designsystem.icon.InternalIcon
import ru.fitness.mobile.designsystem.image.ImageView

@Composable
fun Input(
    modifier: Modifier,
    text: String,
    label: String,
    leadingIcon: InternalIcon? = null,
    trailingIcon: InternalIcon? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onClickTrailingIcon: () -> Unit = {},
    onValueChange: (String) -> Unit
) {
    if (leadingIcon == null) {
        TextField(
            modifier = modifier,
            value = text,
            onValueChange = onValueChange,
            label = {
                Text(text = label)
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            trailingIcon = {
                trailingIcon?.let {
                    IconButton(onClick = onClickTrailingIcon) {
                        ImageView(
                            icon = trailingIcon,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            },
            visualTransformation = visualTransformation
        )
    } else {
        TextField(
            modifier = modifier,
            value = text,
            onValueChange = onValueChange,
            label = {
                Text(text = label)
            },
            leadingIcon = {
                ImageView(
                    icon = leadingIcon,
                    modifier = Modifier.size(24.dp)
                )
            },
            trailingIcon = {
                trailingIcon?.let {
                    IconButton(onClick = onClickTrailingIcon) {
                        ImageView(
                            icon = trailingIcon,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            visualTransformation = visualTransformation
        )
    }
}