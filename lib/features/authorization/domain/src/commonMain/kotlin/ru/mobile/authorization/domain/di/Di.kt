package ru.mobile.authorization.domain.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.mobile.authorization.data.api.AuthApi
import ru.mobile.authorization.data.api.AuthApiImpl
import ru.mobile.authorization.data.di.authDataModule
import ru.mobile.authorization.data.repository.AuthRepository
import ru.mobile.authorization.data.repository.AuthRepositoryImpl
import ru.mobile.authorization.domain.interactor.AuthInteractor
import ru.mobile.authorization.domain.interactor.AuthInteractorImpl

fun authDomainModule() = DI.Module("authDomainModule"){
    importOnce(authDataModule())
    bind<AuthInteractor>() {
        singleton {
            AuthInteractorImpl(instance())
        }
    }
}