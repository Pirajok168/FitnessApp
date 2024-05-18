package ru.fitness.mobile.authorization.event

sealed class AuthorizationEnterPhoneEvents {

    data class InputPhone(val value: String): AuthorizationEnterPhoneEvents()
}