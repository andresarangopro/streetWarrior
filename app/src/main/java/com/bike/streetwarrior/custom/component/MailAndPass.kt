package com.bike.streetwarrior.custom.component

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bike.streetwarrior.R


data class ParamsMailAndPassword(
    @StringRes val title: Int,
    val onMailChange : (String) -> Unit,
    val onPassChange : (String) -> Unit
)

data class ParamsCreateAccount(
    @StringRes val title: Int,
    val onMailChange : (String) -> Unit,
    val onPassChange : (String) -> Unit,
    val onPassVerifyChange : (String) -> Unit
)



@Composable
fun EmailAndPassword(
    paramsMailAndPassword: ParamsMailAndPassword
) {

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
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

    TextFieldPassword(ParamsInputText(paramsMailAndPassword.onPassChange))
}


@Composable
fun CreateAccount(
    paramsMailAndPassword: ParamsCreateAccount
) {
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    var verifyPassStr by remember{
        mutableStateOf("")
    }

    EmailAndPassword(paramsMailAndPassword = ParamsMailAndPassword(
        paramsMailAndPassword.title,
        paramsMailAndPassword.onMailChange,
        paramsMailAndPassword.onPassChange)
    )

    Spacer(modifier = Modifier.height(8.dp))

    TextFieldPassword(ParamsInputText(paramsMailAndPassword.onPassVerifyChange))

}

