package com.growth.streetwarrior.presentation.ui.login.getStarted

import androidx.lifecycle.ViewModel
import com.growth.streetwarrior.presentation.RouteNavigator
import com.growth.streetwarrior.presentation.ui.login.createAccount.CreateAccountRoute
import com.growth.streetwarrior.presentation.ui.login.signIn.SignInRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel@Inject constructor(
    private val routeNavigator: RouteNavigator
): ViewModel(), RouteNavigator by routeNavigator {
    fun onStartClicked(){
        navigateToRoute(CreateAccountRoute.get(0))
    }

    fun toSingInScreen(){
        navigateToRoute(SignInRoute.get(0))
    }
}

