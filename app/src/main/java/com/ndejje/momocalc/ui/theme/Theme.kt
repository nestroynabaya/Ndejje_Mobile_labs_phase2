package com.ndejje.momocalc.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.ndejje.momocalc.MoMoTypography
import androidx.compose.material3.darkColorScheme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.tooling.preview.Preview
import android.content.res.Configuration
import com.ndejje.momocalc.MoMoCalcScreen


private val LightColorScheme = lightColorScheme(
    primary         = NavyBlue,
    onPrimary       = White,
    secondary       = BrandGold,
    onSecondary     = NavyBlueDark,
    background      = LightGrey,
    onBackground    = DarkSurface,
    surface         = White,
    onSurface       = DarkSurface,
    error           = ErrorRed,
    onError         = OnErrorWhite
)

private val DarkColorScheme = darkColorScheme(
    primary         = BrandGold,        // gold becomes the hero in dark mode
    onPrimary       = NavyBlueDark,
    secondary       = NavyBlue,
    onSecondary     = White,
    background      = DarkBackground,
    onBackground    = OnDarkText,
    surface         = DarkSurface,
    onSurface       = OnDarkText,
    error           = ErrorRed,
    onError         = OnErrorWhite
)

@Composable
fun MoMoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // auto-detect by default
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = MoMoTypography,
        shapes      = MoMoShapes,
        content     = content
    )
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
fun PreviewLight() {
    MoMoAppTheme(darkTheme = false) {
        MoMoCalcScreen()
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewDark() {
    MoMoAppTheme(darkTheme = true) {
        MoMoCalcScreen()
    }
}