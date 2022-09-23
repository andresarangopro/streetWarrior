package com.growth.streetwarrior.presentation.ui.groupmotorbikershandle.listofgroups

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.growth.streetwarrior.R
import com.growth.streetwarrior.custom.component.ParamsMailAndPassword
import com.growth.streetwarrior.presentation.navigation.NavRoute
import com.growth.streetwarrior.presentation.ui.theme.GrayLight
import com.growth.streetwarrior.presentation.ui.theme.StreetWarriorTheme

object ListOfGroupsListRoute : NavRoute<ListOfGroupsViewModel> {

    override val route = "listOfGroups/"

    @Composable
    override fun viewModel(): ListOfGroupsViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: ListOfGroupsViewModel) =
            ContentPage(viewModel)
}


@Composable
fun ContentPage(
    listOfGroupsViewModel: ListOfGroupsViewModel
) {

    StreetWarriorTheme{
  
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayLight)

        ) {
            Text(text = "Bienvenido")
        }
    }

}