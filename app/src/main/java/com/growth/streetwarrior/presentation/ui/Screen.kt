package com.growth.streetwarrior.presentation.ui

sealed class Screen(val route: String){
    object GetStartedLoginScreen : Screen("get_started_login_screen")
    object MainScreen : Screen("main_screen")
    object CreateAccountScreen : Screen("create_account_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
