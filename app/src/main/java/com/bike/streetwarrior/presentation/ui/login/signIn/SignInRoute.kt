package com.bike.streetwarrior.presentation.ui.login.signIn


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.bike.streetwarrior.R
import com.bike.streetwarrior.custom.component.*
import com.bike.streetwarrior.presentation.KEY_CONTENT_PAGE_INDEX
import com.bike.streetwarrior.presentation.States
import com.bike.streetwarrior.presentation.navigation.NavRoute
import com.bike.streetwarrior.presentation.navigation.getOrThrow
import com.bike.streetwarrior.presentation.observe
import com.bike.streetwarrior.presentation.ui.groupmotorbikershandle.MainActivity
import com.bike.streetwarrior.presentation.ui.theme.GrayLight
import com.bike.streetwarrior.presentation.ui.theme.GrayLight_2
import com.bike.streetwarrior.presentation.ui.theme.StreetWarriorTheme


object SignInRoute : NavRoute<SignInViewModel> {
    override val route = "signIn/{$KEY_CONTENT_PAGE_INDEX}/"

    fun get(index: Int): String = route.replace("{$KEY_CONTENT_PAGE_INDEX}", "$index")

    fun getIndexFrom(savedStateHandle: SavedStateHandle) =
        savedStateHandle.getOrThrow<Int>(KEY_CONTENT_PAGE_INDEX)

    override fun getArguments(): List<NamedNavArgument> = listOf(
        navArgument(KEY_CONTENT_PAGE_INDEX) { type = NavType.IntType })

    @Composable
    override fun viewModel(): SignInViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: SignInViewModel) = ContentPage(
         viewModel
    )

}


@Composable
fun ContentPage(
    viewModel: SignInViewModel
){

    val mContext = LocalContext.current

    StreetWarriorTheme {
        var mail by remember {
            mutableStateOf("")
        }

        var pass by remember {
            mutableStateOf("")
        }
        var loader by remember {
            mutableStateOf(false)
        }

        val paramsMailAndPass = ParamsMailAndPassword(
            title = R.string.sign_in,
            onMailChange = { mail = it },
            onPassChange = { pass = it }
        )

        val startForResult =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                 if (result.resultCode == RESULT_OK) {
                    val intent = result.data
                    if (result.data != null) {
                        val task: Task<GoogleSignInAccount> =
                            GoogleSignIn.getSignedInAccountFromIntent(intent)
                        viewModel.finishLogin(task)
                    }
                }
            }


        fun validateStates(event: States<StatesSignInViewModel>?) {
            event?.getContentIfNotHandled()?.let { navigation ->
                when (navigation) {
                    is StatesSignInViewModel.OnIntentGoogleSignIn -> navigation.run{
                        startForResult.launch(intent)
                    }
                    is StatesSignInViewModel.ToMainActivity ->{
                        mContext.startActivity(Intent(mContext, MainActivity::class.java))
                    }

                    is StatesSignInViewModel.IsLoading ->{
                        loader = true
                    }
                }
            }
        }

        with(viewModel){
            LocalLifecycleOwner.current.observe(states,::validateStates)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayLight)

        ) {

            EmailAndPassword(
                paramsMailAndPass
            )
            Button(
                onClick = {
                    viewModel.loginWithEmailAndPassword(paramsMailAndPass)
                },
                colors = ButtonDefaults
                    .buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                contentPadding = PaddingValues(
                    top = 15.dp,
                    bottom = 15.dp,
                )
            ){
                Text(text = stringResource(id = R.string.sign_in))

            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.forgot_password),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )

            Divider(
                color = GrayLight_2,
                thickness = 2.dp,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            )

            ButtonsSocialNetworks(
                { viewModel.loginWithGoogle()},
                { viewModel.loginWithGoogle()}
            )
        }

        if(loader){
            ProgressBar()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun previewScreen() {

}

