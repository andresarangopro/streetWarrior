package com.growth.streetwarrior.custom.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import  androidx.compose.material.Button
import com.growth.streetwarrior.R
import com.growth.streetwarrior.presentation.ui.theme.White

@Composable
fun ButtonsSocialNetworks(){

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
        onClick = { /*TODO*/ },
        colors = ButtonDefaults
            .buttonColors(backgroundColor = White),
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
            .buttonColors(backgroundColor = White),
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
    ButtonsSocialNetworks()
}