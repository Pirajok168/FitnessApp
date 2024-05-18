package ru.fitness.mobile.android.presentation

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(

    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 26.sp,
        fontSize = 24.sp
    ),
    headlineMedium = TextStyle(
        lineHeight = 18.sp,
        fontSize = 16.sp,
        color = Color(0xFF5D6563),
        fontWeight = FontWeight.Medium,
    )
)
