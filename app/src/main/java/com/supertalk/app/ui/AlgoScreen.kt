package com.supertalk.app.ui

import android.graphics.fonts.FontFamily
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.supertalk.app.R
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlgoScreen(navController: NavController) {

    val CustomTextFieldColors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        backgroundColor = colorResource(id = R.color.background)
    )
    val search = remember { mutableStateOf("") }

    lateinit var customList: List<String>
    customList = ArrayList<String>()
    customList = customList + ""
    customList = customList + ""
    customList = customList + ""
    customList = customList + ""
    customList = customList + ""

    Column {
        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){

            Text(
                text = "Algo",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 34.sp,
                    fontFamily = CustomFonts.gilroy_semibold
                ))

            Box(modifier = Modifier
                .size(53.dp, 53.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .background(colorResource(id = R.color.background))){
                Icon(painter =painterResource(id = R.drawable.sort),
                    modifier = Modifier
                        .size(27.dp)
                        .align(Alignment.Center),
                    tint = Color.White,
                    contentDescription = "Wallet" )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .clip(shape = RoundedCornerShape(45.dp))
            .fillMaxWidth()
            .height(55.dp)
            .background(colorResource(id = R.color.background)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Icon(painter =painterResource(id = R.drawable.search),
                modifier = Modifier
                    .size(24.dp),
                tint = Color.White,
                contentDescription = "search" )

            TextField(
                value = search.value,
                onValueChange = { search.value = it },
                label = { Text("Search"
                    ,color = colorResource(id = R.color.text_color)
                    ,fontSize = 16.sp,
                    fontFamily = CustomFonts.gilroy_medium)
                        },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                colors = CustomTextFieldColors,
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.gilroy_medium))
        }
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text("See recommented algos first"
            ,color = colorResource(id = R.color.text_color)
            ,fontSize = 14.sp,
            fontFamily = CustomFonts.gilroy_regular,
            modifier = Modifier.padding(start = 20.dp))

        Spacer(modifier = Modifier.height(20.dp))

//        LazyColumn(modifier = Modifier) {
//            itemsIndexed(customList) { index, item ->
//            }
//        }

        algoRow(navController)
        Spacer(modifier = Modifier.height(20.dp))
        algoRow(navController)
        Spacer(modifier = Modifier.height(20.dp))
        algoRow(navController)
        Spacer(modifier = Modifier.height(20.dp))
        algoRow(navController)
        Spacer(modifier = Modifier.height(20.dp))


    }
}
@Composable
fun algoRow(navController: NavController){
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .background(colorResource(id = R.color.background))
            .clickable {
                navController.navigate(NavDestinations.ALGO_DETAIL_SCREEN)
            }
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .width(42.dp)
                    .height(42.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .border(
                        1.dp,
                        colorResource(id = R.color.text_color),
                        RoundedCornerShape(50.dp)
                    ))
            {
                Image(
                    painter = painterResource(id = R.drawable.cash_logo),
                    contentDescription = "img",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                        .align(Alignment.Center),
                    alignment = Alignment.Center
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Text("Streak Ninja"
                ,color = colorResource(id = R.color.white)
                ,fontSize = 24.sp,
                fontFamily = CustomFonts.gilroy_semibold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Column {
                Row {
                    Text("Total Profit"
                        ,color = colorResource(id = R.color.text_color)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("1400"
                        ,color = colorResource(id = R.color.white)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Text("Algo age"
                        ,color = colorResource(id = R.color.text_color)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("3 years"
                        ,color = colorResource(id = R.color.white)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                }
            }

            Column {
                Row {
                    Text("Percentage win"
                        ,color = colorResource(id = R.color.text_color)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("50%"
                        ,color = colorResource(id = R.color.white)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Text("Completed trades"
                        ,color = colorResource(id = R.color.text_color)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("1400"
                        ,color = colorResource(id = R.color.white)
                        ,fontSize = 14.sp,
                        fontFamily = CustomFonts.gilroy_medium)
                }
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Spacer(modifier = Modifier.width(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 20.dp)
            ) {
                Text("View Detail"
                    ,color = colorResource(id = R.color.border_color_yellow)
                    ,fontSize = 16.sp,
                    fontFamily = CustomFonts.gilroy_semibold)

                Spacer(modifier = Modifier.width(10.dp))

                Box(modifier = Modifier
                    .size(32.dp, 32.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .clickable {
                        navController.navigate(NavDestinations.ALGO_DETAIL_SCREEN)
                    }
                    .background(colorResource(id = R.color.border_color_yellow))){
                    Icon(painter =painterResource(id = R.drawable.arrow_up),
                        modifier = Modifier
                            .size(17.dp)
                            .align(Alignment.Center),
                        tint = Color.Black,
                        contentDescription = "Wallet" )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}