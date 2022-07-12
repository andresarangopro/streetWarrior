package com.growth.streetwarrior.presentation.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.growth.streetwarrior.presentation.ui.login.*


@Composable
fun Navigation(viewModel: ViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.GetStartedLoginScreen.route){


        composable(route = Screen.GetStartedLoginScreen.route ){
            GetStartedScreen(navController = navController)
        }

        composable(
            route = Screen.MainScreen.route ){
            MainScreen(
                navController = navController,
                viewModel = viewModel as LoginViewModel
            )
        }

        composable(
            route = Screen.CreateAccountScreen.route){
            CreateNewAccountScreen(
                navController = navController,
                viewModel = viewModel as LoginViewModel
            )
         }


        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Philipp"
                    nullable = true
                }
            )
        ){ entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}



