package ru.fitness.mobile.authorization.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.fitness.mobile.authorization.R
import ru.fitness.mobile.authorization.viewmodel.AuthorizationEnterPhoneViewModel
import ru.fitness.mobile.compose.Spacing
import ru.fitness.mobile.designsystem.buttons.Button
import ru.fitness.mobile.designsystem.buttons.ButtonStyle
import ru.fitness.mobile.designsystem.icon.toIcon
import ru.fitness.mobile.designsystem.input.Input
import ru.fitness.mobile.designsystem.topappbar.TopAppBar

@Composable
fun AuthorizationEnterPhoneScreen(
    viewModel: AuthorizationEnterPhoneViewModel,
    onChooseAnotherEnter: () -> Unit
) {
    val state by viewModel.viewStates().collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(content = {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.auth_screen_title),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacing(spase = 16.dp)
                    Text(
                        text = stringResource(id = R.string.auth_screen_subtitle),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Input(
                modifier = Modifier.fillMaxWidth(),
                text = state.numberPhone,
                label = stringResource(id = R.string.number_phone),
                onValueChange =  {},
                leadingIcon = R.drawable.ic_mobile.toIcon()
            )
            Spacing(spase = 16.dp)
            Button(
                text = stringResource(id = R.string.resume),
                onClick = {}
            )
            Spacing(spase = 16.dp)
            Button(
                text = stringResource(id = R.string.another_enter),
                onClick = onChooseAnotherEnter,
                style = ButtonStyle(type = ButtonStyle.Type.OUTLINE)
            )
            Spacing(spase = 16.dp)
            Button(
                text = stringResource(id = R.string.registration),
                onClick = {},
                style = ButtonStyle(type = ButtonStyle.Type.GHOST)
            )
        }
    }
}