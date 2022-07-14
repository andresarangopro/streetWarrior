package com.growth.streetwarrior.presentation.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import com.growth.streetwarrior.presentation.navigation.NavigationComponent
import com.growth.streetwarrior.presentation.ui.theme.StreetWarriorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            StreetWarriorTheme() {
                Scaffold {
                    NavigationComponent(navController, it)
                }
            }
        }
    }
}