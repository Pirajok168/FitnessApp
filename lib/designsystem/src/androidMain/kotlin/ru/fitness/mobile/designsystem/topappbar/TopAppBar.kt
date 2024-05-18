package ru.fitness.mobile.designsystem.topappbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import ru.fitness.mobile.designsystem.icon.InternalIcon
import ru.fitness.mobile.designsystem.icon.toIcon
import ru.fitness.mobile.designsystem.image.ImageView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: @Composable () -> Unit = {},
    navigationIcon: InternalIcon? = null,
    onClickNavigationIcon: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    Column {
        androidx.compose.material3.TopAppBar(
            title = title,
            navigationIcon =  {
                navigationIcon?.let {
                    IconButton(onClick = onClickNavigationIcon) {
                        ImageView(
                            icon = navigationIcon,
                            modifier = Modifier
                                .size(24.dp)
                                .rotate(-180f)
                        )
                    }

                }
            }
        )
        content()
    }

}