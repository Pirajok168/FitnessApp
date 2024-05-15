package ru.fitness.mobile.di

import org.kodein.di.DI
import org.kodein.di.LazyDI
import ru.fitness.mobile.data.web.di.ktorModule

val sharedDi: DI = LazyDI {
    DI {
        importOnce(ktorModule)
    }
}