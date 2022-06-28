package com.growth.streetwarrior.presentation.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.growth.streetwarrior.R
import com.growth.streetwarrior.custom.component.ButtonsSocialNetworks
import com.growth.streetwarrior.custom.component.EmailAndPassword
import com.growth.streetwarrior.custom.component.ImageResource
import com.growth.streetwarrior.custom.component.ParamsMailAndPassword
import com.growth.streetwarrior.presentation.ui.Navigation
import com.growth.streetwarrior.presentation.ui.Screen
import com.growth.streetwarrior.presentation.ui.theme.GrayLight
import com.growth.streetwarrior.presentation.ui.theme.GrayLight_2
import com.growth.streetwarrior.presentation.ui.theme.White
import com.growth.streetwarrior.presentation.ui.theme.Yellow
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: LoginViewModel by viewModels()
        setContent {
            Navigation(viewModel)
        }
    }
}

@Composable
fun GetStartedScreen(navController: NavController){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ImageResource(
            id = R.drawable.pixlr_bg_result,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        
        Text(
            text = stringResource(id = R.string.welcome),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.about),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.gray),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            },
            contentPadding = PaddingValues(
                top = 15.dp,
                bottom = 15.dp,
            ),
            colors = ButtonDefaults
            .buttonColors(
                backgroundColor = Yellow),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ){
            Text(text = stringResource(id = R.string.get_started))
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults
                .buttonColors(backgroundColor = White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            contentPadding = PaddingValues(
                top = 15.dp,
                bottom = 15.dp,
            )
        ){
            Text(text = stringResource(id = R.string.already_have_account))

        }
    }
}

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: LoginViewModel
){
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
                .buttonColors(backgroundColor = Yellow),
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

@Composable
fun DetailScreen(name: String?){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello, $name")
    }
}

