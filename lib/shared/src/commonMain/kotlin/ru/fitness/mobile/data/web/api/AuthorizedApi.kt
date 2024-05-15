@file:Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")

package ru.fitness.mobile.data.web.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.utils.EmptyContent
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import ru.fitness.mobile.data.web.api.model.Response


class AuthorizedApi(
    // private val loginDataRepository: ILoginDataRepository,
    client: () -> HttpClient,
    json: Json
) : Api(client, json) {

    suspend inline fun <reified T> get(
        path: String,
        host: String = "esstu.ru",
        block: HttpRequestBuilder.() -> Unit = {}
    ): Response<T> = checkedRequest {
        get {
            url(host = host, path = path) {
              //  bearerAuth(loginDataRepository.getAccessToken()?.accessToken ?: return@url)
            }
            block()
        }.body()
    }

    suspend inline fun <reified T> post(
        path: String,
        body: Any = EmptyContent,
        host: String = "esstu.ru",
        block: HttpRequestBuilder.() -> Unit = {}
    ): Response<T> = checkedRequest {
        post {
            url(host = host, path = path) {
                setBody(body)
                contentType(ContentType.Application.Json)
             //   bearerAuth(loginDataRepository.getAccessToken()?.accessToken ?: return@url)
            }
            block()
        }.body()
    }

    internal suspend inline fun <reified T> checkedRequest(method: HttpClient.() -> T): Response<T> {
        /*if (!loginDataRepository.isUserAuthorized()) {
            // Будет рефрег токена
            return request(method)
        }*/


        return request(method)
    }



}