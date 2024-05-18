package ru.mobile.authorization.domain.model

import ru.fitness.mobile.data.web.model.UserTypePayload

data class AuthCompleted(
    val accessToken: String,
    val expiresIn: String,
    val userId: String,
    val refreshToken: String,
    val userType: UserTypePayload,
)