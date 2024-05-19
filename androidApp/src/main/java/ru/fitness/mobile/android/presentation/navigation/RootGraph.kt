package ru.fitness.mobile.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.fitness.mobile.authorization.navigation.authNavGraph
import ru.fitness.mobile.authorization.navigation.util.AuthScreens

@Composable
fun RootGraph() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = AuthScreens.Root.passRoute()){
        authNavGraph()
    }
}