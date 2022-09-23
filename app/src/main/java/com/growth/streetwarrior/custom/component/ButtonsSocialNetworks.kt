package com.growth.streetwarrior.custom.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.growth.streetwarrior.R

@Composable
fun ButtonsSocialNetworks(loginWithGoogle:()-> Unit,
                          loginWithGoogle1:()-> Unit,
                          loginWithGoogle2:()-> Unit) {

   Button(
        onClick =  loginWithGoogle,
        colors = ButtonDefaults
            .buttonColors(containerColor = MaterialTheme.colorScheme.onSecondary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        contentPadding = PaddingValues(
            top = 15.dp,
            bottom = 15.dp,
        )
    ) {
        Icon(
            painter = painterResource(R.drawable.google),
            contentDescription = "Favorite",
            modifier = Modifier
                .size(20.dp)
                .padding(end=8.dp)
        )
        Text(text = stringResource(id = R.string.continue_with_google))

    }

    Button(
        onClick = loginWithGoogle1,
        colors = ButtonDefaults
            .buttonColors(containerColor = MaterialTheme.colorScheme.onSecondary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        contentPadding = PaddingValues(
            top = 15.dp,
            bottom = 15.dp
        )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_facebook),
            contentDescription = "Favorite",
            modifier = Modifier
                .size(20.dp)
                .padding(end=8.dp)
        )
        Text(text = stringResource(id = R.string.continue_with_facebook))

    }
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults
            .buttonColors(containerColor = MaterialTheme.colorScheme.onSecondary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        contentPadding = PaddingValues(
            top = 15.dp,
            bottom = 15.dp
        )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_apple),
            contentDescription = "Favorite",
            modifier = Modifier
                .size(20.dp)
                .padding(end=8.dp)
        )
        Text(text = stringResource(id = R.string.continue_with_apple))

    }
}

@Preview
@Composable
fun showButtons(){
   Column(

   ){
   }
}