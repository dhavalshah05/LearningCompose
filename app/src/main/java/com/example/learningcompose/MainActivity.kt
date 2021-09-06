package com.example.learningcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.category.CategoryChips
import com.example.learningcompose.circularprogress.CircularProgressIndicator
import com.example.learningcompose.circularprogress.CircularProgressIndicatorStyle
import com.example.learningcompose.clock.Clock
import com.example.learningcompose.listdemo.ListDemo
import com.example.learningcompose.profile.ProfileScreen
import com.example.learningcompose.recipe.RecipeDemo
import com.example.learningcompose.textfield.TextFieldDemo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}