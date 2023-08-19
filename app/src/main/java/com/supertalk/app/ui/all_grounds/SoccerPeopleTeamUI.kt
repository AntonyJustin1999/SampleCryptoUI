package com.supertalk.app.ui.all_grounds

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkGroundApplicationTheme
import com.supertalk.app.util.CustomFonts

@Composable
fun SoccerPeopleTeamUI(navController: NavController) {

    Box(modifier = Modifier
        .padding(start = 11.dp, end = 11.dp)
        .fillMaxWidth()
        .fillMaxHeight())
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .paint(
                painterResource(id = R.drawable.soccer_ad_pitch_2x),
                contentScale = ContentScale.FillBounds
            )
        )
        {

            Icon(
                painter = painterResource(id = R.drawable.ic_hand_with_bg),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset {
                        IntOffset(x = -50, y = -100)
                    }
                    .size(32.dp, 32.dp)
                    .clickable { }
                ,
                tint = Color.Unspecified
            )

            //One
            Box(modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset { IntOffset(x = -100, y = 300) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi")
            }

            //Two
            Box(modifier = Modifier
                .align(Alignment.Center)
                .offset { IntOffset(x = 10, y = 120) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "2")
            }

            //Three
            Box(modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset { IntOffset(x = -150, y = 120) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "3")
            }

            //Four
            Box(modifier = Modifier
                .align(Alignment.CenterStart)
                .offset { IntOffset(x = 120, y = 300) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "4")
            }

            //Five
            Box(modifier = Modifier
                .align(Alignment.Center)
                .offset { IntOffset(x = -120, y = 300) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "5")
            }

            //Six
            Box(modifier = Modifier
                .align(Alignment.Center)
                .offset { IntOffset(x = 130, y = 300) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "6")
            }

            //Seven
            Box(modifier = Modifier
                .align(Alignment.CenterStart)
                .offset { IntOffset(x = 160, y = 120) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "1")
            }

            //Eight
            Box(modifier = Modifier
                .align(Alignment.BottomStart)
                .offset { IntOffset(x = 120, y = -170) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "8")
            }

            //Nine
            Box(modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset { IntOffset(x = -120, y = -170) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "9", secondCardValue = "2")
            }

            //Ten
            Box(modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset { IntOffset(x = -100, y = -170) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi")
            }

            //Eleven
            Box(modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset { IntOffset(x = 130, y = -60) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Red,label = "Messi", firstCardValue = "11")
            }








            //One
            Box(modifier = Modifier
                .align(Alignment.Center)
                .offset { IntOffset(x = 10, y = -85) }){
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "1")
            }

            //Two
            Box(modifier = Modifier
                .align(Alignment.TopCenter)
                .offset { IntOffset(x = 130, y = 120) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi")
            }

            //Three
            Box(modifier = Modifier
                .align(Alignment.TopCenter)
                .offset { IntOffset(x = -130, y = 220) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "3")
            }

            //Four
            Box(modifier = Modifier
                .align(Alignment.TopStart)
                .offset { IntOffset(x = 120, y = 220) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "4")
            }

            //Five
            Box(modifier = Modifier
                .align(Alignment.TopEnd)
                .offset { IntOffset(x = -100, y = 220) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi")
            }

            //Six
            Box(modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset { IntOffset(x = -150, y = -85) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "6")
            }

            //Seven
            Box(modifier = Modifier
                .align(Alignment.CenterStart)
                .offset { IntOffset(x = 160, y = -85) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "7", secondCardValue = "6")
            }

            //Eight
            Box(modifier = Modifier
                .align(Alignment.CenterStart)
                .offset { IntOffset(x = 120, y = -250) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "8")
            }

            //Nine
            Box(modifier = Modifier
                .align(Alignment.Center)
                .offset { IntOffset(x = -130, y = -250) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "9")
            }

            //Ten
            Box(modifier = Modifier
                .align(Alignment.Center)
                .offset { IntOffset(x = 130, y = -250) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi", firstCardValue = "10")
            }

            //Eleven
            Box(modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset { IntOffset(x = -100, y = -250) }
            ) {
                MultiColorCardWithProfileUI(borderColor = Color.Blue,label = "Messi")
            }



        }
    }

}


@Composable
fun MultiColorCardWithProfileUI(borderColor:Color,firstCardValue:String? = null,
                     secondCardValue:String? = null,label:String){
    Column {
        Box(
            modifier = Modifier
                .size(34.dp, 34.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.messi_profile),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(34.dp, 34.dp)
                    .clip(RoundedCornerShape(68.dp))
                    .border(width = 2.dp, borderColor, shape = RoundedCornerShape(68.dp)),
            )

            var offset = IntOffset(x = 60, y = -25)
            if(firstCardValue == null || secondCardValue == null){
                offset = IntOffset(x = 25, y = -25)
            }

            Box(modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.TopEnd)
                .offset {
                    offset
                }
            ) {
                if(firstCardValue!=null){
                    Box(
                        modifier = Modifier
                            .width(17.dp)
                            .height(23.dp)
                            .background(
                                colorResource(id = R.color.border_color_yellow),
                                RoundedCornerShape(4.dp)
                            )
                    ) {
                        Text(
                            text = firstCardValue,
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 14.sp,
                                fontFamily = CustomFonts.manrope_semi_bold
                            ),
                            textAlign = TextAlign.Center,
                        )
                    }
                }

                var startPadding = 0.dp
                if(firstCardValue != null){
                    startPadding = 15.dp
                }

                if(secondCardValue!=null){
                    Box(
                        modifier = Modifier
                            .padding(start = startPadding)
                            .width(17.dp)
                            .height(23.dp)
                            .background(
                                colorResource(id = R.color.otp_text_color),
                                RoundedCornerShape(4.dp)
                            )
                    ) {
                        Text(
                            text = secondCardValue,
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 14.sp,
                                fontFamily = CustomFonts.manrope_semi_bold
                            ),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }

        Text(
            text = label,
            modifier = Modifier,
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = CustomFonts.manrope_semi_bold
            ),
            textAlign = TextAlign.Center,
        )

    }

}

@Preview(showBackground = true)
@Composable
fun SoccerPeopleTeamUI() {
    SuperTalkGroundApplicationTheme {
        SoccerPeopleTeamUI(rememberNavController())
    }
}