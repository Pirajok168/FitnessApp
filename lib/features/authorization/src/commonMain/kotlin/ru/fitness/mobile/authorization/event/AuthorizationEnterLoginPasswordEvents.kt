package ru.fitness.mobile.authorization.event

sealed class AuthorizationEnterLoginPasswordEvents {

    data class InputLogin(val value: String): AuthorizationEnterLoginPasswordEvents()
    data class InputPassword(val value: String): AuthorizationEnterLoginPasswordEvents()
}