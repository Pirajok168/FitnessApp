package ru.fitness.mobile.authorization.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.fitness.mobile.authorization.R
import ru.fitness.mobile.authorization.event.AuthorizationEvents
import ru.fitness.mobile.authorization.viewmodel.AuthorizationViewModel
import ru.fitness.mobile.compose.Spacing

@Composable
fun AuthorizationScreen(
    viewModel: AuthorizationViewModel
) {
    val state by viewModel.viewStates().collectAsState()

    Scaffold {
        Column(
            modifier = Modifier.padding(it)
        ) {
            OutlinedTextField(
                value = state.login,
                onValueChange = { viewModel.obtainEvent(AuthorizationEvents.InputLogin(it)) },
                label = {
                    Text(text = stringResource(id = R.string.login))
                }
            )
            Spacing(16.dp)
            OutlinedTextField(
                value = state.password,
                onValueChange = { viewModel.obtainEvent(AuthorizationEvents.InputPassword(it)) },
                label = {
                    Text(text = stringResource(id = R.string.password))
                }
            )
        }
    }
}