package com.example.learningcompose.circularprogress

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CircularProgressIndicatorStyle(
    val progressColor: Color = Color.Green,
    val progressBackgroundColor: Color = Color.LightGray,
    val radius: Dp = 100.dp,
    val fontSize: TextUnit = 15.sp,
    val stroke: Dp = 4.dp
)
