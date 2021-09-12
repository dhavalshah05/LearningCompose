package com.example.learningcompose

import androidx.annotation.FontRes
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

private sealed class AppFont(
    @FontRes val light: Int,
    @FontRes val regular: Int,
    @FontRes val bold: Int
) {
    object Nunito: AppFont(
        light = R.font.nunito_sans_light,
        regular = R.font.nunito_sans_regular,
        bold = R.font.nunito_sans_bold
    )
}

private val appFont: AppFont = AppFont.Nunito

val appFontFamily = FontFamily(
    Font(appFont.light, FontWeight.Light),
    Font(appFont.regular, FontWeight.Regular),
    Font(appFont.bold, FontWeight.Bold),
)

val FontWeight.Companion.Regular: FontWeight
    get() = FontWeight(1)