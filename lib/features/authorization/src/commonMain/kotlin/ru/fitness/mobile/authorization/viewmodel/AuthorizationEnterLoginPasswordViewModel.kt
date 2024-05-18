package ru.fitness.mobile.authorization.viewmodel

import com.adeo.kviewmodel.BaseSharedViewModel
import org.kodein.di.DI
import ru.fitness.mobile.authorization.authDi
import ru.fitness.mobile.authorization.event.AuthorizationEnterLoginPasswordEvents
import ru.fitness.mobile.authorization.event.AuthorizationEnterPhoneEvents
import ru.fitness.mobile.authorization.state.AuthorizationEnterLoginPasswordState
import ru.fitness.mobile.authorization.state.AuthorizationEnterPhoneState

class AuthorizationEnterLoginPasswordViewModel:
    BaseSharedViewModel<AuthorizationEnterLoginPasswordState, Nothing, AuthorizationEnterLoginPasswordEvents>(AuthorizationEnterLoginPasswordState()) {

    private val di: DI by lazy { authDi() }

    override fun obtainEvent(viewEvent: AuthorizationEnterLoginPasswordEvents) = when(viewEvent){
        is AuthorizationEnterLoginPasswordEvents.InputLogin -> viewState = viewState.copy(login = viewEvent.value)
        is AuthorizationEnterLoginPasswordEvents.InputPassword -> viewState = viewState.copy(password = viewEvent.value)
    }
}