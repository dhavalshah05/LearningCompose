package com.example.learningcompose.listdemo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListDemo() {

    var items by remember {
        mutableStateOf(getListItems())
    }

    var itemIndexText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = itemIndexText,
            onValueChange = {
                itemIndexText = it
            },
            label = {
                Text(text = "Enter index here")
            },
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(onClick = {
                if (itemIndexText.isNotBlank()) {
                    val newItem = ListItem("New Item with index: $itemIndexText")
                    items = items.addItemAtStart(newItem)
                }
            }) {
                Text(text = "Add")
            }
            OutlinedButton(onClick = {
                if (itemIndexText.isNotBlank()) {
                    val newItems = items.deleteItem(itemIndexText.toInt())
                    items = newItems
                }
            }) {
                Text(text = "Delete")
            }
            OutlinedButton(onClick = {
                val item = items[0]
                val newItem = item.copy(title = item.title + "Updated")
                items = items.updateItem(newItem) { it.title == item.title }
            }) {
                Text(text = "Update")
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(items) { _, item ->
                ListITem(item = item)
            }
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