package ru.mobile.authorization.data.repository

import ru.fitness.mobile.data.web.api.model.Response
import ru.mobile.authorization.data.model.AuthCompletedPayload
import ru.mobile.authorization.data.model.LoginPayload

interface AuthRepository {
    suspend fun login(loginPayload: LoginPayload): Response<AuthCompletedPayload>

    suspend fun refresh(refreshToken: String): Response<AuthCompletedPayload>
}