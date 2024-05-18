package ru.mobile.authorization.data.model


import kotlinx.serialization.Serializable

@Serializable
data class LoginPayload(
    val login: String,
    val password:String
)
