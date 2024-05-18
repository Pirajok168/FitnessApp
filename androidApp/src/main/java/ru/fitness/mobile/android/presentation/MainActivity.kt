package ru.fitness.mobile.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.fitness.mobile.authorization.screens.AuthorizationEnterLoginPasswordScreen
import ru.fitness.mobile.authorization.screens.AuthorizationEnterPhoneScreen
import ru.fitness.mobile.authorization.viewmodel.AuthorizationEnterLoginPasswordViewModel
import ru.fitness.mobile.authorization.viewmodel.AuthorizationEnterPhoneViewModel
import ru.fitness.mobile.view_model_factory.LocalOwnerViewModel
import ru.fitness.mobile.view_model_factory.OwnerViewModel
import ru.fitness.mobile.view_model_factory.ViewModel

enum class Route {
    A,
    B
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AppTheme(dynamicColor = false) {
                CompositionLocalProvider(LocalOwnerViewModel provides OwnerViewModel()) {
                    val navHostController = rememberNavController()
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(
                            navController = navHostController,
                            startDestination = Route.A.name
                        ) {
                            composable(Route.A.name) {
                                ViewModel(
                                    key = AuthorizationEnterPhoneViewModel::class.toString(),
                                    factory = { AuthorizationEnterPhoneViewModel() }) {
                                    AuthorizationEnterPhoneScreen(
                                        it, onChooseAnotherEnter = {
                                            navHostController.navigate(Route.B.name)
                                        }
                                    )
                                }
                            }

                            composable(
                                Route.B.name, enterTransition = {
                                    slideInHorizontally(
                                        initialOffsetX = {
                                            it
                                        }
                                    )
                                },
                                exitTransition = {
                                    slideOutHorizontally {
                                        it
                                    }
                                }) {
                                ViewModel(
                                    key = AuthorizationEnterLoginPasswordViewModel::class.toString(),
                                    factory = { AuthorizationEnterLoginPasswordViewModel() }) {
                                    AuthorizationEnterLoginPasswordScreen(it, onBack = navHostController::popBackStack)
                                }
                            }
                        }

                    }
                }

            }
        }
    }
}


