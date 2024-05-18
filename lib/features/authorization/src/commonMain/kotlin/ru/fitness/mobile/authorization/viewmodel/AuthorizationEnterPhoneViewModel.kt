package ru.fitness.mobile.authorization.viewmodel

import com.adeo.kviewmodel.BaseSharedViewModel
import org.kodein.di.DI
import ru.fitness.mobile.authorization.authDi
import ru.fitness.mobile.authorization.event.AuthorizationEnterPhoneEvents
import ru.fitness.mobile.authorization.state.AuthorizationEnterPhoneState

class AuthorizationEnterPhoneViewModel:
    BaseSharedViewModel<AuthorizationEnterPhoneState, Nothing, AuthorizationEnterPhoneEvents>(AuthorizationEnterPhoneState()) {

    private val di: DI by lazy { authDi() }

    override fun obtainEvent(viewEvent: AuthorizationEnterPhoneEvents) = when(viewEvent){
        is AuthorizationEnterPhoneEvents.InputPhone -> viewState = viewState.copy(numberPhone = viewEvent.value)
    }
}