package com.growth.streetwarrior.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.growth.streetwarrior.R
import com.growth.streetwarrior.ui.Navigation
import com.growth.streetwarrior.ui.Screen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun GetStartedScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentSize(Alignment.Center)
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
                navController.navigate(Screen.DetailScreen.withArgs())
            },
            contentPadding = PaddingValues(
                top = 15.dp,
                bottom = 15.dp,
            ),
            colors = ButtonDefaults
                .buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ) {
            Text(text = stringResource(id = R.string.get_started))
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults
                .buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            contentPadding = PaddingValues(
                top = 15.dp,
                bottom = 15.dp,
            )
        ) {
            Text(text = stringResource(id = R.string.already_have_account))
        }
    }
}

@Composable
fun ImageResource(id: Int, modifier: Modifier) {
    val image: Painter = painterResource(id = id)
    Image(
        painter = image, contentDescription = "logo get started",
        modifier = modifier
    )
}

@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text, onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate(Screen.DetailScreen.withArgs(text))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To DetailScreen")
        }
    }
}


@Composable
fun DetailScreen(name: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello, $name")
    }
}

@Preview(showBackground = true)
@Composable
fun previewDetailScreen() {
    GetStartedScreen(rememberNavController())
}