package com.example.learningcompose.meek

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.widget.NestedScrollView
import com.example.learningcompose.R
import com.example.learningcompose.Regular
import com.example.learningcompose.appFontFamily

@Composable
fun PasscodeScreen() {
    val passcode = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pc_image_background),
            contentDescription = "BG",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.pc_top_image),
                contentDescription = "Top Image",
                modifier = Modifier
                    .padding(top = 50.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Set Pin/Password".uppercase(),
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Please setup Pin/Passcode for authorizing " +
                        "transactions for Meek.",
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 50.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(80.dp))

            PasscodeField(value = passcode.value, onValueChange = {
                passcode.value = it
            })

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                ),
                modifier = Modifier.size(width = 160.dp, height = 50.dp)
            ) {
                Text(
                    text = "NEXT",
                    color = Color(0XFF655FFF),
                    fontFamily = appFontFamily,
                    fontWeight = FontWeight.Regular,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Composable
private fun PasscodeField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp)),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),
        textStyle = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Regular,
            fontSize = 14.sp
        ),
        singleLine = true,
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.pc_leading),
                contentDescription = "Icon",
                Modifier.padding(start = 10.dp)
            )
        },
        placeholder = {
            Text(
                text = "Set Pin/Passcode",
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Regular,
                fontSize = 14.sp,
                color = Color(0XFFA7A6B7),
            )
        }
    )
}