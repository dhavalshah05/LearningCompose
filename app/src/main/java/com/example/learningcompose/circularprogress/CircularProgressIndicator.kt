package com.example.learningcompose.circularprogress

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    style: CircularProgressIndicatorStyle = CircularProgressIndicatorStyle(),
    progress: Float = 100F
) {

    var incrementedProgress by remember {
        mutableStateOf(progress)
    }

    Canvas(
        modifier = modifier.fillMaxSize()
            .pointerInput(true) {
                detectTapGestures {
                    if (incrementedProgress < 100) {
                        incrementedProgress = incrementedProgress.plus(1)
                    }
                }
            }
    ) {
        val radius = style.radius.toPx()

        // Top Left
        val topLeftX = center.x - radius
        val topLeftY = center.y - radius
        val topLeft = Offset(topLeftX, topLeftY)

        // Size
        val size = Size(radius.times(2), radius.times(2))

        // Angle
        val calculatedProgress = incrementedProgress.coerceIn(0F, 100F)
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
                incrementedProgress.toInt().toString(),
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