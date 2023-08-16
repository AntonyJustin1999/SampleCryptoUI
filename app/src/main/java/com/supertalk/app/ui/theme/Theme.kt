package com.supertalk.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
    primary = VIOLET_LIGHT,
    primaryVariant = VIOLET_LIGHT,
    secondary = VIOLET_LIGHT
)

private val LightColorPalette = lightColors(
//    primary = VIOLET_DARK,
//    primaryVariant = VIOLET_DARK,
//    secondary = VIOLET_DARK


    primary = GROUND_GREEN,
    primaryVariant = GROUND_GREEN,
    secondary = GROUND_GREEN


    
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SuperTalkApplicationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val view = LocalView.current

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            window.navigationBarColor = colors.primary.toArgb()

            WindowCompat.getInsetsController(window, view)?.
            isAppearanceLightStatusBars = darkTheme
            WindowCompat.getInsetsController(window, view)?.
            isAppearanceLightNavigationBars = darkTheme
        }
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}