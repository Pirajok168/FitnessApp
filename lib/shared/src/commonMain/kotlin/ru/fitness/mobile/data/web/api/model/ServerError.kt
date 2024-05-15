package ru.fitness.mobile.data.web.api.model

sealed class ServerError: Error() {

    data object NotSent : ServerError()

    data object NonAuthorized : ServerError()

    data object Unresponsive: ServerError()

    data object Unknown: ServerError()
}