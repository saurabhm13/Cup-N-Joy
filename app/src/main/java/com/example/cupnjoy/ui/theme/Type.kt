package com.example.cupnjoy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
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
        fontSize = 32.sp,
        color = Color.White
    ),

    titleLarge = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Color.White
    ),

    titleMedium = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.White
    ),

    labelLarge = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color.White
    ),

    labelMedium = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.White
    ),

    labelSmall = TextStyle(
        fontFamily = tsukimiRounded,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.White
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)