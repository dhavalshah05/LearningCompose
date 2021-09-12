package com.example.learningcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.learningcompose.meekregister.AppTextField
import com.example.learningcompose.meekregister.MeekRegisterScreen
import com.example.learningcompose.meekregister.TextFieldHint
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver

class MainActivity : ComponentActivity() {

    val horizontalPadding = 30.dp
    val hintColor = Color(0xFFA7A6B7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.main_activity)

        findViewById<ComposeView>(R.id.view1).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }

        findViewById<ComposeView>(R.id.view2).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }

        findViewById<ComposeView>(R.id.view3).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }

        findViewById<ComposeView>(R.id.view4).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }

        findViewById<ComposeView>(R.id.view5).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }
        findViewById<ComposeView>(R.id.view6).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }
        findViewById<ComposeView>(R.id.view7).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }
        findViewById<ComposeView>(R.id.view8).setContent {
            var fullName by remember {
                mutableStateOf("")
            }

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
        }

    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}