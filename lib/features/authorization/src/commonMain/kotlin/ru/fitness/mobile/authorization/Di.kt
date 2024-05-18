package ru.fitness.mobile.authorization

import org.kodein.di.DI
import ru.fitness.mobile.di.sharedDi
import ru.mobile.authorization.domain.di.authDomainModule

internal fun authDi()  = DI {
    extend(sharedDi)
    importOnce(authDomainModule())
}