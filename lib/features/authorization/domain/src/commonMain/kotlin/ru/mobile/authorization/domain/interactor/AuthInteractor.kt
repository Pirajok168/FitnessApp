package ru.mobile.authorization.domain.interactor

import ru.fitness.mobile.data.web.api.model.Response
import ru.mobile.authorization.data.model.AuthCompletedPayload
import ru.mobile.authorization.domain.model.AuthCompleted

interface AuthInteractor {
    suspend fun login(login: String, password: String): Response<AuthCompleted>

    suspend fun refresh(refreshToked: String): Response<AuthCompleted>
}