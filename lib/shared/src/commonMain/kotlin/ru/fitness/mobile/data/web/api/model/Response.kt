package ru.fitness.mobile.data.web.api.model

sealed class Response<T> {

    companion object {

        fun Success(): Success<Unit> = Success(Unit)

        fun <T> Error(
            throwable: Throwable = IllegalArgumentException(),
            error: (Throwable) -> ServerError = { ServerError.NotSent }
        ): Error<T> =
            Error(origin = throwable, error = error(throwable))
    }

    data class Success<T>(val result: T) : Response<T>()
    data class Error<T>(val origin: Throwable, val error: ServerError) : Response<T>()

    val asError: Error<T>?
        get() = this as? Error<T>

    val isFailed: Boolean
        get() = this is Error<T>

    val asSuccessful: Success<T>?
        get() = this as? Success<T>

    val isSuccessful: Boolean
        get() = this is Success<T>

    suspend fun doOnSuccess(block: suspend (T) -> Unit): Response<T> =
        apply { asSuccessful?.result?.also { block(it) } }

    fun doOnError(block: () -> Unit): Response<T> =
        apply { asError?.also { block() } }


    fun doOnFinished(block: (Response<T>) -> Unit): Response<T> =
        apply { block(this) }


    fun ignoreResult() = transform { }

    suspend fun <R : Any> flatMap(request: suspend (T) -> Response<R>): Response<R> = when (this) {
        is Success -> request(result)
        is Error -> Error(origin, error)
    }

    fun <R> transform(transform: (T) -> R): Response<R> = when (this) {
        is Success -> Success(transform(result))
        is Error -> Error(origin, error)
    }
}
