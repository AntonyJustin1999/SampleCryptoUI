package com.supertalk.app.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.max
import androidx.compose.ui.zIndex
import com.supertalk.app.util.NavDestinations
import kotlin.math.absoluteValue
import kotlin.math.min

@Composable
fun NewsDetailsScreen(navController: NavController) {

    NewsDetailsScreenImpl(navController)

}
@Composable
fun NewsDetailsScreenImpl(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                        , horizontalArrangement = Arrangement.End){
                        Spacer(
                            Modifier
                                .weight(0.50f)
                                .fillMaxHeight())
                        IconButton(onClick = {

                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = null
                                , modifier = Modifier.size(24.dp,24.dp))
                        }
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(NavDestinations.HOME_SCREEN)
                    }) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_white), contentDescription = null)
                    }
                }
            )
        }
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
            ) {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .zIndex(1f)){
                    Image(
                        painter = painterResource(id = R.drawable.test_sports_big_img),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(220.dp)
                            .fillMaxWidth())

                    Box(modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset {
                            IntOffset(x = 0, y = 160)
                        })
                    {
                        getRoundedCornerMenu()
                    }
                }

                Column(
                    modifier = Modifier
                        .zIndex(0f)
                        //.verticalScroll(rememberScrollState())
                        //.weight(weight = 1f, fill = false)
                        .fillMaxHeight()
                        .background(colorResource(id = R.color.background))
                ) {

                    Column(
                        modifier = Modifier
                    ) {
                        Spacer(modifier = Modifier.padding(top = 70.dp))
                        getDateTextViewRow()
                        Spacer(modifier = Modifier.padding(top = 15.dp))

                        Divider(
                            color = colorResource(id = R.color.white),
                            modifier = Modifier
                                .fillMaxWidth()  //fill the max height
                                .width(1.dp)
                        )

                        Spacer(modifier = Modifier.padding(top = 20.dp))

                        Text(
                            text = "Ronaldo Gets Injured",

                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 16.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 16.dp, end = 16.dp),
                        )

                        Spacer(modifier = Modifier.padding(top = 10.dp))

                        Text(
                            text = "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.",

                            style = TextStyle(
                                color = colorResource(id = R.color.text_color),
                                fontSize = 13.sp,
                                fontFamily = CustomFonts.manrope_semi_bold
                            ),
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 16.dp, end = 16.dp),
                        )

                        Spacer(modifier = Modifier.padding(top = 20.dp))

                    }
                }
            }
        }

    }
}

@Composable
fun getDateTextViewRow(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp)
        , verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "28/06/2023",

            style = TextStyle(
                color = colorResource(id = R.color.text_color),
                fontSize = 13.sp,
                fontFamily = CustomFonts.manrope_semi_bold
            ),
            modifier = Modifier.wrapContentSize(),
        )

        Text(
            text = "Emirates Stadium",

            style = TextStyle(
                color = colorResource(id = R.color.text_color),
                fontSize = 13.sp,
                fontFamily = CustomFonts.manrope_semi_bold
            ),
            modifier = Modifier.wrapContentSize(),
        )
    }
}
@Composable
fun getRoundedCornerMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.White, RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // in the below line, we are adding Image to display the image.
            Image(
                // in the below line, we are specifying the drawable image for our image.
                painter = painterResource(id = R.drawable.test_barcelona),
                contentDescription = "img",
                modifier = Modifier
                    .height(38.dp)
                    .width(38.dp),
                alignment = Alignment.Center
            )

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


        Box(
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .size(72.dp, 38.dp)
                    .background(
                        color = colorResource(id = R.color.light_background),
                        RoundedCornerShape(11.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    modifier = Modifier,
                    text = "2",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                    textAlign = TextAlign.End,
                )
                Text(
                    modifier = Modifier,
                    text = "1",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                    textAlign = TextAlign.Start,
                )
            }


        }



        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // in the below line, we are adding Image to display the image.
            Image(
                // in the below line, we are specifying the drawable image for our image.
                painter = painterResource(id = R.drawable.test_real_madrid),
                contentDescription = "img",
                modifier = Modifier
                    .height(38.dp)
                    .width(38.dp),
                alignment = Alignment.Center
            )

            Text(
                text = "Real Madrid",

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
}
@Preview(showBackground = true)
@Composable
fun NewsDetailsScreenPreview() {
    SuperTalkApplicationTheme {
        NewsDetailsScreen(rememberNavController())
    }
}