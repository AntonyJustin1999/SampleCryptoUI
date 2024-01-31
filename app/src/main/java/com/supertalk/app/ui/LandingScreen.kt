package com.supertalk.app.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.supertalk.app.R
import com.supertalk.app.ui.customUI.CustomGraphWithoutBackground
import com.supertalk.app.ui.customUI.SmallCustomGraph
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlin.random.Random

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LandingScreen(navController: NavController) {
    Column {
        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround){
            Box(modifier = Modifier
                .size(53.dp, 53.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .background(colorResource(id = R.color.background))
            ){
                Icon(painter = painterResource(id = R.drawable.ic_wallet),
                    modifier = Modifier
                        .size(27.dp)
                        .align(Alignment.Center),
                    tint = Color.White,
                    contentDescription = "Wallet" )
            }
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Sample Image",
                modifier = Modifier
                    .size(153.dp, 41.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
            Box(modifier = Modifier
                .size(53.dp, 53.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .background(colorResource(id = R.color.background))){
                Icon(painter =painterResource(id = R.drawable.ic_bell),
                    modifier = Modifier
                        .size(27.dp)
                        .align(Alignment.Center),
                    tint = Color.White,
                    contentDescription = "Wallet" )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Current Balance",
                style = TextStyle(
                    color = colorResource(R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.gilroy_medium
                ))
            Text(
                text = "$275,458",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 55.sp,
                    fontFamily = CustomFonts.gilroy_medium
                ))
            Row {
                Icon(painter = painterResource(id = R.drawable.up_arrow),
                    modifier = Modifier
                        .size(12.dp),
                    tint = Color.White,
                    contentDescription = "UpArrow")
                Text(
                    text = "15% last 30 days",
                    style = TextStyle(
                        color = colorResource(R.color.white),
                        fontSize = 16.sp,
                        fontFamily = CustomFonts.gilroy_medium
                    ))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .clip(shape = RoundedCornerShape(65.dp))
            .fillMaxWidth()
            .height(70.dp)
            .background(colorResource(id = R.color.background)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
            ) {
            Row {
                Box(modifier = Modifier
                    .size(44.dp, 44.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(colorResource(id = R.color.rounded_background))
                ){
                    Icon(painter = painterResource(id = R.drawable.ic_arrow_down),
                        modifier = Modifier
                            .size(15.dp)
                            .align(Alignment.Center),
                        tint = Color.White,
                        contentDescription = "Wallet" )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Spent",
                        style = TextStyle(
                            color = colorResource(R.color.text_color),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.gilroy_regular
                        ))
                    Text(
                        text = "$17,547.99",
                        style = TextStyle(
                            color = colorResource(R.color.white),
                            fontSize = 16.sp,
                            fontFamily = CustomFonts.gilroy_medium
                        ))
                }
            }
            Row {
                Box(modifier = Modifier
                    .size(44.dp, 44.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(colorResource(id = R.color.rounded_background))
                ){
                    Icon(painter = painterResource(id = R.drawable.up_arrow),
                        modifier = Modifier
                            .size(15.dp)
                            .align(Alignment.Center),
                        tint = Color.White,
                        contentDescription = "Wallet" )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Profit/Loss",
                        style = TextStyle(
                            color = colorResource(R.color.text_color),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.gilroy_regular
                        ))
                    Text(
                        text = "+$15,310.39",
                        style = TextStyle(
                            color = colorResource(R.color.white),
                            fontSize = 16.sp,
                            fontFamily = CustomFonts.gilroy_medium
                        ))
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

//        Column(modifier = Modifier
//            .fillMaxWidth()
//            .height(461.dp)
//            .background(colorResource(id = R.color.rounded_background))) {
//
//        }

        CustomGraphNoBg()


    }
}

@Composable
fun CustomGraphNoBg() {
    val yStep = 50
    val random = Random
    /* to test with random points */
    val points = (0..9).map {
        var num = random.nextInt(350)
        if (num <= 50)
            num += 100
        num.toFloat()
    }
    Box(
        modifier = Modifier.padding(start = 15.dp)
    ) {
        CustomGraphWithoutBackground(
            modifier = Modifier
                .fillMaxWidth()
                .height(365.dp),
            xValues = (0..9).map { it + 1 },
            yValues = (0..6).map { (it + 1) * yStep },
            points = points,
            paddingSpace = 0.dp,
            verticalStep = yStep
        )
    }
}
//https://github.com/aqua30/GraphCompose/blob/master/app/src/main/java/com/aqua30/graphcompose/screen/Graph.kt
//https://proandroiddev.com/creating-graph-in-jetpack-compose-312957b11b2