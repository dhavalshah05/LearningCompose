package com.example.learningcompose.meekregister

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.Regular
import com.example.learningcompose.appFontFamily
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun MeekRegisterScreen() {

    val horizontalPadding = 30.dp
    val hintColor = Color(0xFFA7A6B7)

    var fullName by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    ProvideWindowInsets() {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsWithImePadding()
                .fillMaxSize()
                .background(Color.White),
        ) {
            // Toolbar
            TopAppBar(
                title = { },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_black),
                            contentDescription = "Back Arrow"
                        )
                    }
                }
            )

            Text(
                text = "Create Account",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 30.dp),
                fontSize = 18.sp,
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Text(
                text = "Enter your personal details for create account",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 6.dp),
                fontSize = 14.sp,
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Light,
                color = hintColor,
            )

            OutlinedTextField(
                value = fullName,
                onValueChange = {
                    fullName = it
                },
                label = {
                    TextFieldHint(text = "Full Name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 20.dp),
                textStyle = TextStyle.AppTextField
            )

            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = {
                    TextFieldHint(text = "Username")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 10.dp),
                textStyle = TextStyle.AppTextField
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    TextFieldHint(text = "Email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 10.dp),
                textStyle = TextStyle.AppTextField
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    TextFieldHint(text = "Password")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 10.dp),
                textStyle = TextStyle.AppTextField
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                },
                label = {
                    TextFieldHint(text = "Confirm Password")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 80.dp)
                    .navigationBarsWithImePadding(),
                textStyle = TextStyle.AppTextField
            )

            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF655FFF)
                ),
                modifier = Modifier
                    .navigationBarsWithImePadding()
                    .width(width = 160.dp)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)

            ) {
                Text(
                    text = "Create".uppercase(),
                    fontFamily = appFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.White
                )
            }
        }
    }

}

@Composable
fun TextFieldHint(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Regular,
        color = Color(0xFFA7A6B7),
        modifier = modifier
    )
}

val TextStyle.Companion.AppTextField: TextStyle
    get() {
        return Default.copy(
            color = Color.Black,
            fontSize = 12.sp,
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Regular
        )
    }

@Preview
@Composable
fun MeekRegisterScreenPreview() {
    MeekRegisterScreen()
}