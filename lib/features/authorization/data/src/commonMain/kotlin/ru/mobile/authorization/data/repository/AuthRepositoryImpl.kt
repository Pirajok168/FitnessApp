package ru.mobile.authorization.data.repository

import ru.fitness.mobile.data.web.api.model.Response
import ru.mobile.authorization.data.api.AuthApi
import ru.mobile.authorization.data.model.AuthCompletedPayload
import ru.mobile.authorization.data.model.LoginPayload

class AuthRepositoryImpl(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun login(loginPayload: LoginPayload): Response<AuthCompletedPayload> =
        authApi.login(loginPayload)

    override suspend fun refresh(refreshToken: String): Response<AuthCompletedPayload> =
        authApi.refresh(refreshToken)
}