package ru.mobile.authorization.data.api

import ru.fitness.mobile.data.web.api.model.Response
import ru.mobile.authorization.data.model.AuthCompletedPayload
import ru.mobile.authorization.data.model.LoginPayload

interface AuthApi {
    suspend fun login(loginPayload: LoginPayload): Response<AuthCompletedPayload>

    suspend fun refresh(refreshToken: String): Response<AuthCompletedPayload>
}