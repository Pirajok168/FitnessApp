package ru.mobile.authorization.domain.interactor

import ru.fitness.mobile.data.web.api.model.Response
import ru.mobile.authorization.data.model.LoginPayload
import ru.mobile.authorization.data.repository.AuthRepository
import ru.mobile.authorization.domain.model.AuthCompleted

class AuthInteractorImpl(
    private val repository: AuthRepository
): AuthInteractor {
    override suspend fun login(login: String, password: String): Response<AuthCompleted> =
        repository.login(LoginPayload(login, password))
            .transform {
                it.run {
                    AuthCompleted(accessToken, expiresIn, userId, refreshToken, userType)
                }
            }

    override suspend fun refresh(refreshToked: String): Response<AuthCompleted> =
        repository.refresh(refreshToked)
            .transform {
                it.run {
                    AuthCompleted(accessToken, expiresIn, userId, refreshToken, userType)
                }
            }
}