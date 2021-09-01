package com.example.learningcompose.weightpicker

sealed class LineType {
    object Normal: LineType()
    object FiveStep: LineType()
    object TenStep: LineType()
}
