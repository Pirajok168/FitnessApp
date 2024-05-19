package ru.fitness.mobile.authorization.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.fitness.mobile.authorization.navigation.util.AuthScreens
import ru.fitness.mobile.authorization.screens.AuthorizationEnterLoginPasswordScreen
import ru.fitness.mobile.authorization.screens.AuthorizationEnterPhoneScreen
import ru.fitness.mobile.authorization.viewmodel.AuthorizationEnterLoginPasswordViewModel
import ru.fitness.mobile.authorization.viewmodel.AuthorizationEnterPhoneViewModel
import ru.fitness.mobile.presentation.navigation.util.enterTransition
import ru.fitness.mobile.presentation.navigation.util.exitTransition
import ru.fitness.mobile.presentation.view_model_factory.ViewModel

fun NavGraphBuilder.authNavGraph() {
    composable(route = AuthScreens.Root.passRoute()) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = AuthScreens.AuthorizationEnterPhoneScreen.startDest()){
            composable(AuthScreens.AuthorizationEnterPhoneScreen.passRoute()){
                ViewModel(
                    key = AuthorizationEnterPhoneViewModel::class.toString(),
                    factory = { AuthorizationEnterPhoneViewModel() }) {
                    AuthorizationEnterPhoneScreen(
                        it, onChooseAnotherEnter = {
                            navController.navigate(AuthScreens.AuthorizationEnterLoginPasswordScreen.navigate())
                        }
                    )
                }
            }

            composable(
                AuthScreens.AuthorizationEnterLoginPasswordScreen.passRoute(),
                enterTransition = { enterTransition() },
                exitTransition = { exitTransition() }
            ){
                ViewModel(
                    key = AuthorizationEnterLoginPasswordViewModel::class.toString(),
                    factory = { AuthorizationEnterLoginPasswordViewModel() }) {
                    AuthorizationEnterLoginPasswordScreen(it, onBack = navController::popBackStack)
                }
            }
        }
    }
}