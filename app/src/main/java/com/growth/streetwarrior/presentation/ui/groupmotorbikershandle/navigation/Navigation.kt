package com.growth.streetwarrior.presentation.ui.groupmotorbikershandle.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.growth.streetwarrior.presentation.navigation.INavigationComponent
import com.growth.streetwarrior.presentation.ui.groupmotorbikershandle.listofgroups.ListOfGroupsListRoute


class NavigationMainComponent: INavigationComponent {

    @Composable
    override fun navigationComponent(navHostController: NavHostController,
                                     paddingValues: PaddingValues
    ) {
        NavHost(
            navController = navHostController,
            startDestination = ListOfGroupsListRoute.route,
            modifier = Modifier.padding(paddingValues)
        ) {
             ListOfGroupsListRoute.composable(this, navHostController)
        }
    }

}