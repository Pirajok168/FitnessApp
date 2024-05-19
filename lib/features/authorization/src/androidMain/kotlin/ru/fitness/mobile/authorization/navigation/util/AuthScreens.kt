package ru.fitness.mobile.authorization.navigation.util

import androidx.navigation.NavType
import ru.fitness.mobile.presentation.navigation.Route

sealed class AuthScreens<T>(
    route: String? = null,
    navArgs: Map<T, NavType<*>> = emptyMap()
) : Route<T>(route, navArgs) {
    data object Root : AuthScreens<Unit>()

    data object AuthorizationEnterPhoneScreen : AuthScreens<Unit>()

    data object AuthorizationEnterLoginPasswordScreen : AuthScreens<Unit>()
}