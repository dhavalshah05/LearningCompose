package com.example.learningcompose.listdemo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListDemo() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        this.
        itemsIndexed(getListItems()) { _, item ->
            ListITem(item = item)
        }
    }
}

@Composable
private fun ListITem(item: ListItem) {
    Text(
        text = item.title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    )
}

private data class ListItem(val title: String)

private fun getListItems(): List<ListItem> {
    val items = mutableListOf<ListItem>()
    for (i in 1..1000) {
        items.add(ListItem("List Item $i"))
    }
    return items
}