package ru.fitness.mobile.authorization.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.fitness.mobile.authorization.R
import ru.fitness.mobile.authorization.event.AuthorizationEnterLoginPasswordEvents
import ru.fitness.mobile.authorization.viewmodel.AuthorizationEnterLoginPasswordViewModel
import ru.fitness.mobile.authorization.viewmodel.AuthorizationEnterPhoneViewModel
import ru.fitness.mobile.compose.Spacing
import ru.fitness.mobile.designsystem.buttons.Button
import ru.fitness.mobile.designsystem.buttons.ButtonStyle
import ru.fitness.mobile.designsystem.icon.toIcon
import ru.fitness.mobile.designsystem.image.ImageView
import ru.fitness.mobile.designsystem.input.Input
import ru.fitness.mobile.designsystem.topappbar.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationEnterLoginPasswordScreen(
    viewModel: AuthorizationEnterLoginPasswordViewModel,
    onBack: () -> Unit
){
    val state by viewModel.viewStates().collectAsState()
    var showPassword by rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = ru.fitness.mobile.R.drawable.ic_chevron.toIcon(MaterialTheme.colorScheme.primary),
                content = {
                    Column(Modifier.padding(horizontal = 16.dp)) {
                        Text(
                            text = stringResource(id = R.string.auth_screen_enter_login_title),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacing(spase = 16.dp)
                        Text(
                            text = stringResource(id = R.string.auth_screen_enter_login_subtitle),
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                },
                onClickNavigationIcon =onBack
            )
        },
        modifier = Modifier.imePadding()
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
                text = state.login,
                label = stringResource(id = R.string.login),
                onValueChange =  {
                    viewModel.obtainEvent(AuthorizationEnterLoginPasswordEvents.InputLogin(it))
                }
            )
            Spacing(spase = 16.dp)
            Input(
                modifier = Modifier.fillMaxWidth(),
                text = state.password,
                label = stringResource(id = R.string.password),
                trailingIcon = if (showPassword) R.drawable.ic_eye_opened.toIcon() else  R.drawable.ic_eye_closed.toIcon(),
                onClickTrailingIcon = {
                    showPassword = !showPassword
                },
                onValueChange =  {
                    viewModel.obtainEvent(AuthorizationEnterLoginPasswordEvents.InputPassword(it))
                },
                visualTransformation = if (showPassword) VisualTransformation.None else  PasswordVisualTransformation()
            )
            Spacing(spase = 16.dp)
            Button(
                text = stringResource(id = R.string.enter),
                onClick = {},
                style = ButtonStyle(type = ButtonStyle.Type.PRIMARY)
            )
        }
    }
}