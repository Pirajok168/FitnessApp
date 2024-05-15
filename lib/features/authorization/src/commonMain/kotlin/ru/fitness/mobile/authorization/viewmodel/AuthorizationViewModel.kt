package ru.fitness.mobile.authorization.viewmodel

import com.adeo.kviewmodel.BaseSharedViewModel
import ru.fitness.mobile.authorization.event.AuthorizationEvents
import ru.fitness.mobile.authorization.state.AuthorizationState

class AuthorizationViewModel:
    BaseSharedViewModel<AuthorizationState, Nothing, AuthorizationEvents>(AuthorizationState()) {

    override fun obtainEvent(viewEvent: AuthorizationEvents) = when(viewEvent){
        is AuthorizationEvents.InputLogin -> viewState = viewState.copy(login = viewEvent.value)
        is AuthorizationEvents.InputPassword -> viewState = viewState.copy(password = viewEvent.value)
    }
}