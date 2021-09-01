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
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun BallGame() {
    val radius = 100F
    val ballPosition = Offset(300F, 300F)

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .pointerInput(true) {
                detectTapGestures { tapOffset ->
                    val aSquare = (tapOffset.x - ballPosition.x).pow(2)
                    val bSquare = (tapOffset.y - ballPosition.y).pow(2)
                    val cSquare = aSquare + bSquare
                    val distance = sqrt(cSquare)
                    val message = if (distance > radius) "Outside" else "Inside"
                    //toast(message)
                }
            }
    ) {
        drawCircle(
            radius = radius,
            center = ballPosition,
            color = Color.Red
        )
    }
}