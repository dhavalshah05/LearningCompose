package com.example.learningcompose.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R

private val colorBackground = Color(0xff212D3E)
private val colorCardBackground = Color(0xff3E4857)
private val colorBlue = Color(0xff13D9F3)
private val colorOffWhite = Color(0xB3FFFFFF)
private val colorYellow = Color(0xffFBCC34)
private val colorOrange = Color(0xffF08D61)

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBackground)
    ) {
        ProfileToolbar()
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            ProfileSummary(
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            SettingItems(
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Composable
private fun SettingItems(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = colorCardBackground, shape = RoundedCornerShape(15.dp))
            .padding(vertical = 10.dp)
    ) {
        for (settingItem in settingItems) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = settingItem.title,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.weight(1f)
                )

                if (settingItem.hasArrow) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_right_white),
                        contentDescription = "Arrow Right"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProfileSummary(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .background(
                    color = colorCardBackground,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color(0xff13D9F3),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("256")
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = Color(0xB3FFFFFF),
                                )
                            ) {
                                append("Followers")
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "John Doe",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Total KM: 5000",
                            color = Color.White,
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                    }
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color(0xffF08D61),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("256")
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = Color(0xB3FFFFFF),
                                )
                            ) {
                                append("Followings")
                            }
                        },
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                )
                            ) {
                                append("0")
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    color = colorBlue,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                )
                            ) {
                                append("Place".uppercase())
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = colorOffWhite,
                                )
                            ) {
                                append("Visited")
                            }
                        },
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .background(color = colorBackground, shape = RoundedCornerShape(10.dp))
                            .weight(1f)
                            .padding(15.dp)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                )
                            ) {
                                append("0")
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    color = colorOrange,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                )
                            ) {
                                append("Cities".uppercase())
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = colorOffWhite,
                                )
                            ) {
                                append("Visited")
                            }
                        },
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .background(color = colorBackground, shape = RoundedCornerShape(10.dp))
                            .padding(15.dp)
                            .weight(1f)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                )
                            ) {
                                append("0")
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    color = colorYellow,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                )
                            ) {
                                append("Place".uppercase())
                            }
                            append("\n")
                            withStyle(
                                SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = colorOffWhite,
                                )
                            ) {
                                append("Total")
                            }
                        },
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .background(color = colorBackground, shape = RoundedCornerShape(10.dp))
                            .padding(15.dp)
                            .weight(1f)
                    )
                }
            }
        }
        /* region Profile Image */
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(color = Color.White, shape = CircleShape)
                .align(Alignment.TopCenter)
        )
        /* endregion Profile Image */
    }

}

@Composable
private fun ProfileToolbar() {
    TopAppBar(
        backgroundColor = Color(0xff212D3E),
        elevation = 0.dp
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = {},
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_badge),
                    contentDescription = "Badge",
                )
            }
            Text(
                text = "Profile",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

private data class SettingItem(val title: String, val hasArrow: Boolean)

private val settingItems = listOf(
    SettingItem("Notification", false),
    SettingItem("My Properties", true),
    SettingItem("My Bookings", true),
    SettingItem("Blocked Users", true),
    SettingItem("Change Password", true),
    SettingItem("Rate The App", true),
    SettingItem("Share App", true),
    SettingItem("Help & FAQ", true),
    SettingItem("Terms & Privacy Policy", true),
    SettingItem("About Us", true),
    SettingItem("Contact Us", true),
    SettingItem("Logout", false),
)