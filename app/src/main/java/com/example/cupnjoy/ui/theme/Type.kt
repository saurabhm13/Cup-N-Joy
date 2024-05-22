package com.example.cupnjoy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cupnjoy.R

val tsukimiRounded = FontFamily(
    Font(R.font.tsukimi_rounded_regular, FontWeight.Normal),
    Font(R.font.tsukimi_rounded_medium, FontWeight.Medium),
    Font(R.font.tsukimi_rounded_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(

    headlineLarge = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    titleLarge = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    titleMedium = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    labelLarge = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),

    labelMedium = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)