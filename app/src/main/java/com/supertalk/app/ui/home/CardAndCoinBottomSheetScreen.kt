package com.supertalk.app.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun CardAndCoinBottomSheetScreen(navController: NavController) {


    // State to control the bottom sheet visibility
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()

    // Coroutine scope for launching actions
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                bottomSheetScaffoldState.bottomSheetState.expand()
            } else {
                bottomSheetScaffoldState.bottomSheetState.collapse()
            }
        }
    }

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(25.dp),
        backgroundColor = Color.Black,
        sheetElevation = 10.dp,
        sheetContent = {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(colorResource(id = R.color.background))
                    .padding(start = 16.dp, end = 16.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Buy Tokens",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontFamily = CustomFonts.manrope_extra_bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(15.dp))
                getTokenWithButtonUI(navController)
                Spacer(modifier = Modifier.height(40.dp))
                getCardListUI(navController = navController)
                Spacer(modifier = Modifier.height(10.dp))
                getPayInCryptoUI(navController = navController)
                Spacer(modifier = Modifier.height(10.dp))
                ButtonWithElevation(
                    navController,
                    true,
                    "DONE",
                    bottomSheetScaffoldState,
                    coroutineScope
                )

                Spacer(modifier = Modifier.height(26.dp))
            }
        },
        sheetPeekHeight = 0.dp,
    ) {

        // Main content of the screen
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .drawWithContent {
                        drawContent()
                        // draws a fully black area with a small keyhole at pointerOffset that’ll show part of the UI.
                        drawRect(
                            Brush.radialGradient(
                                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) listOf(
                                    Color.Transparent,
                                    Color.Transparent
                                )
                                else
                                    listOf(
                                        Color.Black.copy(alpha = 0.6f),
                                        Color.Black.copy(alpha = 0.6f)
                                    )

                            )
                        )
                    }
                    .background(
                        color = Color(0xfff3f0ff)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

            }
        }

    }


}

@Composable
fun getTokenWithButtonUI(navController: NavController){
    Row(modifier = Modifier
        .background(colorResource(id = R.color.white), shape = RoundedCornerShape(16.dp))
        .height(62.dp)
        .fillMaxWidth()
        .clickable {
            //navController.navigate(NavDestinations.COIN_CARD_BOTTOM_SHEET_SCREEN)
        },
        verticalAlignment = Alignment.CenterVertically,
    )
    {

        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_coin_yellow),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp, 24.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "1,000 Tokens",
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_semi_bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(5.dp))
        Box(modifier = Modifier.weight(1f)){
            Button(
                onClick = {
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.violet_dark)
                ),
                modifier = Modifier
                    .wrapContentWidth()
                    //.padding(top = 20.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
                    .height(38.dp)
                    .align(Alignment.CenterEnd),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    text = "4.99 SAR", style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold,
                        color = Color.White
                    )
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun getCardListUI(navController: NavController){
    Row(modifier = Modifier
        .background(colorResource(id = R.color.white), shape = RoundedCornerShape(14.dp))
        .height(52.dp)
        .fillMaxWidth()
        .border(1.dp, colorResource(id = R.color.violet_dark),shape = RoundedCornerShape(14.dp))
        .clickable {
            navController.navigate(NavDestinations.SELECT_CARD_SCREEN)
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {

        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painter = painterResource(id = R.drawable.mada_logo),
            contentDescription = "",
            modifier = Modifier
                .size(61.dp, 20.dp),
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painter = painterResource(id = R.drawable.master_card_logo),
            contentDescription = "",
            modifier = Modifier
                .size(47.dp, 26.dp),
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painter = painterResource(id = R.drawable.visa_card_logo),
            contentDescription = "",
            modifier = Modifier
                .size(61.dp, 18.dp),
            tint = Color.Unspecified,
        )
    }
}

@Composable
fun getPayInCryptoUI(navController: NavController){
    Row(modifier = Modifier
        .background(colorResource(id = R.color.white), shape = RoundedCornerShape(14.dp))
        .height(52.dp)
        .fillMaxWidth()
        .border(1.dp, colorResource(id = R.color.violet_dark),shape = RoundedCornerShape(14.dp))
        .clickable {
            //navController.navigate(NavDestinations.COIN_CARD_BOTTOM_SHEET_SCREEN)
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Pay In Crypto",
            style = TextStyle(
                color = colorResource(id = R.color.violet_dark),
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painter = painterResource(id = R.drawable.bitcoin_logo),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp, 24.dp),
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(10.dp))

    }
}

//@Composable
//fun BasicButton(
//    navController: NavController, ) {
//    Button(
//        onClick = {
//        },
//        elevation = ButtonDefaults.elevation(
//            defaultElevation = 15.dp,
//        ),
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = colorResource(id = R.color.violet_dark)
//        ),
//        modifier = Modifier
//            .wrapContentWidth()
//            //.padding(top = 20.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
//            .height(38.dp)
//            .align(Alignment.CenterEnd),
//        shape = RoundedCornerShape(12.dp),
//    ) {
//        Text(
//            text = "4.99 SAR", style = TextStyle(
//                fontSize = 15.sp,
//                fontFamily = CustomFonts.manrope_bold,
//                color = Color.White
//            )
//        )
//    }
//}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonWithElevation(
    navController: NavController,
    active: Boolean,
    tittle: String,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    coroutineScope: CoroutineScope
) {
    Button(
        onClick = {
//            coroutineScope.launch {
//                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
//                    bottomSheetScaffoldState.bottomSheetState.expand()
//                } else {
//                    bottomSheetScaffoldState.bottomSheetState.collapse()
//                }
//            }
            navController.navigate(NavDestinations.CARD_DETAILS_ENTER_SCREEN)
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (!active) Color(0xFFC6C6C6) else MaterialTheme.colors.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(14.dp),
    ) {
        Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Pay With",
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontSize = 15.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painter = painterResource(id = R.drawable.google_pay_logo),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp, 23.dp),
                tint = Color.Unspecified,
            )
            Spacer(modifier = Modifier.width(10.dp))

        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardAndCoinBottomSheetScreenPreView() {
    SuperTalkApplicationTheme {
        CardAndCoinBottomSheetScreen(rememberNavController())
    }
}