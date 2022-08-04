package com.growth.streetwarrior.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.growth.streetwarrior.R

@Composable
fun PrimaryButton(
    text: String = "",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults
            .buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun Preview() {
    PrimaryButton()
}