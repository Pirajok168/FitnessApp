package ru.fitness.mobile.data.web.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.fitness.mobile.data.web.api.AuthorizedApi
import ru.fitness.mobile.data.web.api.HttpEngineFactory
import ru.fitness.mobile.data.web.api.UnauthorizedApi

internal val ktorModule = DI.Module("KtorModule") {
    bind<HttpEngineFactory>() with singleton { HttpEngineFactory() }

    bind<HttpClient>() with singleton {
        val engine = instance<HttpEngineFactory>().createEngine()
        HttpClient(engine) {

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(UserAgent) {
                agent = "Mobile client"
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 10000
                socketTimeoutMillis = 10000
                connectTimeoutMillis = 10000
            }

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }

    bind {
        singleton {
            UnauthorizedApi(
                client = { instance() },
                json = Json
            )
        }
    }

    bind {
        singleton {
            AuthorizedApi(
                // loginDataRepository = instance<ILoginDataRepository>(),
                client = { instance() },
                json = Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }
}