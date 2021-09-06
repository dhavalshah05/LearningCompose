package com.example.learningcompose.recipe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R

private data class Recipe(
    val name: String
)

@Composable
fun RecipeDemo() {
    val recipes = listOf(
        Recipe("Demo Recipe 1"),
        Recipe("Demo Recipe 2"),
        Recipe("Demo Recipe 3"),
        Recipe("Demo Recipe 4"),
        Recipe("Demo Recipe 5"),
        Recipe("Demo Recipe 6"),
        Recipe("Demo Recipe 7"),
        Recipe("Demo Recipe 8"),
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentPadding = PaddingValues(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(recipes) { item: Recipe ->
            RecipeCard(recipe = item)
        }
    }
}

@Composable
private fun RecipeCard(recipe: Recipe) {
    val roundCornerShape = RoundedCornerShape(10.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(2.dp, Color.White), shape = roundCornerShape)
            .padding(15.dp)
            .background(Color.White, roundCornerShape)
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 50.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.z_dummy_recipe),
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
                    .shadow(4.dp, roundCornerShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = recipe.name,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}