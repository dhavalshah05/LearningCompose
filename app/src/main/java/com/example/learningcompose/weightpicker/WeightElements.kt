package com.example.learningcompose.weightpicker

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withRotation
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Scale(
    modifier: Modifier = Modifier,
    style: ScaleStyle = ScaleStyle(),
    minWeight: Int = 20,
    maxWeight: Int = 250,
    initialWeight: Int = 80,
    onWeightChange: (Int) -> Unit
) {
    val radius = style.radius
    val scaleWidth = style.scaleWidth

    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var angle by remember {
        mutableStateOf(0f)
    }

    Canvas(modifier = modifier) {
        center = this.center
        circleCenter = Offset(center.x, scaleWidth.toPx() / 2f + radius.toPx())

        val outerRadius = radius.toPx() + scaleWidth.toPx() / 2f
        val innerRadius = radius.toPx() - scaleWidth.toPx() / 2f

        // Draw Circle
        drawScaleCircle(circleCenter, radius.toPx(), scaleWidth.toPx())

        // Draw Lines
        drawScaleLinesAndDigits(
            minWeight,
            maxWeight,
            initialWeight,
            angle,
            style,
            outerRadius,
            circleCenter
        )
    }
}

private fun DrawScope.drawScaleLinesAndDigits(
    minWeight: Int,
    maxWeight: Int,
    initialWeight: Int,
    angle: Float,
    style: ScaleStyle,
    outerRadius: Float,
    circleCenter: Offset
) {
    for (i in minWeight..maxWeight) {
        // Calculate angle each line should have
        val angleInRed = Math.toRadians(i.toDouble() - initialWeight + angle - 90.0)

        val lineType = when {
            i % 10 == 0 -> LineType.TenStep
            i % 5 == 0 -> LineType.FiveStep
            else -> LineType.Normal
        }
        val lineLength = when (lineType) {
            LineType.Normal -> style.normalLineLength.toPx()
            LineType.FiveStep -> style.fiveStepLineLength.toPx()
            LineType.TenStep -> style.tenStepLineLength.toPx()
        }
        val lineColor = when (lineType) {
            LineType.Normal -> style.normalLineColor
            LineType.FiveStep -> style.fiveStepLineColor
            LineType.TenStep -> style.tenStepLineColor
        }

        val lineStartOffset = Offset(
            x = ((outerRadius - lineLength) * cos(angleInRed) + circleCenter.x).toFloat(),
            y = ((outerRadius - lineLength) * sin(angleInRed) + circleCenter.y).toFloat()
        )
        val lineEndOffset = Offset(
            x = (outerRadius * cos(angleInRed) + circleCenter.x).toFloat(),
            y = (outerRadius * sin(angleInRed) + circleCenter.y).toFloat()
        )

        drawLine(
            start = lineStartOffset,
            end = lineEndOffset,
            color = lineColor
        )

        drawContext.canvas.nativeCanvas.apply {
            if (lineType is LineType.TenStep) {
                val x = (outerRadius - lineLength - 5.dp.toPx() - style.textSize.toPx()) *
                        cos(angleInRed) + circleCenter.x
                val y = (outerRadius - lineLength - 5.dp.toPx() - style.textSize.toPx()) *
                        sin(angleInRed) + circleCenter.y

                withRotation(
                    degrees = Math.toDegrees(angleInRed).toFloat() + 90,
                    pivotX = x.toFloat(),
                    pivotY = y.toFloat()
                ) {
                    drawText(
                        "$i",
                        x.toFloat(),
                        y.toFloat(),
                        Paint().apply {
                            color = Color.BLACK
                            textSize = style.textSize.toPx()
                            textAlign = Paint.Align.CENTER
                        }
                    )
                }

            }
        }
    }
}

private fun DrawScope.drawScaleCircle(
    circleCenter: Offset,
    radius: Float,
    scaleWidth: Float
) {
    drawContext.canvas.nativeCanvas.apply {
        drawCircle(
            circleCenter.x,
            circleCenter.y,
            radius,
            Paint().apply {
                strokeWidth = scaleWidth
                color = Color.WHITE
                style = Paint.Style.STROKE
                setShadowLayer(
                    60f,
                    0f,
                    0f,
                    Color.argb(50, 0, 0, 0)
                )
            }
        )
    }
}