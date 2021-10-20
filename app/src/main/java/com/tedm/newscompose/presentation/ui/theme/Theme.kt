package com.tedm.newscompose.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val ColorPalette = darkColors(
    primary = LightGreen,
    primaryVariant = Purple700,
    secondary = Teal200,
    onSurface = LightGreen,
    surface = White
)

@Composable
fun NewsComposeTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}