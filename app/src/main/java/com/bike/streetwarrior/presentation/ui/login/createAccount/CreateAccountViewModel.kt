package com.bike.streetwarrior.presentation.ui.login.createAccount


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.bike.streetwarrior.model.Response
import com.bike.streetwarrior.presentation.BaseViewModel
import com.bike.streetwarrior.presentation.RouteNavigator
import com.bike.streetwarrior.presentation.ui.login.signIn.SignInRoute
import com.bike.streetwarrior.usecases.CreateAccountWithEmailAndPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val routeNavigator: RouteNavigator,
    val createAccountWithEmailAndPasswordUseCase: CreateAccountWithEmailAndPasswordUseCase
) : BaseViewModel<EventsCreateAccountViewModel,
        StatesCreateAccountViewModel>(), RouteNavigator by routeNavigator { // prefer delegation over inheritance

    private val index = CreateAccountRoute.getIndexFrom(savedStateHandle)

    var viewState by mutableStateOf(
        CreateAccountViewModelState(title = "Page $index", counterValue = 0)
    )

    fun createAccount(params: ParamsCreateAccountViewModel) = viewModelScope.launch {
        Log.d("success", "success ${params.mail} ${params.password}")
        createAccountWithEmailAndPasswordUseCase.run(params.mail,
            params.password).collect{ response ->
                when(response){
                    is Response.Loading ->{}
                    is Response.Success ->{
                        Log.d("success", "success")
                    }
                    is Response.Error ->{
                        Log.d("err", "${response.e?.message}")
                    }
                }

        }
    }


    fun toSingInScreen(){
        navigateToRoute(SignInRoute.get(0))
    }

    private fun navigateToNextPage() {
        navigateToRoute(CreateAccountRoute.get(index + 1))
    }

    fun onIncreaseCounterClicked() {
        viewState = viewState.copy(counterValue = viewState.counterValue + 1)
    }

    override fun manageEvent(event: EventsCreateAccountViewModel) {
        when(event){
            is EventsCreateAccountViewModel.CreateAccountWithEmailAndPass->{
                createAccount(event.params)
            }
            else ->{}
        }
    }
}

