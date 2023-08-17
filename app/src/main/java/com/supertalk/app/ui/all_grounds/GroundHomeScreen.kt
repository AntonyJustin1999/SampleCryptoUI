package com.supertalk.app.ui.all_grounds

import BottomSheetItem
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.supertalk.app.R
import com.supertalk.app.model.HorizontalPagerContent
import com.supertalk.app.model.NewsDataSet
import com.supertalk.app.model.SportsDataSet
import com.supertalk.app.ui.basic_intro_slider.DotsIndicator
import com.supertalk.app.ui.customwidget.RightBubbleShape
import com.supertalk.app.ui.home.HomePageScreen
import com.supertalk.app.ui.home.Room1Screen
import com.supertalk.app.ui.home.Room2Screen
import com.supertalk.app.ui.home.Room3Screen
import com.supertalk.app.ui.home.Room4Screen
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.launch

data class SpeakersDataSet(val speakerProfile: Int,val isMikeOn: Boolean,val isMikeMute: Boolean,
                           val isEmoji: Boolean,val isHand: Boolean,)
@Composable
fun GroundHomeScreen(navController: NavController) {
    
    val selectedMenu = remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .paint(
                // Replace with your image id
                painterResource(id = R.drawable.bg_gross_light),
                contentScale = ContentScale.FillBounds
            )
    )
    {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.2f)
            ) {
                TopRow(navController = navController,selectedMenu)
            }

            Spacer(modifier = Modifier.height(11.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f),
                verticalArrangement = Arrangement.Bottom
            ){
                customListView(LocalContext.current)
            }

            Spacer(modifier = Modifier.height(15.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(7.9f)
            ){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                ){

                    when(selectedMenu.value){
                        0 -> {
                            StaticSoccerGroundUI(navController = navController)
                        }
                        1 -> {
                            Text(
                                text = "Selected Menu ${selectedMenu.value}",
                                style = TextStyle(
                                    color = Color.LightGray,
                                    fontSize = 20.sp,
                                    fontFamily = CustomFonts.manrope_bold
                                ),
                                textAlign = TextAlign.Center,
                            )
                        }
                        2 -> {
                            Text(
                                text = "Selected Menu ${selectedMenu.value}",
                                style = TextStyle(
                                    color = Color.Green,
                                    fontSize = 20.sp,
                                    fontFamily = CustomFonts.manrope_bold
                                ),
                                textAlign = TextAlign.Center,
                            )
                        }
                        3 -> {
                            Text(
                                text = "Selected Menu ${selectedMenu.value}",
                                style = TextStyle(
                                    color = Color.Cyan,
                                    fontSize = 20.sp,
                                    fontFamily = CustomFonts.manrope_bold
                                ),
                                textAlign = TextAlign.Center,
                            )
                        }
                        4 -> {
                            Text(
                                text = "Selected Menu ${selectedMenu.value}",
                                style = TextStyle(
                                    color = Color.Magenta,
                                    fontSize = 20.sp,
                                    fontFamily = CustomFonts.manrope_bold
                                ),
                                textAlign = TextAlign.Center,
                            )
                        }
                        else -> {
                            Text(
                                text = "Selected Menu ${selectedMenu.value}",
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = CustomFonts.manrope_bold
                                ),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }

                }
            }

            Spacer(modifier = Modifier.height(5.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(start = 10.dp, end = 10.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 13.dp, end = 13.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BottomRowContent(navController = navController)
                }
            }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun customListView(context: Context) {

    val selectedIndex = remember { mutableStateOf(-1) }

    // in the below line, we are creating and
    // initializing our array list
    lateinit var speakersList: List<SpeakersDataSet>
    speakersList = ArrayList<SpeakersDataSet>()

    // in the below line, we are adding data to our list.
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,true,false,false,false)
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,false,false,true,true)
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,false,false,true,true)
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,false,true,false,false)
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,false,true,false,false)
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,false,true,false,false)
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,false,true,false,false)
    speakersList = speakersList + SpeakersDataSet(R.drawable.iv_user,false,true,false,false)

