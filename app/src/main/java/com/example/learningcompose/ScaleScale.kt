package com.example.learningcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

@Composable
fun ScaleScale() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val startingPoint = Offset(0F, 100F)
        val height = 200F
        val width = size.width

        drawRect(
            topLeft = startingPoint,
            size = Size(width, height),
            color = Color.LightGray
        )

        for (i in (startingPoint.x.toInt() + 10)..width.toInt() step 40) {
            val lineStartPoint = Offset(i.toFloat(), startingPoint.y)
            val lineEndPoint = Offset(i.toFloat(), startingPoint.y + 50)
            val color = if (i % 10 == 0) Color.Blue else Color.Red
            drawLine(
                start = lineStartPoint,
                end = lineEndPoint,
                color = color,
                strokeWidth = 3F
            )
        }
    }
}