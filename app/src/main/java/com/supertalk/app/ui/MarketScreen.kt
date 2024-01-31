package com.supertalk.app.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.customUI.SmallCustomGraph
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlin.random.Random

data class MarketsDataSet(
    val icon: Int, val title: String, val subTitle: String,
    val cost: String, val percentage: String,val background:Color,
    val textColor:Color
)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MarketScreen(navController: NavController) {
    val selectedMenu = remember { mutableStateOf(0) }

    Column {
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .clickable {
                    selectedMenu.value = 0
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Market Alerts",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 34.sp,
                    fontFamily = CustomFonts.gilroy_semibold
                )
            )

            Box(
                modifier = Modifier
                    .size(53.dp, 53.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(colorResource(id = R.color.background))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    modifier = Modifier
                        .size(27.dp)
                        .align(Alignment.Center),
                    tint = Color.White,
                    contentDescription = "Search"
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .clickable {
                    selectedMenu.value = 1
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "News",
                    style = TextStyle(
                        color = colorResource(R.color.white),
                        fontSize = 16.sp,
                        fontFamily = CustomFonts.gilroy_semibold
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = colorResource(id = R.color.light_grey)))
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Alerts",
                    style = TextStyle(
                        color = colorResource(R.color.white),
                        fontSize = 16.sp,
                        fontFamily = CustomFonts.gilroy_semibold
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = colorResource(id = R.color.border_color_yellow)))
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            when(selectedMenu.value){
                0 -> {
                    NewsScreen(navController)
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                }
                1 -> {
                    AlertsScreen(navController = navController)
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                }
                else -> AlertsScreen(navController)
            }

        }

    }
}

@Composable
fun NewsScreen(navController: NavController) {

    var marketsList: List<MarketsDataSet> = arrayListOf()
    // in the below line, we are adding data to our list
    marketsList = marketsList + MarketsDataSet(R.drawable.apple_icon_96, "AAPL", "Apple Inc.",
        "$1699.48", "-24.26%", colorResource(id = R.color.background_red_color), colorResource(id = R.color.red_text))
    marketsList = marketsList + MarketsDataSet(R.drawable.windows_96, "MSFT", "Microsoft Corporation",
        "$1699.48", "-24.26%", colorResource(id = R.color.background_green_color), colorResource(id = R.color.green_text))
    marketsList = marketsList + MarketsDataSet(R.drawable.icon_tesla_96, "AAPL", "Apple Inc.",
        "$1699.48", "-24.26%", colorResource(id = R.color.background_red_color), colorResource(id = R.color.red_text))
    marketsList = marketsList + MarketsDataSet(R.drawable.icon_meta_96, "AAPL", "Apple Inc.",
        "$1699.48", "-24.26%", colorResource(id = R.color.background_green_color), colorResource(id = R.color.green_text))
    marketsList = marketsList + MarketsDataSet(R.drawable.apple_icon_96, "AAPL", "Apple Inc.",
        "$1699.48", "-24.26%", colorResource(id = R.color.background_red_color), colorResource(id = R.color.red_text))
    marketsList = marketsList + MarketsDataSet(R.drawable.windows_96, "AAPL", "Apple Inc.",
        "$1699.48", "-24.26%", colorResource(id = R.color.background_green_color), colorResource(id = R.color.green_text))
    marketsList = marketsList + MarketsDataSet(R.drawable.icon_tesla_96, "AAPL", "Apple Inc.",
        "$1699.48", "-24.26%", colorResource(id = R.color.background_red_color), colorResource(id = R.color.red_text))

    LazyColumn(modifier = Modifier.fillMaxWidth().height(500.dp)) {
        itemsIndexed(marketsList) { index, item ->
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Max)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconCircle(marketsDetail = item)
                    Spacer(modifier = Modifier.width(15.dp))
                    Row {
                        Text(
                            text = item.title,
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 18.sp,
                                fontFamily = CustomFonts.gilroy_medium
                            ),
                            modifier = Modifier,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = item.subTitle,
                            style = TextStyle(
                                color = colorResource(R.color.light_grey),
                                fontSize = 16.sp,
                                fontFamily = CustomFonts.gilroy_regular
                            ),
                            modifier = Modifier,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp))
                {
                    val numbers = 7
                    LazyColumn(modifier = Modifier
                        .padding(start = 25.dp)
                        .weight(0.25f)
                        .height(100.dp)) {
                        items(numbers) {arrayItem->
                            Divider(
                                color = colorResource(id = R.color.rounded_stroke_color),
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(10.dp))
                            Spacer(modifier = Modifier.height(5.dp))
                        }
                    }

                    Row(modifier = Modifier
                        .height(87.dp)
                        .fillMaxWidth()
                        .background(
                            item.background,
                            RoundedCornerShape(15.dp)
                        )
                        .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.graph),
//                            contentDescription = "img",
//                            modifier = Modifier
//                                .height(43.dp)
//                                .width(100.dp),
//                        )
                        CustomGraph()
                        Column(modifier = Modifier.padding(end = 15.dp)) {
                            Text(
                                text = item.cost,
                                style = TextStyle(
                                    color = colorResource(R.color.white),
                                    fontSize = 18.sp,
                                    fontFamily = CustomFonts.gilroy_medium
                                ),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End
                            )
                            Text(
                                text = item.percentage,
                                style = TextStyle(
                                    color = item.textColor,
                                    fontSize = 16.sp,
                                    fontFamily = CustomFonts.gilroy_regular
                                ),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun IconCircle(marketsDetail: MarketsDataSet) {
    Box(
        modifier = Modifier
            .width(53.dp)
            .height(53.dp)
            .clip(RoundedCornerShape(50.dp))
            .border(
                2.dp,
                colorResource(id = R.color.rounded_stroke_color),
                shape = RoundedCornerShape(50.dp)
            )
            .background(
                color = colorResource(id = R.color.rounded_fill_color),
                RoundedCornerShape(50.dp)
            ))
    {
        Image(
            painter = painterResource(id = marketsDetail.icon),
            contentDescription = "img",
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                .align(Alignment.Center),
            alignment = Alignment.Center
        )
    }
}
@Composable
fun AlertsScreen(navController: NavController) {

}

@Composable
fun CustomGraph() {
    val yStep = 50
    val random = Random
    /* to test with random points */
    val points = (0..20).map {
        var num = random.nextInt(350)
        if (num <= 50)
            num += 100
        num.toFloat()
    }
    Box(
        modifier = Modifier
    ) {
        SmallCustomGraph(
            modifier = Modifier
                .width(150.dp)
                .height(45.dp),
            xValues = (0..20).map { it + 1 },
            yValues = (0..6).map { (it + 1) * yStep },
            points = points,
            paddingSpace = 0.dp,
            verticalStep = yStep
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MarketScreenPreView() {
    SuperTalkApplicationTheme {
        MarketScreen(navController = (rememberNavController()))
    }
}