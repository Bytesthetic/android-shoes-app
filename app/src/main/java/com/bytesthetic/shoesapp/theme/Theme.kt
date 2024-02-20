package com.bytesthetic.shoesapp.theme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorScheme = lightColorScheme(
    primaryContainer = Background,
    background = Background,
)

@Composable
fun ShoesAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme
    ) {
        CompositionLocalProvider(
            LocalRippleTheme provides AppRippleTheme,
            content = content
        )
    }
}