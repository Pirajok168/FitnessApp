package ru.mobile.authorization.data.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.mobile.authorization.data.api.AuthApi
import ru.mobile.authorization.data.api.AuthApiImpl
import ru.mobile.authorization.data.repository.AuthRepository
import ru.mobile.authorization.data.repository.AuthRepositoryImpl

fun authDataModule() = DI.Module("authDataModule"){
    bind<AuthApi>() {
        singleton {
            AuthApiImpl(
                api = instance()
            )
        }
    }

    bind<AuthRepository>() {
        singleton {
            AuthRepositoryImpl(
                authApi = instance()
            )
        }
    }
}