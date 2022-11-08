package com.bike.streetwarrior.presentation.navigation


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bike.streetwarrior.R
import com.bike.streetwarrior.custom.component.ImageResource
import com.bike.streetwarrior.presentation.ui.login.getStarted.GetStartedViewModel
import com.bike.streetwarrior.presentation.ui.theme.StreetWarriorTheme

object HomeRoute : NavRoute<GetStartedViewModel> {

    override val route = "home/"

    @Composable
    override fun viewModel(): GetStartedViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: GetStartedViewModel) = ContentPage(viewModel)
}


@Composable
fun ContentPage(
    getStartedViewModel: GetStartedViewModel
) {
    StreetWarriorTheme {
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
                    .padding(15.dp, 0.dp)
                    .wrapContentSize(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    getStartedViewModel.onStartClicked()
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
                onClick = {
                    getStartedViewModel.toSingInScreen()
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
            ) {
                Text(text = stringResource(id = R.string.already_have_account))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun previewScreen() {
    ContentPage(hiltViewModel())
}
