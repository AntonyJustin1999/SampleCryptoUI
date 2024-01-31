package com.supertalk.app.ui

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.Shapes
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlgoDetailScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.black))
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Box(modifier = Modifier
                .size(53.dp, 53.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .background(colorResource(id = R.color.background))
                .clickable {
                    navController.popBackStack()
                }
            ){
                Icon(painter = painterResource(id = R.drawable.ic_back),
                    modifier = Modifier
                        .size(21.dp, 22.dp)
                        .align(Alignment.Center),
                    tint = Color.White,
                    contentDescription = "Wallet" )
            }
            Text(
                text = "Algo Detail",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.gilroy_medium
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            HeaderIcon()
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    colorResource(id = R.color.background),
                    RoundedCornerShape(10.dp)
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Streak Ninja",
                    style = TextStyle(
                        color = colorResource(R.color.white),
                        fontSize = 24.sp,
                        fontFamily = CustomFonts.gilroy_semibold
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(15.dp))

                Column(modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                ){
                    Row {
                        Column(modifier = Modifier
                            .weight(1f)) {
                            Text("Percentage win"
                                ,color = colorResource(id = R.color.text_color)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("50%"
                                ,color = colorResource(id = R.color.white)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Column(modifier = Modifier
                            .weight(1f)) {
                            Text("Total Profit"
                                ,color = colorResource(id = R.color.text_color)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("1400"
                                ,color = colorResource(id = R.color.white)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                        Column(modifier = Modifier
                            .weight(1f)) {
                            Text("Algo age"
                                ,color = colorResource(id = R.color.text_color)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("3 years"
                                ,color = colorResource(id = R.color.white)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Column(modifier = Modifier
                            .weight(1f)) {
                            Text("Completed trades"
                                ,color = colorResource(id = R.color.text_color)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("1400"
                                ,color = colorResource(id = R.color.white)
                                ,fontSize = 14.sp,
                                fontFamily = CustomFonts.gilroy_medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                }

            }
        }

        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()) {
                Text("Description"
                    ,color = colorResource(id = R.color.white)
                    ,fontSize = 24.sp,
                    fontFamily = CustomFonts.gilroy_medium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                )
                Icon(painter = painterResource(id = R.drawable.keyboard_arrow_up_24),
                    modifier = Modifier
                        .size(24.dp),
                    tint = Color.White,
                    contentDescription = "Wallet" )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text("AI trading apps are designed to be user-friendly and \n" +
                    "can be used by both beginners and experienced \n" +
                    "traders. Some apps offer automated trading where the\n " +
                    "AI makes decisions on your behalf, while others provide\n" +
                    "trading signals that users can follow."
                ,color = colorResource(id = R.color.text_color)
                ,fontSize = 14.sp,
                fontFamily = CustomFonts.gilroy_medium,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                style = LocalTextStyle.current.copy(lineHeight = 22.sp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                },
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 15.dp,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.border_color_yellow)
                ),
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    text = "Trade this Algo",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = CustomFonts.gilroy_semibold,
                        color = colorResource(id = R.color.black)
                    )
                )
            }
        }
    }
}

@Composable
fun HeaderIcon() {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .offset(x = 0.dp, y = 30.dp)
            .zIndex(2f)
            .clip(RoundedCornerShape(50.dp))
            .border(
                2.dp,
                colorResource(id = R.color.white),
                shape = RoundedCornerShape(50.dp)
            )
            .background(
                color = colorResource(id = R.color.rounded_fill_color),
                RoundedCornerShape(50.dp)
            ))
    {
        Image(
            painter = painterResource(id = R.drawable.cash_logo),
            contentDescription = "img",
            modifier = Modifier
                .height(68.dp)
                .width(68.dp)
                .align(Alignment.Center),
            alignment = Alignment.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlgoDetailPreview() {
    SuperTalkApplicationTheme {
        AlgoDetailScreen(navController = (rememberNavController()))
    }
}