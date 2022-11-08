package com.bike.streetwarrior.presentation.ui.groupmotorbikershandle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.bike.streetwarrior.presentation.ui.groupmotorbikershandle.navigation.NavigationMainComponent
import com.bike.streetwarrior.presentation.ui.theme.StreetWarriorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            StreetWarriorTheme() {
                Scaffold {
                    NavigationMainComponent().navigationComponent(
                        navController, it
                    )
                }
            }
        }
    }
}