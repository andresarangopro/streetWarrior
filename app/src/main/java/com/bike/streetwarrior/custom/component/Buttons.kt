package com.bike.streetwarrior.custom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    color: Color,
    text: Int,
    onClick: () -> Unit,
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults
            .buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier,
        contentPadding = PaddingValues(
            top = 15.dp,
            bottom = 15.dp,
        )
    ){
        Text(text = stringResource(id = text))
    }
}


@Composable
fun ImageResource(id: Int, modifier: Modifier){
    val image: Painter = painterResource(id = id)
    Image(
        painter = image, contentDescription = "logo get started",
        modifier = modifier
    )
}