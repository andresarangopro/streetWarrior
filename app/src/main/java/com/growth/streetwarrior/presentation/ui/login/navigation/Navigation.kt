package com.growth.streetwarrior.presentation.ui.login.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.growth.streetwarrior.presentation.navigation.HomeRoute
import com.growth.streetwarrior.presentation.navigation.INavigationComponent
import com.growth.streetwarrior.presentation.ui.login.createAccount.CreateAccountRoute
import com.growth.streetwarrior.presentation.ui.login.signIn.SignInRoute

class NavigationLoginComponent: INavigationComponent {

    @Composable
    override fun navigationComponent(navHostController: NavHostController,
                                     paddingValues: PaddingValues
    ) {
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
}