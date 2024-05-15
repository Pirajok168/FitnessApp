package ru.fitness.mobile.authorization.event

sealed class AuthorizationEvents {
    data class InputPassword(val value: String): AuthorizationEvents()

    data class InputLogin(val value: String): AuthorizationEvents()
}