package com.growth.streetwarrior.presentation.ui.login.createAccount

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.growth.streetwarrior.R
import com.growth.streetwarrior.custom.component.*
import com.growth.streetwarrior.presentation.KEY_CONTENT_PAGE_INDEX
import com.growth.streetwarrior.presentation.navigation.NavRoute
import com.growth.streetwarrior.presentation.navigation.getOrThrow
import com.growth.streetwarrior.presentation.ui.theme.GrayLight
import com.growth.streetwarrior.presentation.ui.theme.GrayLight_2
import com.growth.streetwarrior.presentation.ui.theme.StreetWarriorTheme


object CreateAccountRoute : NavRoute<CreateAccountViewModel> {

    override val route = "createAccount/{$KEY_CONTENT_PAGE_INDEX}/"

    /**
     * Returns the route that can be used for navigating to this page.
     */
    fun get(index: Int): String = route.replace("{$KEY_CONTENT_PAGE_INDEX}", "$index")

    fun getIndexFrom(savedStateHandle: SavedStateHandle) =
        savedStateHandle.getOrThrow<Int>(KEY_CONTENT_PAGE_INDEX)

    override fun getArguments(): List<NamedNavArgument> = listOf(
        navArgument(KEY_CONTENT_PAGE_INDEX) { type = NavType.IntType })

    @Composable
    override fun viewModel(): CreateAccountViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: CreateAccountViewModel) = ContentPage(viewModel)
}


@Composable
fun ContentPage(
    viewModel: CreateAccountViewModel
){
    StreetWarriorTheme{
        var mail by remember{
            mutableStateOf("")
        }

        var pass by remember {
            mutableStateOf("")
        }

        var verifyPass by remember {
            mutableStateOf("")
        }

        val paramsMailAndPass = ParamsCreateAccount(
            title = R.string.create_account,
            onMailChange = {mail = it},
            onPassChange = {pass = it},
            onPassVerifyChange = {verifyPass = it},
        )


        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayLight)

        ) {

            CreateAccount(
                paramsMailAndPass
            )

            Button(
                onClick = {
                      viewModel.createAccount(ParamsCreateAccountViewModel(
                          mail,
                          pass,
                          verifyPass
                      ))
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
                Text(text = stringResource(id = R.string.create_account))

            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.already_have_account),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .clickable(enabled = true) {
                        viewModel.toSingInScreen()
                    }
            )

            Divider(
                color = GrayLight_2,
                thickness = 2.dp,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            )

            ButtonsSocialNetworks(
                { },
                {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewcreen() {

}


