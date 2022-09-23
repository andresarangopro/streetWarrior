package com.growth.streetwarrior.custom.component



import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.growth.streetwarrior.model.Response
import com.growth.streetwarrior.presentation.ui.login.signIn.SignInViewModel

@Composable
fun OneTapSignIn(
    viewModel: SignInViewModel = hiltViewModel(),
    launch: @Composable (result: BeginSignInResult) -> Unit
) {
    when(val oneTapSignInResponse = viewModel.oneTapSignInResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> oneTapSignInResponse.data?.let {
            launch(it)
        }
        is Response.Error -> LaunchedEffect(Unit) {
            print(oneTapSignInResponse.e)
        }
    }
}