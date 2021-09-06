package com.example.learningcompose.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private data class Category(val title: String)

private val categories = listOf(
    Category("First"),
    Category("Second"),
    Category("Third"),
    Category("Fourth"),
    Category("Fifth"),
    Category("Sixth"),
    Category("Seventh"),
)

@Composable
fun CategoryChips() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        LazyRow(
            contentPadding = PaddingValues(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(categories.size) {
                val category = categories[it]
                val color = if (selectedIndex == it) Color.Gray else Color.LightGray

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(size = 5.dp))
                        .background(color)
                        .clickable {
                            selectedIndex = it
                        }
                ) {
                    Text(
                        text = category.title,
                        color = Color.Black,
                        modifier = Modifier.padding(15.dp)
                    )
                }
            }
        }
    }
}