package com.supertalk.app.ui

import android.util.Log
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import java.lang.Exception

data class TransactionDataSet(
    val icon:Int, val title: String, val date: String, val amount: String,
    val color: Color)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val selectedMenu = remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true,
    )

    var isSheetFullScreen by remember { mutableStateOf(false) }
    val roundedCornerRadius = 20.dp
    val modifier = if (isSheetFullScreen)
        Modifier
            .fillMaxSize()
    else
        Modifier.fillMaxWidth()

    BackHandler(modalSheetState.isVisible) {
        coroutineScope.launch { modalSheetState.hide() }
    }


    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
        sheetContent = {
            Column(
                modifier = modifier
                    .border(
                        2.dp,
                        colorResource(id = R.color.rounded_stroke_color),
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .background(color = colorResource(id = R.color.black)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                Row(horizontalArrangement = Arrangement.Center) {
                    Spacer(modifier = Modifier
                        .size(35.dp, 4.dp)
                        .background(
                            colorResource(id = R.color.light_grey),
                            RoundedCornerShape(7.dp)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()) {
                    Row(modifier = Modifier
                        .weight(0.7f)) {
                        Icon(
                            painter = painterResource(id = R.drawable.transactions),
                            contentDescription = "Home",
                            modifier = Modifier
                                .size(31.dp),
                            tint = colorResource(id = R.color.border_color_yellow)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Transactions",
                            style = TextStyle(
                                color = colorResource(id = R.color.white),
                                fontSize = 24.sp,
                                fontFamily = CustomFonts.gilroy_semibold
                            ))
                    }

                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(0.3f)
                            .height(31.dp)) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "View All",
                            style = TextStyle(
                                color = colorResource(id = R.color.border_color_yellow),
                                fontSize = 16.sp,
                                fontFamily = CustomFonts.gilroy_regular,
                                textAlign = TextAlign.End
                            ))
                    }
                }

                var transactionsList: List<TransactionDataSet> = arrayListOf()
                // in the below line, we are adding data to our list
                transactionsList = transactionsList + TransactionDataSet(R.drawable.arrow_up_white,"Received Amount","30 May 2023","+$180.00",
                    colorResource(id = R.color.green))
                transactionsList = transactionsList + TransactionDataSet(R.drawable.arrow_down_white,"Send Amount","30 May 2023","-$150.00",
                    colorResource(id = R.color.red_text))
                transactionsList = transactionsList + TransactionDataSet(R.drawable.arrow_up_white,"Stock Subscription","30 May 2023","-$20.00",
                    colorResource(id = R.color.red_text))
                transactionsList = transactionsList + TransactionDataSet(R.drawable.arrow_down_white,"Received Amount","30 May 2023","+$120.00",
                    colorResource(id = R.color.red_text))
                transactionsList = transactionsList + TransactionDataSet(R.drawable.arrow_up_white,"Received Amount","30 May 2023","+$200.00",
                    colorResource(id = R.color.red_text))

                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)) {
                    itemsIndexed(transactionsList) { index, item ->
                        Spacer(modifier = Modifier.height(20.dp))
                        Row (modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
                            Row(modifier = Modifier
                                    .weight(0.2f)){
                                Box(modifier = Modifier
                                    .size(50.dp, 50.dp)
                                    .clip(shape = RoundedCornerShape(50.dp))
                                    .background(colorResource(id = R.color.background))
                                ){
                                    Icon(painter = painterResource(id = item.icon),
                                        modifier = Modifier
                                            .size(24.dp, 24.dp)
                                            .align(Alignment.Center),
                                        tint = Color.White,
                                        contentDescription = "Wallet" )
                                }
                            }
                            Column(modifier = Modifier
                                .weight(0.6f)) {
                                Text(
                                    text = item.title,
                                    style = TextStyle(
                                        color = colorResource(R.color.white),
                                        fontSize = 18.sp,
                                        fontFamily = CustomFonts.gilroy_medium
                                    ))
                                Text(
                                    text = item.date,
                                    style = TextStyle(
                                        color = colorResource(R.color.light_grey),
                                        fontSize = 16.sp,
                                        fontFamily = CustomFonts.gilroy_medium
                                    ))
                            }
                            Text(
                                modifier = Modifier.weight(0.2f),
                                text = item.amount,
                                style = TextStyle(
                                    color = item.color,
                                    fontSize = 16.sp,
                                    fontFamily = CustomFonts.gilroy_medium,
                                    textAlign = TextAlign.End
                                ))
                        }
                    }
                }

//                Button(
//                    onClick = {
//                        coroutineScope.launch { modalSheetState.hide() }
//                    }
//                ) {
//                    Text(text = "Hide Sheet")
//                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colorResource(R.color.black)),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    //.weight(weight = 1f, fill = false)
                    //.zIndex(2f)
            ) {
                //Test
                Log.e("Test","HomeScreen - selectedMenu.value - ${selectedMenu.value}")
                when(selectedMenu.value){
                    0 -> {
                        LandingScreen(navController)
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                    }
                    1 -> {
                        AlgoScreen(navController = navController)
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                    }
                    2 -> {
                        MarketScreen(navController = navController)
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                    }
                    3 -> {
                        MyWalletScreen(navController = navController,modalSheetState)
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                    }
                    else -> LandingScreen(navController)
                }
            }
                Box(modifier = Modifier
                    .padding(bottom = 55.dp)
                    .size(56.dp, 56.dp)
                    .align(Alignment.BottomCenter)
                    .zIndex(2f)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .clickable {
                        navController.navigate(NavDestinations.ALGO_DETAIL_SCREEN)
                    }
                    .background(colorResource(id = R.color.border_color_yellow))){
                    Icon(painter =painterResource(id = R.drawable.ic_plus),
                        modifier = Modifier
                            .size(18.dp)
                            .align(Alignment.Center),
                        tint = Color.Black,
                        contentDescription = "Wallet" )
                }
                Box(modifier = Modifier
                    .align(Alignment.BottomCenter)) {
                    BottomNavigationBar(selectedMenu,navController)
                }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedMenu: MutableState<Int>, navController: NavController) {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.background),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(28.dp, 28.dp, 0.dp, 0.dp)),
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home_smile_angle),
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if (selectedMenu.value == 0) colorResource(R.color.violet_dark) else colorResource(
                        R.color.un_selected_background_color
                    ),
                )
            },
            label = {
                Text(
                    text = "Home",
                    style = TextStyle(
                        color = if (selectedMenu.value == 0) colorResource(R.color.violet_dark) else colorResource(
                            R.color.un_selected_background_color
                        ),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.gilroy_medium
                    ))
            },
            selected = selectedMenu.value == 0,
            onClick = {
                selectedMenu.value = 0
            },
            alwaysShowLabel = true,
            selectedContentColor = colorResource(id = R.color.violet_dark),
            unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier.padding(bottom = 10.dp)
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.market),
                    contentDescription = "Algo",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if (selectedMenu.value == 1) colorResource(R.color.violet_dark) else colorResource(
                        R.color.un_selected_background_color
                    ),
                )
            },
            label = {
                Text(
                    text = "Algo",
                    style = TextStyle(
                        color = if (selectedMenu.value == 1) colorResource(R.color.violet_dark) else colorResource(
                            R.color.un_selected_background_color
                        ),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.gilroy_medium
                    ),
                )
            },
            selected = selectedMenu.value == 1,
            onClick = {
                selectedMenu.value = 1
            },
            alwaysShowLabel = true,
            selectedContentColor = colorResource(id = R.color.violet_dark),
            unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Spacer(modifier = Modifier.width(50.dp))

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.market),
                    contentDescription = "Market",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if (selectedMenu.value == 2) colorResource(R.color.violet_dark) else colorResource(
                        R.color.un_selected_background_color
                    ),
                )
            },
            label = {
                Text(
                    text = "Market",
                    style = TextStyle(
                        color = if (selectedMenu.value == 2) colorResource(R.color.violet_dark) else colorResource(
                            R.color.un_selected_background_color
                        ),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.gilroy_medium
                    ),
                )
            },
            selected = selectedMenu.value == 2,
            onClick = {
                //navController.navigate(NavDestinations.ROOM_CREATION_SCREEN)
                    selectedMenu.value = 2
            },
            alwaysShowLabel = true,
            selectedContentColor = colorResource(id = R.color.violet_dark),
            unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier.padding(bottom = 10.dp)
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if (selectedMenu.value == 3) colorResource(R.color.violet_dark) else colorResource(
                        R.color.un_selected_background_color
                    ),
                )
            },
            label = {
                Text(
                    text = "Menu",
                    style = TextStyle(
                        color = if (selectedMenu.value == 3) colorResource(R.color.violet_dark) else colorResource(
                            R.color.un_selected_background_color
                        ),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.gilroy_medium
                    ),
                )
            },
            selected = selectedMenu.value == 3,
            onClick = {
                //navController.navigate(NavDestinations.ROOM_CREATED_SCREEN)
                selectedMenu.value = 3
                Log.e("Test","HomeScreen - onClick selectedMenu 3 - Called()")
            },
            alwaysShowLabel = true,
            selectedContentColor = colorResource(id = R.color.violet_dark),
            unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SuperTalkApplicationTheme {
        HomeScreen(rememberNavController())
    }
}
//https://proandroiddev.com/creating-graph-in-jetpack-compose-312957b11b2