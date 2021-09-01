package com.example.learningcompose.weightpicker

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withRotation
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Scale(
    modifier: Modifier = Modifier,
    style: ScaleStyle = ScaleStyle(),
    minWeight: Int = 10,
    maxWeight: Int = 100,
    initialWeight: Int = 85,
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
    var dragStartedAngle by remember {
        mutableStateOf(0f)
    }
    var oldAngle by remember {
        mutableStateOf(angle)
    }

    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectDragGestures(
                    onDragStart = { dragStartOffset ->
                        dragStartedAngle = Math.toDegrees(
                            (-atan2(
                                x = (circleCenter.x - dragStartOffset.x),
                                y = (circleCenter.y - dragStartOffset.y)
                            )).toDouble()
                        ).toFloat()
                    },
                    onDragEnd = {
                        oldAngle = angle
                    }
                ) { change, _ ->
                    val dragAngle = Math.toDegrees(
                        (-atan2(
                            x = (circleCenter.x - change.position.x),
                            y = (circleCenter.y - change.position.y)
                        )).toDouble()
                    ).toFloat()
                    val calculatedAngle = (dragStartedAngle - dragAngle) + oldAngle
                    Log.d("Scale_D", "angle: $calculatedAngle")
                    angle = calculatedAngle.coerceIn(
                        minimumValue = initialWeight - maxWeight.toFloat(),
                        maximumValue = initialWeight - minWeight.toFloat()
                    )
                }
            }
    ) {
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

        val red = Math.toRadians(0.0 - 90.0)
        val indicatorLineStart = Offset(
            x = (innerRadius * cos(red) + circleCenter.x).toFloat(),
            y = (innerRadius * sin(red) + circleCenter.y).toFloat()
        )
        val indicatorEndStart = Offset(
            x = ((radius.toPx() - 15.dp.toPx()) * cos(red) + circleCenter.x).toFloat(),
            y = ((radius.toPx() - 15.dp.toPx()) * sin(red) + circleCenter.y).toFloat()
        )
        drawLine(
            start = indicatorLineStart,
            end = indicatorEndStart,
            color = style.scaleIndicatorColor,
            strokeWidth = 2.dp.toPx()
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