package com.supertalk.app.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun MyWalletScreen(navController: NavController,modalSheetState:ModalBottomSheetState) {
    val coroutineScope = rememberCoroutineScope()

    Column {
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
            ){
                Icon(painter = painterResource(id = R.drawable.ic_back),
                    modifier = Modifier
                        .size(21.dp, 22.dp)
                        .align(Alignment.Center),
                    tint = Color.White,
                    contentDescription = "Wallet" )
            }
            Text(
                text = "My Wallet",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.gilroy_medium
                ),
                modifier = Modifier,
                textAlign = TextAlign.Center
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
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Current Balance",
                style = TextStyle(
                    color = colorResource(R.color.light_grey),
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.gilroy_medium
                ),
                modifier = Modifier,
                textAlign = TextAlign.Center
            )
            Text(
                text = "$275,458",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 55.sp,
                    fontFamily = CustomFonts.gilroy_medium
                ),
                modifier = Modifier,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
        ){
            Column(modifier = Modifier
                .weight(2f)
                .height(180.dp)
                .background(
                    colorResource(id = R.color.background),
                    RoundedCornerShape(15.dp)
                )
                .clickable {
                    coroutineScope.launch {
                        if (modalSheetState.isVisible)
                            modalSheetState.hide()
                        else
                            modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                    }
                },
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .size(52.dp, 52.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(colorResource(id = R.color.border_color_yellow))){
                    Icon(painter =painterResource(id = R.drawable.arrow_up),
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center),
                        tint = Color.Black,
                        contentDescription = "Wallet" )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                ) {
                    Column(modifier = Modifier) {
                        Text(
                            text = "Send ",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 18.sp,
                                fontFamily = CustomFonts.gilroy_semibold
                            ),
                            modifier = Modifier,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Amount",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 18.sp,
                                fontFamily = CustomFonts.gilroy_semibold
                            ),
                            modifier = Modifier,
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(modifier = Modifier
                        .size(30.dp, 30.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(colorResource(id = R.color.light_grey))
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_right_arrow),
                            modifier = Modifier
                                .size(10.dp, 10.dp)
                                .align(Alignment.Center),
                            tint = Color.White,
                            contentDescription = "Wallet" )
                    }
                }
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(modifier = Modifier
                .weight(2f)
                .height(180.dp)
                .background(
                    colorResource(id = R.color.background),
                    RoundedCornerShape(15.dp)
                ),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .size(52.dp, 52.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(colorResource(id = R.color.border_color_yellow))){
                    Icon(painter =painterResource(id = R.drawable.arrow_up),
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center),
                        tint = Color.Black,
                        contentDescription = "Wallet" )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                ) {
                    Column(modifier = Modifier) {
                        Text(
                            text = "Add ",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 18.sp,
                                fontFamily = CustomFonts.gilroy_semibold
                            ),
                            modifier = Modifier,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Amount",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 18.sp,
                                fontFamily = CustomFonts.gilroy_semibold
                            ),
                            modifier = Modifier,
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(modifier = Modifier
                        .size(30.dp, 30.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(colorResource(id = R.color.light_grey))
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_right_arrow),
                            modifier = Modifier
                                .size(10.dp, 10.dp)
                                .align(Alignment.Center),
                            tint = Color.White,
                            contentDescription = "Wallet" )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(300.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MyWalletScreenPreView() {
    SuperTalkApplicationTheme {
        //MyWalletScreen(navController = (rememberNavController()),null)
    }
}
//https://github.com/aqua30/GraphCompose/blob/master/app/src/main/java/com/aqua30/graphcompose/screen/Graph.kt