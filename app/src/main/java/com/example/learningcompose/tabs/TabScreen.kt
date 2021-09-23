package com.example.learningcompose.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.appFontFamily

@Composable
fun DemoScreen(
    title: String
) {
    Text(
        text = title,
        modifier = Modifier.fillMaxSize(),
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = appFontFamily,
        textAlign = TextAlign.Center
    )
}

sealed class Tabs(val title: String) {
    object First : Tabs("First")
    object Second : Tabs("Second")
    object Third : Tabs("Third")
}

@Composable
fun TabsScreen() {
    val selectedTabIndex = remember {
        mutableStateOf(0)
    }

    val tabs = listOf(
        Tabs.First,
        Tabs.Second,
        Tabs.Third
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            backgroundColor = Color.White,
            contentColor = Color.Black,
            tabs = {
              for (tab in tabs) {
                  Text(
                      text = tab.title,
                      modifier = Modifier
                          .clickable {
                              val index = tabs.indexOf(tab)
                              selectedTabIndex.value = index
                          }
                          .padding(vertical = 10.dp),
                      textAlign = TextAlign.Center
                  )
              }
            },
            indicator = {
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(it[selectedTabIndex.value])
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(20.dp))
                    ,
                    color = Color.Red
                )
            },
            divider = {

            }
        )
    }
}