//    onClick = {
//        // inside on click we are displaying the toast message.
//        Toast.makeText(
//            context,
//            speakersList[index].toString() + " selected..",
//            Toast.LENGTH_SHORT
//        ).show()
//        selectedIndex.value = index
//    },

    LazyRow(modifier = Modifier) {
        itemsIndexed(speakersList) { index, item ->
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(58.dp)
            )
            {
                    Image(
                        painter = painterResource(id = speakersList[index].speakerProfile),
                        contentDescription = "img",
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .height(58.dp)
                            .width(58.dp)
                            .clip(RoundedCornerShape(18.dp))
                            //.background(color = Color.Unspecified,shape = )
                            .border(
                                2.dp,
                                if (selectedIndex.value == index)
                                    colorResource(id = R.color.border_color_yellow)
                                else
                                    colorResource(id = R.color.white),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .clickable { }
                        ,
                        alignment = Alignment.Center
                    )

                if(item.isMikeOn){
                    Icon(
                        painter = painterResource(id = R.drawable.mike_on),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset {
                                IntOffset(x = 30, y = 16)
                            }
                            .size(40.dp, 40.dp)
                            .zIndex(2f)
                            .clickable { },
                        tint = Color.Unspecified

                    )
                }

                if(item.isEmoji){
                    Icon(
                        painter = painterResource(id = R.drawable.smile),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset {
                                IntOffset(x = 30, y = 26)
                            }
                            .size(40.dp, 40.dp)
                            .zIndex(2f)
                            .clickable { },
                        tint = Color.Unspecified

                    )
                }

                if(item.isMikeMute){
                    Icon(
                        painter = painterResource(id = R.drawable.mike_off),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset {
                                IntOffset(x = 30, y = 26)
                            }
                            .size(40.dp, 40.dp)
                            .zIndex(2f)
                            .clickable { }
                        ,
                        tint = Color.Unspecified

                    )
                }

                if(item.isHand){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hand),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset {
                                IntOffset(x = 40, y = -30)
                            }
                            .size(37.dp, 29.dp)
                            .zIndex(2f)
                            .clickable { }
                        ,
                        tint = Color.Unspecified

                    )
                }

            }
        }
    }
}
@Composable
fun TopRow(navController: NavController,selectedMenu:MutableState<Int>) {

    Row(
        modifier = Modifier
            .background(
                color = colorResource(id = R.color.ground_green),
                shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
            )
            .fillMaxWidth()
            .fillMaxHeight()
        ,
        verticalAlignment = Alignment.Bottom
    ) {
        
        Spacer(modifier = Modifier.width(15.dp))
        getCountryIconRow(navController)
        Spacer(modifier = Modifier.weight(1f))
        getHorizontalMenusList(selectedMenu)

    }

}

@Composable
fun getCountryIconRow(navController: NavController) {
    Row(modifier = Modifier
        .height(50.dp)
        , verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_paris_saint_german),
            contentDescription = "",
            modifier = Modifier
                .size(34.dp, 34.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(5.dp))

        Column {
            Row(modifier = Modifier
                , verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "0",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Divider(
                    color = colorResource(id = R.color.un_selected_background_color),
                    modifier = Modifier
                        .height(13.dp)
                        .width(1.dp)
                        .align(Alignment.CenterVertically)
                        .padding(top = 2.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "0",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
            Text(
                text = "90'",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = CustomFonts.manrope_semi_bold,
                ),
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            painter = painterResource(id = R.drawable.img_real_madrid),
            contentDescription = "",
            modifier = Modifier
                .size(34.dp, 34.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun getHorizontalMenusList(selectedMenu:MutableState<Int>){
    Row(modifier = Modifier
        .height(50.dp)
        , verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = if(selectedMenu.value == 0) painterResource(id = R.drawable.ic_symbol_seat_clicked) else painterResource(id = R.drawable.ic_symbol_seat_not_clicked),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp, 24.dp)
                .clickable {
                    selectedMenu.value = 0
                },
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(13.dp))
        Icon(
            painter = if(selectedMenu.value == 1) painterResource(id = R.drawable.ic_whistle_clicked) else painterResource(id = R.drawable.ic_whistle_not_clicked),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp, 24.dp)
                .clickable {
                    selectedMenu.value = 1
                },
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(13.dp))
        Icon(
            painter = if(selectedMenu.value == 2) painterResource(id = R.drawable.ic_fluent_live_clicked) else painterResource(id = R.drawable.ic_fluent_live_not_clicked),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp, 24.dp)
                .clickable {
                    selectedMenu.value = 2
                },
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(13.dp))
        Icon(
            painter = if(selectedMenu.value == 3) painterResource(id = R.drawable.ic_fluent_people_clicked) else painterResource(id = R.drawable.ic_fluent_people_not_clicked),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp, 24.dp)
                .clickable {
                    selectedMenu.value = 3
                },
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(13.dp))
        Icon(
            painter = if(selectedMenu.value == 4) painterResource(id = R.drawable.ic_stats_up_clicked) else painterResource(id = R.drawable.ic_stats_up_not_clicked),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp, 24.dp)
                .clickable {
                    selectedMenu.value = 4
                },
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun BottomRowContent(navController: NavController) {

        //Spacer(modifier = Modifier.width(5.dp))

        Row(modifier = Modifier
            .background(Color.White,
                RoundedCornerShape(40.dp))
            .height(25.dp)
            , verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_eye),
                contentDescription = "",
                modifier = Modifier
                    .size(18.dp, 18.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "100K",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = CustomFonts.manrope_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
        }

        Row(modifier = Modifier
        .background(Color.White,
            RoundedCornerShape(40.dp))
        .height(25.dp)
        , verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Room1",
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = CustomFonts.manrope_bold
            ),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.width(5.dp))
         }
        Icon(
            painter = painterResource(id = R.drawable.ic_close_circle),
            contentDescription = "",
            modifier = Modifier
                .size(32.dp, 32.dp),
            tint = Color.Unspecified
        )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SuperTalkApplicationTheme {
        GroundHomeScreen(rememberNavController())
    }
}