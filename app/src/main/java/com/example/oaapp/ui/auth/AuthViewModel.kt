package com.example.oaapp.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.oaapp.models.AuthToken
import com.example.oaapp.repository.auth.AuthRepository
import com.example.oaapp.ui.BaseViewModel
import com.example.oaapp.ui.DataState
import com.example.oaapp.ui.auth.state.AuthStateEvent
import com.example.oaapp.ui.auth.state.AuthStateEvent.*
import com.example.oaapp.ui.auth.state.AuthViewState
import com.example.oaapp.ui.auth.state.LoginFields
import com.example.oaapp.ui.auth.state.RegistrationFields
import com.example.oaapp.util.AbsentLiveData
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository
) : BaseViewModel<AuthStateEvent, AuthViewState>() {

    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>> {
        when(stateEvent){

            is LoginAttemptEvent -> {
                return authRepository.attemptLogin(
                    stateEvent.email,
                    stateEvent.password
                )
            }

            is RegisterAttemptEvent -> {
                return authRepository.attemptRegistration(
                    stateEvent.email,
                    stateEvent.username,
                    stateEvent.password,
                    stateEvent.confirm_password
                )
            }

            is CheckPreviousAuthEvent -> {
                return AbsentLiveData.create()
            }

        }
    }

    override fun initNewViewState(): AuthViewState {
        return AuthViewState()
    }

    fun setRegistrationFields(registrationFields: RegistrationFields){
        val update = getCurrentViewStateOrNew()
        if(update.registrationFields == registrationFields){
            return
        }
        update.registrationFields = registrationFields
        _viewState.value = update
    }

    fun setLoginFields(loginFields: LoginFields){
        val update = getCurrentViewStateOrNew()
        if(update.loginFields == loginFields){
            return
        }
        update.loginFields = loginFields
        _viewState.value = update
    }

    fun setAuthToken(authToken: AuthToken){
        val update = getCurrentViewStateOrNew()
        if(update.authToken == authToken){
            return
        }
        update.authToken = authToken
        _viewState.value = update
    }

    fun cancelActiveJobs(){
        authRepository.cancelActiveJobs()
    }


    override fun onCleared() {
        super.onCleared()
        cancelActiveJobs()
    }
}