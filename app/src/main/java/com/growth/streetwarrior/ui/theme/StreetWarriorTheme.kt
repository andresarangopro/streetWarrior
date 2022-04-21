package com.growth.streetwarrior.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun RallyTheme(content: @Composable () -> Unit) {

    MaterialTheme(colors = ColorPalette, typography = Typography, content = content)
}