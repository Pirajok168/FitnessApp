package ru.fitness.mobile.data.web.api

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.HttpResponsePipeline
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.fitness.mobile.data.web.api.model.Response
import ru.fitness.mobile.data.web.api.model.ServerError


abstract class Api(
    private val client: () -> HttpClient,
    internal val json: Json
) {

    internal suspend inline fun <reified T> request(
        method: HttpClient.() -> T
    ): Response<T> {
        var response: HttpResponse? = null
        var status: HttpStatusCode? = null

        return with(runCatching {
            val client = client()
            client.responsePipeline.intercept(HttpResponsePipeline.Parse) {
                response = context.response
                status = context.response.status
            }

            client.method()
        }) {
            status?.also {
                if (it == HttpStatusCode.Unauthorized) {

                    return Response.Error(error = { ServerError.NonAuthorized })
                } else if (it.value in 500..505) {
                    return Response.Error(error = { ServerError.Unresponsive } )
                } else if (it == HttpStatusCode.BadRequest && response != null) {
                    return Response.Error(error = { ServerError.Unresponsive } )
                }
            }

            runCatching {
                (getOrThrow() as? HttpResponse)?.let { response ->
                    if (response.status == HttpStatusCode.NoContent) {
                        return Response.Success(getOrThrow())
                    }
                }
            }.onFailure {
                exceptionOrNull()
                    ?.also { e ->
                        if (e !is kotlin.coroutines.cancellation.CancellationException) {
                            return Response.Error(error = { ServerError.Unknown })
                        }
                    }
            }

            Response.Success(getOrThrow())
        }
    }

}

@Serializable
data class SimpleError(
    val error: String?,
    val error_description: String?
)