package com.bytesthetic.shoesapp.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor() =
        RippleTheme.defaultRippleColor(
            Color.White,
            lightTheme = true
        )

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleTheme.defaultRippleAlpha(
            Color.Black,
            lightTheme = true
        )
}