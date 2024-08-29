package com.fourdevs.dioaziz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fourdevs.dioaziz.R

val tiroBanglaFamily = FontFamily(
    Font(R.font.tiro_bangla_regular, FontWeight.Normal),
    Font(R.font.tiro_bangla_italic, FontWeight.Normal, FontStyle.Italic),
)
// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
        fontStyle = FontStyle.Normal
    ),
    displayMedium = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal
    ),
    displaySmall = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal
    ),
    headlineLarge = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal
    ),
    headlineMedium = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal
    ),
    headlineSmall = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal
    ),
    titleLarge = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal
    ),
    titleMedium = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
        fontStyle = FontStyle.Normal
    ),
    titleSmall = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontStyle = FontStyle.Normal
    ),
    bodyLarge = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontStyle = FontStyle.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
        fontStyle = FontStyle.Normal
    ),
    bodySmall = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
        fontStyle = FontStyle.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontStyle = FontStyle.Normal
    ),
    labelMedium = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontStyle = FontStyle.Normal
    ),
    labelSmall = TextStyle(
        fontFamily = tiroBanglaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontStyle = FontStyle.Normal
    )
)


