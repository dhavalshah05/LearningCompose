package com.example.learningcompose

import android.icu.number.Scale
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.weightpicker.Scale
import com.example.learningcompose.weightpicker.ScaleStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Scale(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    style = ScaleStyle(
                        scaleWidth = 150.dp,
                        radius = 100.dp,
                        textSize = 10.sp
                    )
                ) {

                }
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}