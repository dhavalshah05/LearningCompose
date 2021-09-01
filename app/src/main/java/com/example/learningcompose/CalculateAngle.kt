package com.example.learningcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import kotlin.math.*

@Composable
fun CalculateAngle(
    onAngleCalculate: (Double) -> Unit
) {
    val radius = 100F
    val ballCenter = Offset(300F, 300F)

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .pointerInput(true) {
                detectTapGestures { tapOffset ->
                    val x = ballCenter.x - tapOffset.x
                    val y = ballCenter.y - tapOffset.y
                    val angle = Math.toDegrees(-atan2(x, y).toDouble())
                    val actualAngle = if (angle in -180.0..0.0) {
                        angle + 360
                    } else {
                        angle
                    }
                    onAngleCalculate.invoke(actualAngle)
                }
            }
    ) {
        drawCircle(
            radius = radius,
            center = ballCenter,
            color = Color.Red
        )
    }
}