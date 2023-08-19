package com.supertalk.app.ui.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts


@Preview(showBackground = true)
@Composable
fun PlayerStatusScreenPreview() {
    SuperTalkApplicationTheme {
        PlayerStatusScreen(rememberNavController())
    }
}

@Composable
fun PlayerStatusScreen(navController: NavController) {

    Scaffold(
        backgroundColor = colorResource(R.color.green_background),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth().wrapContentHeight()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomPlayerStatusScreenDialog(
                    value = "",
                    setShowDialog = {},
                    setValue = {},
                    navController
                )
            }
        }
    )
}

@Composable
fun CustomPlayerStatusScreenDialog(
    value: String,
    setShowDialog: (Boolean) -> Unit,
    setValue: (String) -> Unit,
    navController: NavController
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                        .clickable { setShowDialog(false) }
                )
            }
            Box(
                modifier = Modifier
                    .wrapContentHeight(), contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .background(colorResource(id = R.color.background))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth().wrapContentHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MyProfileImage()
                        Column(
                            modifier = Modifier
                                .padding(top = 30.dp)
                                .width(600.dp)
                                .offset(y = (-125).dp / 2)
                                .background(Color(0xFFf3f0ff)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Spacer(modifier = Modifier.width(16.dp))
                                CardViewWithHeightAndWeight("5’3”", "Height")
                                Spacer(modifier = Modifier.width(16.dp))
                                CardViewWithHeightAndWeight("52 kgs", "Weight")
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            CardViewWithDOBAndNationality(
                                "37",
                                "DOB",
                                "54",
                                "Nationality",
                                "10",
                                "Birth Country"
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            CardViewWithDOBAndNationality(
                                "37",
                                "Matches",
                                "54",
                                "Goals",
                                "10",
                                "Assists"
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Spacer(modifier = Modifier.width(16.dp))
                                CardViewWithCards("05", "Cards", Color(0xffEC5C4D))
                                Spacer(modifier = Modifier.width(16.dp))
                                CardViewWithCards("10", "Cards", Color(0xffEEA142))
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CardViewWithHeightAndWeight(title: String, text: String) {
    Card(
        modifier = Modifier
            .wrapContentSize().requiredHeightIn(max=80.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                .wrapContentSize()
                .requiredWidthIn(max = 105.dp).requiredHeightIn(max=67.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontFamily = CustomFonts.manrope_bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF7C8396),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CardViewWithDOBAndNationality(
    title1: String,
    text1: String,
    title2: String,
    text2: String,
    title3: String,
    text3: String
) {
    Row(
        modifier = Modifier
            .widthIn(max = 290.dp).requiredHeightIn(max=80.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(16.dp)),
            elevation = 4.dp,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize()
                        .requiredWidthIn(max = 75.dp),
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Text(
                        text = title1,
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text1,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF7C8396),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize()
                        .requiredWidthIn(max = 75.dp),
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Text(
                        text = title2,
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text2,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF7C8396),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize()
                        .requiredWidthIn(max = 75.dp),
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Text(
                        text = title3,
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text3,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF7C8396),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun CardViewWithCards(title: String, text: String , color: Color) {
        Card(
            modifier = Modifier
                .wrapContentSize().requiredHeightIn(max=80.dp)
                .clip(RoundedCornerShape(16.dp)),
            elevation = 4.dp,
        ) {
            Row(
                modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(5.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = color
                            )
                            .height(27.dp)
                            .width(20.dp)
                    )

                }
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                        .wrapContentSize()
                        .requiredWidthIn(max = 75.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = title,
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF7C8396),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
}


@Composable
fun PlayerStatusScreenButton() {

    Button(
        onClick = {

        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        modifier = Modifier
            .wrapContentSize()
            .height(34.dp)
            .offset(x = 58.dp, y = (-108).dp / 2)
            .coloredShadow(
                color = MaterialTheme.colors.primary,
                offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp
            )
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(topStart = 14.dp, bottomStart = 14.dp)
            ), shape = RoundedCornerShape(topStart = 14.dp, bottomStart = 14.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = "Striker",
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = CustomFonts.manrope_bold
            ),
        )
    }

}

@Composable
private fun getSubTitle(title: String) {
    Text(
        text = title,
        fontSize = 15.sp,
        fontFamily = CustomFonts.manrope_bold,
    )

}

@Composable
private fun MyProfileImage() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentSize()
            .background(colorResource(id = R.color.white))
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Top),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 16.sp, color = Color(0xFF7C8396))) {
                    append("Lionel ")
                }
                withStyle(style = SpanStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold)) {
                    append("\nMessi")
                }
            })
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // in the below line, we are adding Image to display the image.
                Image(
                    // in the below line, we are specifying the drawable image for our image.
                    painter = painterResource(id = R.drawable.test_barcelona),
                    contentDescription = "img",
                    modifier = Modifier
                        .height(34.dp)
                        .width(34.dp),
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Barcelona",

                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    modifier = Modifier,

                    // in the below line, we are adding color for our text
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_test_messi1),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(143.dp, 143.dp)

            )
            PlayerStatusScreenButton()
        }
        Spacer(modifier = Modifier.width(16.dp))


    }
}

