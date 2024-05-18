package ru.mobile.authorization.data.model

import kotlinx.serialization.Serializable
import ru.fitness.mobile.data.web.model.UserTypePayload

@Serializable
data class AuthCompletedPayload(
    val accessToken: String,
    val expiresIn: String,
    val userId: String,
    val refreshToken: String,
    val userType: UserTypePayload,
)