package com.example.learningcompose.circularprogress

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas

@Composable
fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    style: CircularProgressIndicatorStyle = CircularProgressIndicatorStyle(),
    progress: Float = 100F
) {
    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        val radius = style.radius.toPx()

        // Top Left
        val topLeftX = center.x - radius
        val topLeftY = center.y - radius
        val topLeft = Offset(topLeftX, topLeftY)

        // Size
        val size = Size(radius.times(2), radius.times(2))

        // Angle
        val calculatedProgress = progress.coerceIn(0F, 100F)
        val angle = (calculatedProgress * 360) / 100

        // Draw Progress Background
        drawArc(
            color = style.progressBackgroundColor,
            startAngle = -90F,
            sweepAngle = 360F,
            useCenter = false,
            topLeft = topLeft,
            size = size,
            style = Stroke(
                width = style.stroke.toPx(),
                cap = StrokeCap.Round
            )
        )

        // Draw Progress
        drawArc(
            color = style.progressColor,
            startAngle = -90f,
            sweepAngle = angle,
            useCenter = false,
            topLeft = topLeft,
            size = size,
            style = Stroke(
                width = style.stroke.toPx(),
                cap = StrokeCap.Round
            )
        )

        // Draw Text
        drawContext.canvas.nativeCanvas.apply {
            drawText(
                progress.toInt().toString(),
                center.x,
                center.y,
                Paint().apply {
                    color = Color.BLACK
                    textSize = style.fontSize.toPx()
                    textAlign = Paint.Align.CENTER
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                }
            )
        }
    }
}