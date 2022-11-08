package com.bike.streetwarrior.custom.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.bike.streetwarrior.model.Response
import com.bike.streetwarrior.presentation.ui.login.signIn.SignInViewModel

@Composable
fun SignInWithGoogle(
    viewModel: SignInViewModel = hiltViewModel(),
    navigateToHomeScreen: @Composable (signedIn: Boolean) -> Unit
) {
    when(val signInWithGoogleResponse = viewModel.signInWithGoogleResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> signInWithGoogleResponse.data?.let { signedIn ->
            navigateToHomeScreen(signedIn)
        }
        is Response.Error -> LaunchedEffect(Unit) {
            print(signInWithGoogleResponse.e)
        }
    }
}