package com.growth.streetwarrior.presentation.ui.login.createAccount

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.growth.streetwarrior.presentation.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


data class CreateAccountViewModelState(
    val title: String,
    val counterValue: Int,
)

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val routeNavigator: RouteNavigator,
) : ViewModel(), RouteNavigator by routeNavigator { // prefer delegation over inheritance

    private val index = CreateAccountRoute.getIndexFrom(savedStateHandle)

    var viewState by mutableStateOf(
        CreateAccountViewModelState(title = "Page $index", counterValue = 0)
    )

    fun onNextClicked() {
        navigateToNextPage()
    }

    fun onUpClicked() {
        navigateUp()
    }

    fun onNextWithDelayClicked() {
        viewModelScope.launch {
            delay(4000)
            navigateToNextPage()
        }
    }

    private fun navigateToNextPage() {
        navigateToRoute(CreateAccountRoute.get(index + 1))
    }

    fun onIncreaseCounterClicked() {
        viewState = viewState.copy(counterValue = viewState.counterValue + 1)
    }
}

