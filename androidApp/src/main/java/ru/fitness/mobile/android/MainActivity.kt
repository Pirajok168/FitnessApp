package ru.fitness.mobile.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.fitness.mobile.authorization.screens.AuthorizationScreen
import ru.fitness.mobile.authorization.viewmodel.AuthorizationViewModel
import ru.fitness.mobile.view_model_factory.LocalOwnerViewModel
import ru.fitness.mobile.view_model_factory.OwnerViewModel
import ru.fitness.mobile.view_model_factory.ViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                CompositionLocalProvider(LocalOwnerViewModel provides OwnerViewModel()) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ViewModel(
                            key = AuthorizationViewModel::class.toString(),
                            factory = { AuthorizationViewModel() }) {
                            AuthorizationScreen(it)
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
