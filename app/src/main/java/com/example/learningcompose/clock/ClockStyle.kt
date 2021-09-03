package com.example.learningcompose.clock

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ClockStyle(
    val radius: Dp = 100.dp,
    val clockColor: Color = Color.LightGray,
    val minuteLineColor: Color = Color.Gray,
    val hourLineColor: Color = Color.Blue,
    val minuteLineLength: Dp = 12.dp,
    val hourLineLength: Dp = 20.dp
)
