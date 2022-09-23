package com.growth.streetwarrior.custom.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.growth.streetwarrior.R

data class ParamsInputText(
    val onPassChange : (String) -> Unit
)

@Composable
fun TextFieldPassword(
    paramsMailAndPassword: ParamsInputText
) {

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    var passStr by remember{
        mutableStateOf("")
    }

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
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon  = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(painter  = painterResource(id = R.drawable.hidden),
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp))
            }
        }
    )
}
