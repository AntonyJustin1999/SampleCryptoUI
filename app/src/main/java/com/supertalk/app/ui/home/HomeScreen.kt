package com.supertalk.app.ui.home

import BottomSheetItem
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
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
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    val selectedMenu = remember { mutableStateOf(0) }

    // State to control the bottom sheet visibility
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    // State to hold the selected item
    val selectedItem = remember { mutableStateOf<BottomSheetItem?>(null) }
    // Coroutine scope for launching actions
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
    )
    {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
        ) {

            when(selectedMenu.value){
                0 -> {
                    HomePageScreen(navController)
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                }
                1 -> {
                    Room1Screen(navController = navController,1)
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Spacer(modifier = Modifier.height(150.dp))
                }
                2 -> {
                    Room2Screen(navController = navController,2)
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Spacer(modifier = Modifier.height(150.dp))
                }
                3 -> {
                    Room3Screen(navController = navController,3)
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Spacer(modifier = Modifier.height(150.dp))
                }
                4 -> {
                    Room4Screen(navController = navController,4)
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Spacer(modifier = Modifier.height(150.dp))
                }
                else ->HomePageScreen(navController)
            }

        }
        BottomNavigationBar(selectedMenu,navController)
    }
}

@Composable
fun HomePageScreen(navController: NavController) {
    TopRow(navController = navController)

    Spacer(modifier = Modifier.padding(top = 10.dp))

    Text(
        text = "Sports",
        style = TextStyle(
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_extra_bold
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(start = 16.dp)
    )

    Spacer(modifier = Modifier.padding(top = 10.dp))

    customListView(LocalContext.current)

    Spacer(modifier = Modifier.padding(top = 16.dp))

    Text(
        text = "Today's Hot Matches",
        style = TextStyle(
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_extra_bold
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(start = 16.dp)
    )

    HorizontalPager()

    Spacer(modifier = Modifier.padding(top = 15.dp))

    Divider(
        color = colorResource(id = R.color.white),
        modifier = Modifier
            .fillMaxWidth()  //fill the max height
            .width(1.dp)
    )


    customCurveLayout( context = LocalContext.current,navController = navController,
        text = "Direct Prediction",type = ROOMTYPES.DirectPrediction,isShowLabel = false,
        isShowCoin = false, isLastItem = false)

    customCurveLayout( context = LocalContext.current,navController = navController,
        text = "Live Rooms",type = ROOMTYPES.LiveRooms,isShowLabel = false,
        isShowCoin = false, isLastItem = true)

    Text(
        text = "News For You",
        style = TextStyle(
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_extra_bold
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(start = 16.dp, top = 10.dp)
    )

    Spacer(modifier = Modifier.padding(top = 6.dp))

    customListViewForNews(LocalContext.current,navController)
}
@Composable
fun Room1Screen(navController: NavController,roomNo:Int) {
    TopRow(navController = navController)

    Spacer(modifier = Modifier.padding(top = 10.dp))

    Text(
        text = "Today's Hot Matches",
        style = TextStyle(
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_extra_bold
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(start = 16.dp)
    )

    HorizontalPager()

    Spacer(modifier = Modifier.padding(top = 15.dp))


    Box(modifier = Modifier
        .fillMaxWidth()
        .height(27.dp)
        .background(colorResource(id = R.color.violet_dark))
    ) {
        Text(
            text = "Room${roomNo}",
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = CustomFonts.manrope_medium
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
    }

    customCurveLayout( context = LocalContext.current,navController = navController,
        text = "Create Room",type = ROOMTYPES.CreateRoom,isShowLabel = false
        ,isShowCoin = true, isLastItem = false)

    customCurveLayout( context = LocalContext.current,navController = navController,
        text = "Join Room",type = ROOMTYPES.JoinRoom,isShowLabel = false
        ,isShowCoin = true, isLastItem = true)

}

@Composable
fun Room2Screen(navController: NavController,roomNo:Int) {
    Room1Screen(navController = navController,roomNo)
}

@Composable
fun Room3Screen(navController: NavController,roomNo:Int) {
    Room1Screen(navController = navController,roomNo)
}

@Composable
fun Room4Screen(navController: NavController,roomNo:Int) {
    Room1Screen(navController = navController,roomNo)
}




@Composable
private fun MyProfileImage() {
    Box(
        modifier = Modifier.size(44.dp,44.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.test_profile),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(44.dp, 44.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(width = 2.dp, Color.White, shape = RoundedCornerShape(10.dp)),
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_discount_tick),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset {
                    IntOffset(x = 20, y = -20)
                }
                .size(24.dp, 24.dp),
            tint = Color.Unspecified

        )
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun customListView(context: Context) {

    val selectedIndex = remember { mutableStateOf(-1) }

    // in the below line, we are creating and
    // initializing our array list
    lateinit var sportsList: List<SportsDataSet>
    sportsList = ArrayList<SportsDataSet>()

    // in the below line, we are adding data to our list.
    sportsList = sportsList + SportsDataSet("Soccer", R.drawable.ic_soccer)
    sportsList = sportsList + SportsDataSet("Football", R.drawable.ic_football)
    sportsList = sportsList + SportsDataSet("Basketball", R.drawable.ic_basketball)
    sportsList = sportsList + SportsDataSet("Cricket", R.drawable.ic_cricket)

    LazyRow(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        itemsIndexed(sportsList) { index, item ->
            Card(
                onClick = {
                    // inside on click we are displaying the toast message.
                    Toast.makeText(
                        context,
                        sportsList[index].sportsName + " selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                    selectedIndex.value = index
                },
                modifier = Modifier
                    .width(83.dp)
                    .height(85.dp)
                    .border(
                        2.dp,
                        if (selectedIndex.value == index)
                            colorResource(id = R.color.border_color_yellow)
                        else
                            colorResource(id = R.color.white),
                        shape = RoundedCornerShape(16.dp)
                    )
                , shape = RoundedCornerShape(16.dp))
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // in the below line, inside row we are adding spacer
                    Spacer(modifier = Modifier.height(13.dp))

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = sportsList[index].sportsImg),

                        // in the below line, we are specifying
                        // content description for our image
                        contentDescription = "img",

                        // in the below line, we are setting height
                        // and width for our image.
                        modifier = Modifier
                            .height(29.dp)
                            .width(29.dp),

                        alignment = Alignment.Center
                    )

                    // in the below line, we are adding spacer between image and a text
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = sportsList[index].sportsName,

                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_bold
                        ),
                        modifier = Modifier,

                        // in the below line, we are adding color for our text
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun customListViewForNews(context: Context,navController: NavController) {

    val selectedIndex = remember { mutableStateOf(-1) }

    // in the below line, we are creating and
    // initializing our array list
    lateinit var newsList: List<NewsDataSet>
    newsList = ArrayList<NewsDataSet>()

    // in the below line, we are adding data to our list.
    newsList = newsList + NewsDataSet("Soccer", R.drawable.ic_soccer)
    newsList = newsList + NewsDataSet("Soccer", R.drawable.ic_soccer)
    newsList = newsList + NewsDataSet("Soccer", R.drawable.ic_soccer)
    newsList = newsList + NewsDataSet("Soccer", R.drawable.ic_soccer)

    LazyRow(modifier = Modifier.padding(top = 10.dp)) {
        itemsIndexed(newsList) { index, item ->
            Spacer(modifier = Modifier.width(13.dp))
            Card(
                onClick = {
                    navController.navigate(NavDestinations.NEWS_DETAILS_SCREEN)
                },
                modifier = Modifier
                    .width(288.dp)
                , shape = RoundedCornerShape(16.dp))
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                ) {
                    // in the below line, inside row we are adding spacer
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier
                        , verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            // in the below line, we are specifying the drawable image for our image.
                            painter = painterResource(id = R.drawable.test_barcelona),
                            contentDescription = "img",
                            modifier = Modifier
                                .height(29.dp)
                                .width(29.dp),
                            alignment = Alignment.Center
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            // in the below line, we are specifying the drawable image for our image.
                            painter = painterResource(id = R.drawable.test_real_madrid),
                            contentDescription = "img",
                            modifier = Modifier
                                .height(29.dp)
                                .width(29.dp),
                            alignment = Alignment.Center
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Text(
                                text = "28/06/2023",

                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontFamily = CustomFonts.manrope_medium
                                ),
                                modifier = Modifier.fillMaxWidth(),

                                // in the below line, we are adding color for our text
                                color = colorResource(id = R.color.text_color),
                                textAlign = TextAlign.End
                            )

                            Text(
                                text = "Emirates Stadium",

                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontFamily = CustomFonts.manrope_medium
                                ),
                                modifier = Modifier.fillMaxWidth(),

                                // in the below line, we are adding color for our text
                                color = colorResource(id = R.color.text_color),
                                textAlign = TextAlign.End
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.test_img_sports_news),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(256.dp,130.dp)

                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.fillMaxWidth()
                        , verticalAlignment = Alignment.CenterVertically
                        , horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Barcelona",

                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            modifier = Modifier.wrapContentSize(),
                        )

                        Text(
                            text = "2",

                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            modifier = Modifier.wrapContentSize(),
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()
                        , verticalAlignment = Alignment.CenterVertically
                        , horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Real Madrid",

                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            modifier = Modifier.wrapContentSize(),
                        )

                        Text(
                            text = "1",

                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            modifier = Modifier.wrapContentSize(),
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Divider(
                        color = colorResource(id = R.color.un_selected_background_color),
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp)
                            .padding(top = 10.dp, bottom = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.",

                        style = TextStyle(
                            color = colorResource(id = R.color.text_color),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_medium
                        ),
                        //textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}

class CustomBottomRightCornerShape(
    private val cornerShape: Float,
    private val bottomBoxSize: Float
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            reset()
            // 1. Move to x = cornerShape (16), y = 0
            moveTo(cornerShape, 0f)

            // 2. Draw a line till x = composableWidth + arrowWidth and y = 0
            lineTo(size.width , 0f)

            arcTo(
                rect = Rect(
                    Offset(x = size.width - cornerShape, y = 0f),
                    Size(width = cornerShape,height = cornerShape)
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            // 5. Move to bottom now.
            lineTo(size.width, size.height - bottomBoxSize)

            arcTo(
                rect = Rect(
                    offset = Offset(size.width - cornerShape, size.height - bottomBoxSize - cornerShape),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(size.width-bottomBoxSize, size.height - bottomBoxSize)

            arcTo(
                rect = Rect(
                    offset = Offset(size.width-bottomBoxSize, size.height - bottomBoxSize),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = -90f,
                forceMoveTo = false
            )

            lineTo(size.width-bottomBoxSize, size.height)

            arcTo(
                rect = Rect(
                    offset = Offset(size.width - bottomBoxSize - cornerShape, size.height - cornerShape),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(0f, size.height)

            arcTo(
                rect = Rect(
                    offset = Offset(0f, size.height - cornerShape),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(0f, 0f)

            arcTo(
                rect = Rect(
                    offset = Offset(0f, 0f),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            close()
        }
        return Outline.Generic(path)
    }
}
@Composable
fun customCurveLayout(context: Context,navController: NavController,
    text:String,type:ROOMTYPES,isShowLabel:Boolean,labelText:String? = null,
    labelColor:Color? = null ,isShowCoin:Boolean,isLastItem:Boolean) {

    val cornerShape = with(LocalDensity.current) { 30.dp.toPx() }
    val size = with(LocalDensity.current) { 50.dp.toPx() }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 16.dp)
    ) {

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(color = colorResource(id = R.color.background))
                .zIndex(5f)
            )

        Row(){
            Spacer(modifier = Modifier
                .fillMaxHeight()
                .width(15.dp)
                .background(color = colorResource(id = R.color.background))
                .zIndex(5f)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(102.dp)
                    .background(Color.White, CustomBottomRightCornerShape(cornerShape, size))
            ) {

                if(isShowCoin){
                    Row(modifier = Modifier.align(Alignment.BottomStart).padding(start = 10.dp, bottom = 10.dp)
                        .border(
                            1.dp, colorResource(id = R.color.border_color),
                            RoundedCornerShape(8.dp)
                        )
                        .background(color = colorResource(id = R.color.light_background_menu)
                        , shape = RoundedCornerShape(8.dp))
                        .height(28.dp)
                        , verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_coin_yellow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(18.dp, 18.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "1000",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontFamily = CustomFonts.manrope_semi_bold
                            ),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }

                if(isShowLabel){
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(bottom = 50.dp)
                                .offset(x = (-27).dp, y = (8).dp)
                        ) {
                            Canvas(
                                modifier = Modifier
                                    .height(28.dp)
                                    .width(135.dp)
                                    .rotate(125f)
                                    .clip(shape = RoundedCornerShape(bottomStart = 10.dp))
                            ) {
                                drawRect(labelColor?: Color.White)
                            }

                            Text(
                                text = labelText?:"",
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    fontFamily = CustomFonts.manrope_medium
                                ),
                                modifier = Modifier
                                    .height(28.dp)
                                    .width(135.dp)
                                    .rotate(-56f),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                Text(
                    text = text,

                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    modifier = Modifier.align(Alignment.Center),

                    // in the below line, we are adding color for our text
                    color = Color.Black, textAlign = TextAlign.Center
                )

                IconButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(44.dp, 44.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(colorResource(id = R.color.violet_dark))
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_right_arrow_white),
                        contentDescription = "",
                        modifier = Modifier.size(15.dp,15.dp),
                        tint = Color.Unspecified

                    )
                }

            }

            Spacer(modifier = Modifier
                .fillMaxHeight()
                .width(15.dp)
                .background(color = colorResource(id = R.color.background))
                .zIndex(5f)
            )
        }
        if(isLastItem){
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(color = colorResource(id = R.color.background))
                .zIndex(5f)
            )
        }
    }
}

@Composable
fun customViewPagerSlider(context: Context) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
        //.padding(start = 15.dp, end = 15.dp, top = 15.dp),
    )
    {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(106.dp)
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
                Divider(
                    color = colorResource(id = R.color.un_selected_background_color),
                    modifier = Modifier
                        .fillMaxHeight()  //fill the max height
                        .width(1.dp)
                        .padding(top = 10.dp, bottom = 10.dp)
                )

                Column(
                    modifier = Modifier
                        .size(111.dp, 44.dp)
                        .border(
                            1.dp, colorResource(id = R.color.border_color),
                            RoundedCornerShape(11.dp)
                        )
                        .background(
                            color = colorResource(id = R.color.white),
                            RoundedCornerShape(11.dp)
                        )
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "VS",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontFamily = CustomFonts.manrope_semi_bold
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Stared 45:30",
                        style = TextStyle(
                            color = colorResource(id = R.color.violet_dark),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_semi_bold
                        ),
                        textAlign = TextAlign.Center,
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(27.dp)
                .padding(start = 20.dp, end = 20.dp)
                .background(
                    colorResource(id = R.color.border_color_yellow),
                    RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "1,982 Rooms Created",
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = CustomFonts.manrope_medium
            )
        }

    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPager() {

    fun createItems() = listOf(
        HorizontalPagerContent(title = "Title1", subtitle = "Subtitle1", description = "Description1"),
        HorizontalPagerContent(title = "Title2", subtitle = "Subtitle2", description = "Description2"),
        HorizontalPagerContent(title = "Title3", subtitle = "Subtitle3", description = "Description3"),
        HorizontalPagerContent(title = "Title4", subtitle = "Subtitle4", description = "Description4"),
        HorizontalPagerContent(title = "Title5", subtitle = "Subtitle5", description = "Description5")
    )

    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
    ) {
        val items = createItems()
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = items.size,
            state = pagerState,
            //modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                customViewPagerSlider(LocalContext.current)

            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        DotsIndicator(3,1)

//        val coroutineScope = rememberCoroutineScope()
//        Button(
//            onClick = {
//                coroutineScope.launch {
//                    pagerState.animateScrollToPage(page = 2)
//                }
//            },
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        ) {
//            Text(text = "Scroll to the third page")
//        }
    }
}

@Composable
fun TopRow(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        MyProfileImage()

        Spacer(modifier = Modifier.width(70.dp))

        Row(modifier = Modifier
            .border(
                1.dp, colorResource(id = R.color.border_color),
                RoundedCornerShape(8.dp)
            )
            .height(28.dp)
            , verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_profile_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "1,000",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_plus_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp, 16.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }

        Spacer(modifier = Modifier.width(5.dp))

        Row(modifier = Modifier
            .border(
                1.dp, colorResource(id = R.color.border_color),
                RoundedCornerShape(8.dp)
            )
            .height(28.dp)
            , verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_cup_star),
                contentDescription = "",
                modifier = Modifier
                    .size(18.dp, 18.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "8",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
        }

        Spacer(modifier = Modifier.width(5.dp))

        Row(modifier = Modifier
            .border(
                1.dp, colorResource(id = R.color.border_color),
                RoundedCornerShape(8.dp)
            )
            .height(28.dp)
            .clickable {
                navController.navigate(NavDestinations.COIN_CARD_BOTTOM_SHEET_SCREEN)
            }
            , verticalAlignment = Alignment.CenterVertically
        )
        {

            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "1,000",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_plus_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp, 16.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }

    }
}
@Composable
fun BottomNavigationBar(selectedMenu: MutableState<Int>, navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(28.dp, 28.dp, 0.dp, 0.dp)),
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_solar_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if(selectedMenu.value == 0) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                )
            },
            label = {
                Text(
                    text = "Home",
                    style = TextStyle(
                        color = if(selectedMenu.value == 0) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),

                    )
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
                    painter = painterResource(id = R.drawable.ic_number_1),
                    contentDescription = "Room",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if(selectedMenu.value == 1) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                )
            },
            label = {
                Text(
                    text = "Room",
                    style = TextStyle(
                        color = if(selectedMenu.value == 1) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
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

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_number_2),
                    contentDescription = "Room",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if(selectedMenu.value == 2) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                )
            },
            label = {
                Text(
                    text = "Room",
                    style = TextStyle(
                        color = if(selectedMenu.value == 2) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                )
            },
            selected = selectedMenu.value == 2,
            onClick = {
                navController.navigate(NavDestinations.ROOM_CREATION_SCREEN)
            //    selectedMenu.value = 2
            },
            alwaysShowLabel = true,
            selectedContentColor = colorResource(id = R.color.violet_dark),
            unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier.padding(bottom = 10.dp)
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_number_3),
                    contentDescription = "Room",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if(selectedMenu.value == 3) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                )
            },
            label = {
                Text(
                    text = "Room",
                    style = TextStyle(
                        color = if(selectedMenu.value == 3) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                )
            },
            selected = selectedMenu.value == 3,
            onClick = {
                navController.navigate(NavDestinations.ROOM_CREATED_SCREEN)
              //  selectedMenu.value = 3
            },
            alwaysShowLabel = true,
            selectedContentColor = colorResource(id = R.color.violet_dark),
            unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier.padding(bottom = 10.dp)
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_number_4),
                    contentDescription = "Room",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(bottom = 5.dp),
                    tint = if(selectedMenu.value == 4) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                )
            },
            label = {
                Text(
                    text = "Room",
                    style = TextStyle(
                        color = if(selectedMenu.value == 4) colorResource(R.color.violet_dark) else colorResource(R.color.un_selected_background_color),
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                )
            },
            selected = selectedMenu.value == 4,
            onClick = {
                navController.navigate(NavDestinations.GROUND_HOME_SCREEN)
        //        selectedMenu.value = 4
            },
            alwaysShowLabel = true,
            selectedContentColor = colorResource(id = R.color.violet_dark),
            unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

enum class ROOMTYPES{
    DirectPrediction,
    LiveRooms,
    CreateRoom,
    JoinRoom
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SuperTalkApplicationTheme {
        HomeScreen(rememberNavController())
    }
}