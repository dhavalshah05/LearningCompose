package com.example.learningcompose.clock

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Clock(
    modifier: Modifier = Modifier,
    style: ClockStyle = ClockStyle(),
    hour: Int = 3,
    minute: Int = 14
) {
    Canvas(
        modifier = modifier
    ) {
        val radius = style.radius.toPx()
        val circleCenter = center

        // Draw Circle
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                radius,
                Paint().apply {
                    color = Color.WHITE
                    setShadowLayer(60f, 0f, 0f, android.graphics.Color.argb(50, 0, 0, 0))
                }
            )
        }

        // Draw Lines
        for (angle in 0..359 step 6) {
            val angleInRed = Math.toRadians(angle.toDouble() - 90.0)

            val lineType: ClockLineType = when {
                angle % 30 == 0 -> Hour
                else -> Minute
            }
            val lineColor = when (lineType) {
                Minute -> style.minuteLineColor
                Hour -> style.hourLineColor
            }
            val lineLength = when (lineType) {
                Minute -> style.minuteLineLength
                Hour -> style.hourLineLength
            }

            val lineStartX = radius * cos(angleInRed) + circleCenter.x
            val lineStartY = radius * sin(angleInRed) + circleCenter.y
            val lineStart = Offset(lineStartX.toFloat(), lineStartY.toFloat())

            val lineEndX = (radius - lineLength.toPx()) * cos(angleInRed) + circleCenter.x
            val lineEndY = (radius - lineLength.toPx()) * sin(angleInRed) + circleCenter.y
            val lineEnd = Offset(lineEndX.toFloat(), lineEndY.toFloat())

            drawLine(
                color = lineColor,
                start = lineStart,
                end = lineEnd
            )
        }

        // Draw Minute Tick
        val minuteTickAngleInRed = Math.toRadians((minute * 6).toDouble() - 90.0)
        val minusTickX =
            (radius - style.hourLineLength.toPx() - 15) * cos(minuteTickAngleInRed) + circleCenter.x
        val minusTickY =
            (radius - style.hourLineLength.toPx() - 15) * sin(minuteTickAngleInRed) + circleCenter.y
        drawLine(
            color = style.minuteTickerColor,
            start = circleCenter,
            end = Offset(minusTickX.toFloat(), minusTickY.toFloat())
        )

        // Draw Hour Tick
        val hourTickAngleInRed = Math.toRadians((hour * 30).toDouble() - 90.0)
        val x1 =
            (radius - style.hourLineLength.toPx() - 60) * cos(hourTickAngleInRed) + circleCenter.x
        val y1 =
            (radius - style.hourLineLength.toPx() - 60) * sin(hourTickAngleInRed) + circleCenter.y
        drawLine(
            color = style.hourTickerColor,
            start = circleCenter,
            end = Offset(x1.toFloat(), y1.toFloat())
        )
    }
}