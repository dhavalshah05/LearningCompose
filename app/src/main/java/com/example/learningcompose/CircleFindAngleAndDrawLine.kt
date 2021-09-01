package com.example.learningcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import kotlin.math.*

@Composable
fun CircleFindAngleAndDrawLine(
    onAngleCalculate: (Double) -> Unit
) {
    val radius = 100F
    val ballCenter = Offset(300F, 300F)

    var angle by remember {
        mutableStateOf(0.0)
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .pointerInput(true) {
                detectTapGestures { tapOffset ->
                    val x = ballCenter.x - tapOffset.x
                    val y = ballCenter.y - tapOffset.y
                    val calculatedAngle = Math.toDegrees(-atan2(x, y).toDouble())
                    val actualAngle = if (calculatedAngle in -180.0..0.0) {
                        calculatedAngle + 360
                    } else {
                        calculatedAngle
                    }
                    onAngleCalculate.invoke(actualAngle)
                    angle = actualAngle
                }
            }
    ) {
        drawCircle(
            radius = radius,
            center = ballCenter,
            color = Color.Red,
            style = Stroke()
        )

        val degree = Math.toRadians(angle - 90.0)
        val x = radius * cos(degree) + 300
        val y = radius * sin(degree) + 300
        val lineOffset = Offset(x.toFloat(), y.toFloat())

        drawLine(
            start = ballCenter,
            end = lineOffset,
            color = Color.Blue
        )
    }
}