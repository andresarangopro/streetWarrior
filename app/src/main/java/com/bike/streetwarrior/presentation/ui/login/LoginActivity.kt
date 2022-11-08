package com.bike.streetwarrior.presentation.ui.login


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import com.bike.streetwarrior.presentation.ui.groupmotorbikershandle.MainActivity
import com.bike.streetwarrior.presentation.ui.login.navigation.NavigationLoginComponent
import com.bike.streetwarrior.presentation.ui.theme.StreetWarriorTheme
import dagger.hilt.android.AndroidEntryPoint


interface ActivityActions{
    fun openActivity(activityClass: Class<MainActivity>)
}

@AndroidEntryPoint
class LoginActivity : ComponentActivity(), ActivityActions {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            StreetWarriorTheme() {
                Scaffold {
                    NavigationLoginComponent().navigationComponent(
                        navController, it
                    )
                }
            }
        }
    }

    override fun openActivity(activityClass: Class<MainActivity>) {
        startActivity(Intent(this, activityClass))
    }

}