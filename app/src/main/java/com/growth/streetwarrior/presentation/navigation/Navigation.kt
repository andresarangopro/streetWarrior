package com.growth.streetwarrior.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import java.util.*


sealed class NavigationState{
    object  Idle: NavigationState()
    data class NavigateToRoute(val route: String, val id: String = UUID.randomUUID().toString()): NavigationState()
    data class PopToRoute(val staticRoute: String, val id: String = UUID.randomUUID().toString()): NavigationState()
    data class NavigateUp(val id: String = UUID.randomUUID().toString()): NavigationState()
}


interface INavigationComponent{

    @Composable
    fun navigationComponent(navHostController: NavHostController,
                            paddingValues: PaddingValues){}

}







