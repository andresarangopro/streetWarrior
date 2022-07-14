package com.growth.streetwarrior.ui.screens.auth.getstarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.growth.streetwarrior.ui.Screen
import com.growth.streetwarrior.ui.components.PrimaryButton
import com.growth.streetwarrior.ui.theme.StreetWarriorTheme

@Composable
fun GetStartedScreen(navController: NavController) {
    StreetWarriorTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.Center)
                    .padding(horizontal = 24.dp)
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
                PrimaryButton(
                    onClick = {
                        navController.navigate(Screen.DetailScreen.withArgs())
                    },
                    text = stringResource(id = R.string.get_started)
                )
                PrimaryButton(
                    onClick = {
                        navController.navigate(Screen.DetailScreen.withArgs())
                    },
                    text = stringResource(id = R.string.already_have_account)
                )
            }
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
fun PreviewGetStartedScreen() {
    GetStartedScreen(rememberNavController())
}