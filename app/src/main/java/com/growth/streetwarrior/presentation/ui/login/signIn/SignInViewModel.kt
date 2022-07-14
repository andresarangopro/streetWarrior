package com.growth.streetwarrior.presentation.ui.login.signIn

import androidx.lifecycle.ViewModel
import com.growth.streetwarrior.presentation.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SignInViewModel@Inject constructor(
    private val routeNavigator: RouteNavigator
): ViewModel(), RouteNavigator by routeNavigator {
    fun onStartClicked(){
        //TODO(IS JUST AN EXAMPLE BUT THE IDEA IS IMPLEMENT FUNCTION TO XROUTE.GET(0))
    }
}
