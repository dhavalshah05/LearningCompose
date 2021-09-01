package com.example.learningcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Circle2() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val radius = 200F

        drawCircle(
            center = center,
            color = Color.Red,
            radius = radius,
            style = Stroke(width = 1F)
        )

        //val radiant = (90 * PI).toFloat() / 180
        for (i in 0..29) {
            val radiant = Math.toRadians((360.0 / 30.0) * i).toFloat()
            val x = radius * cos(radiant) + center.x
            val y = radius * sin(radiant) + center.y
            val startPoint = Offset(x, y)

            drawLine(
                start = startPoint,
                end = center.copy(x = x.minus(50), y = y.minus(50)),
                color = Color.Blue
            )
        }

        drawCircle(
            center = center.copy(x = center.x - 50, y = center.y - 50),
            color = Color.Red,
            radius = radius,
            style = Stroke(width = 1F)
        )

    }
}