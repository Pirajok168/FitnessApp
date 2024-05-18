package ru.mobile.authorization.data.api

import ru.fitness.mobile.data.web.api.UnauthorizedApi
import ru.fitness.mobile.data.web.api.model.Response
import ru.mobile.authorization.data.model.AuthCompletedPayload
import ru.mobile.authorization.data.model.LoginPayload

class AuthApiImpl(
    private val api: UnauthorizedApi
): AuthApi {
    override suspend fun login(loginPayload: LoginPayload): Response<AuthCompletedPayload> =
        api.post(path = "/login", body = loginPayload)

    override suspend fun refresh(refreshToken: String): Response<AuthCompletedPayload> =
        api.post(path = "/refresh", body = { "refreshToken" to refreshToken })
}