package com.growth.streetwarrior.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.growth.streetwarrior.presentation.ui.login.createAccount.CreateAccountRoute
import com.growth.streetwarrior.presentation.ui.login.signIn.SignInRoute
import java.util.*


sealed class NavigationState{
    object  Idle: NavigationState()
    data class NavigateToRoute(val route: String, val id: String = UUID.randomUUID().toString()): NavigationState()
    data class PopToRoute(val staticRoute: String, val id: String = UUID.randomUUID().toString()): NavigationState()
    data class NavigateUp(val id: String = UUID.randomUUID().toString()): NavigationState()
}

@Composable
fun NavigationComponent(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = HomeRoute.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        HomeRoute.composable(this, navHostController)
        CreateAccountRoute.composable(
            this, navHostController
        )
        SignInRoute.composable(
            this, navHostController
        )
    }
}



