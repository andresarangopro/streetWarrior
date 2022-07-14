package com.growth.streetwarrior.custom.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.growth.streetwarrior.R


data class ParamsMailAndPassword(
    @StringRes val title: Int,
    val onMailChange : (String) -> Unit,
    val onPassChange : (String) -> Unit
)

@Composable
fun EmailAndPassword(
    paramsMailAndPassword: ParamsMailAndPassword
) {


    var mailStr by remember{
        mutableStateOf("")
    }
    var passStr by remember{
        mutableStateOf("")
    }

    Text(
        text = stringResource(id = paramsMailAndPassword.title),
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)

    )
    Spacer(modifier = Modifier.height(8.dp))
    TextField(value = mailStr, onValueChange = {
        mailStr = it
        paramsMailAndPassword.onMailChange(mailStr)

    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.onSecondary
        ),
        placeholder = {
            Text(text = stringResource(id = R.string.email_adress))
        }
    )

    TextField(value = passStr, onValueChange = {
        passStr = it
        paramsMailAndPassword.onPassChange(passStr)
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.onSecondary
        ),
        placeholder = {
            Text(text = stringResource(id = R.string.password))
        }
    )
}

