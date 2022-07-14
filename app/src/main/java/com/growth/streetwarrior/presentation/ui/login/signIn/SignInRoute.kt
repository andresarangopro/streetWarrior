package com.growth.streetwarrior.presentation.ui.login.signIn

import androidx.compose.foundation.background
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
import com.growth.streetwarrior.R
import com.growth.streetwarrior.custom.component.ButtonsSocialNetworks
import com.growth.streetwarrior.custom.component.EmailAndPassword
import com.growth.streetwarrior.custom.component.ParamsMailAndPassword
import com.growth.streetwarrior.presentation.navigation.NavRoute
import com.growth.streetwarrior.presentation.ui.theme.GrayLight
import com.growth.streetwarrior.presentation.ui.theme.GrayLight_2
import com.growth.streetwarrior.presentation.ui.theme.StreetWarriorTheme

object SignInRoute : NavRoute<SignInViewModel> {
    override val route = "signIn/"

    @Composable
    override fun viewModel(): SignInViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: SignInViewModel) = ContentPage(viewModel::onStartClicked)
}


@Composable
fun ContentPage(
    onStartClicked: () -> Unit
){
    StreetWarriorTheme{
        var mail by remember{
            mutableStateOf("")
        }

        var pass by remember {
            mutableStateOf("")
        }

        val paramsMailAndPass = ParamsMailAndPassword(
            title = R.string.sign_in,
            onMailChange = {mail = it},
            onPassChange = {pass = it}
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayLight)

        ) {

            EmailAndPassword(paramsMailAndPass)

            Button(
                onClick = {
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

            ButtonsSocialNetworks()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewScreen() {
    ContentPage({})
}

