package com.fourdevs.dioaziz.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    // Primary Colors
    primary = Color(0xFF90A4AE), // Lighter variant of the primary color for dark mode
    onPrimary = Color(0xFF1C1C1E), // Dark text on primary color
    primaryContainer = Color(0xFF2E3A59), // Darker primary container color
    onPrimaryContainer = Color(0xFFB0BEC5), // Light text on primary container

    // Secondary Colors
    secondary = Color(0xFFB0BEC5), // Lighter variant of the secondary color
    onSecondary = Color(0xFF1C1C1E), // Dark text on secondary color
    secondaryContainer = Color(0xFF37474F), // Darker secondary container color
    onSecondaryContainer = Color(0xFFCFD8DC), // Light text on secondary container

    // Tertiary Colors
    tertiary = Color(0xFFA1887F), // A lighter variant of the taupe for dark mode
    onTertiary = Color(0xFF1C1C1E), // Dark text on tertiary color
    tertiaryContainer = Color(0xFF4E3F31), // Darker tertiary container color
    onTertiaryContainer = Color(0xFFBCAAA4), // Light text on tertiary container

    // Error Colors
    error = Color(0xFFEF9A9A), // Lighter red for errors in dark mode
    onError = Color(0xFF1C1C1E), // Dark text on error color
    errorContainer = Color(0xFFD32F2F), // Darker error container color
    onErrorContainer = Color(0xFFF9D8D8), // Light text on error container

    // Surface and Background Colors
    surface = Color(0xFF1C1C1E), // Dark surface color
    onSurface = Color(0xFFECEFF1), // Light text on dark surfaces
    surfaceBright = Color(0xFF2E3A59), // Darker surface variant
    surfaceDim = Color(0xFF121212), // Very dark gray for dimmed surfaces
    inverseSurface = Color(0xFFECEFF1), // Inverted light surface color
    inverseOnSurface = Color(0xFF1C1C1E), // Inverted dark text color
    inversePrimary = Color(0xFF90A4AE), // Lighter primary for inverted mode

    // Outline Colors
    outline = Color(0xFF78909C), // Slightly lighter outline for dark mode
    outlineVariant = Color(0xFFB0BEC5), // Even lighter outline variant

    // Scrim and Shadow
    scrim = Color(0xFF000000), // Standard black for scrims
)

private val LightColorScheme = lightColorScheme(
    // Primary Colors
    primary = Color(0xFF2E3A59), // A professional, muted blue
    onPrimary = Color(0xFFFFFFFF), // White text on primary color
    primaryContainer = Color(0xFF53687E), // Slightly lighter variant for containers
    onPrimaryContainer = Color(0xFF1A2B44), // Darker text color for primary containers

    // Secondary Colors
    secondary = Color(0xFF5A6A7A), // A muted slate gray-blue
    onSecondary = Color(0xFFFFFFFF), // White text on secondary color
    secondaryContainer = Color(0xFF778899), // Lighter variant for secondary containers
    onSecondaryContainer = Color(0xFF2C3A4B), // Darker text color for secondary containers

    // Tertiary Colors
    tertiary = Color(0xFF7D7464), // A warm, professional taupe
    onTertiary = Color(0xFFFFFFFF), // White text on tertiary color
    tertiaryContainer = Color(0xFF9C8B77), // Lighter taupe for containers
    onTertiaryContainer = Color(0xFF4E3F31), // Darker text color for tertiary containers

    // Error Colors
    error = Color(0xFFD32F2F), // A deep red for errors
    onError = Color(0xFFFFFFFF), // White text on error color
    errorContainer = Color(0xFFF9D8D8), // Light red for error containers
    onErrorContainer = Color(0xFF781A1A), // Darker text color for error containers

    // Surface and Background Colors
    surface = Color(0xFFF4F5F7), // A very light gray for surfaces
    onSurface = Color(0xFF1C1C1E), // Almost black text for readability
    surfaceBright = Color(0xFFFFFFFF), // Pure white for the brightest surface areas
    surfaceDim = Color(0xFFD1D5DB), // A dimmed light gray
    inverseSurface = Color(0xFF1C1C1E), // Inverted dark surface color
    inverseOnSurface = Color(0xFFF4F5F7), // Inverted light text color
    inversePrimary = Color(0xFF53687E), // Inverted primary for dark themes

    // Outline Colors
    outline = Color(0xFF909399), // A neutral mid-gray for outlines
    outlineVariant = Color(0xFFB0B3B8), // A lighter variant of the outline

    // Scrim and Shadow
    scrim = Color(0xFF000000), // Standard black for scrims
)

@Composable
fun DIOAzizTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}