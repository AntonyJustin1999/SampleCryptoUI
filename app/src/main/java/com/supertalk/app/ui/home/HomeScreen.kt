package com.supertalk.app.ui.home

import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.supertalk.app.R
import com.supertalk.app.model.HorizontalPagerContent
import com.supertalk.app.model.SportsDataSet
import com.supertalk.app.ui.basic_intro_slider.DotsIndicator
import com.supertalk.app.ui.customwidget.RightBubbleShape
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {

    val selectedMenu = remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
    )
    {

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
                    tint = colorResource(id = R.color.border_color_yellow)
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
                        .size(16.dp, 16.dp)
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
                            tint = colorResource(id = R.color.border_color_yellow)
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
                , verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp, 20.dp),
                    tint = colorResource(id = R.color.border_color_yellow)
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
                        .size(16.dp, 16.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
            }

        }

        Text(
            text = "Sports",
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_extra_bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 16.dp, top = 10.dp)
        )

        customListView(LocalContext.current)


        Text(
            text = "Today's Hot Matches",
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_extra_bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

        //customViewPagerSlider(LocalContext.current)


        HorizontalPagerScreen()

        Spacer(modifier = Modifier.padding(top = 15.dp))

        Divider(
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .fillMaxWidth()  //fill the max height
                .width(1.dp)
        )

        Spacer(modifier = Modifier.padding(top = 15.dp))

        customCurveLayout(LocalContext.current)

        Spacer(modifier = Modifier.padding(top = 10.dp))

        //customCurveLayout(LocalContext.current)


        Spacer(modifier = Modifier.weight(1f))


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
                    selectedMenu.value = 3
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
                    selectedMenu.value = 4
                },
                alwaysShowLabel = true,
                selectedContentColor = colorResource(id = R.color.violet_dark),
                unselectedContentColor = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }

    }
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

//        Button(
//            modifier = Modifier.align(Alignment.TopEnd)
//                .offset {
//                    IntOffset(x =30, y = -30)
//                },
//            onClick = {}
//        ) {
//            Text("A Button")
//        }
    }
}

@Composable
private fun MyProfileImage1() {

    val iconSize = 96.dp
    val offsetInPx = LocalDensity.current.run { (iconSize / 2).roundToPx() }

    Box(modifier = Modifier.padding((iconSize / 2))) {

        Card {
            Image(
                painter = painterResource(id = R.drawable.test_profile),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(54.dp, 54.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(width = 2.dp, Color.White, shape = RoundedCornerShape(12.dp)),
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .offset {
                    IntOffset(x = +offsetInPx, y = -offsetInPx)
                }
                .size(iconSize)
                .align(Alignment.TopEnd)
                .padding(top = 15.dp, end = 15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_discount_tick),
                tint = colorResource(id = R.color.violet_dark),
                contentDescription = "",
            )
        }
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

    LazyRow(modifier = Modifier.padding(start = 16.dp, top = 10.dp, end = 16.dp)) {
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

@Composable
fun customCurveLayout(context: Context) {
    Box(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .fillMaxWidth()
            .height(102.dp)
            .background(Color.White, RoundedCornerShape(18.dp)),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "Direct Prediction",

            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_bold
            ),
            modifier = Modifier,

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
                modifier = Modifier.size(18.dp,18.dp),
                tint = Color.Unspecified

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

                Column(modifier = Modifier
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
                )
            ,verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.Center
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

@Composable
fun customLayout(context: Context) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        val shape = GenericShape { size: Size, layoutDirection: LayoutDirection ->
            val width = size.width
            val height = size.height

            addArc(
                oval = Rect(
                    offset = Offset.Zero,
                    size = Size(height, height)
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 180f,
            )
            lineTo(width, 0f)
            lineTo(width, height)
            lineTo(height, height)

        }

        Box(
            modifier = Modifier
                .size(300.dp, 100.dp)
                .clip(shape)
                .drawWithContent {

                    val width = size.width
                    val height = size.height
                    // Change this as required, ra
                    val radius = 80f


                    with(drawContext.canvas.nativeCanvas) {
                        val checkPoint = saveLayer(null, null)
                        // Destination
                        drawContent()

                        // Source
                        drawArc(
                            color = Color.Transparent,
                            startAngle = 90f,
                            sweepAngle = 180f,
                            topLeft = Offset(
                                width - radius, 0f
                            ),
                            size = Size(2 * radius, height),
                            useCenter = false,
                            blendMode = BlendMode.SrcOut
                        )
                        restoreToCount(checkPoint)
                    }
                }
                .background(Color.Green)
                .clickable {

                }
        )
    }

}

@Composable
fun MessageBox(message: String) {
    val cornerShape = with(LocalDensity.current) { 16.dp.toPx() }
    val arrowWidth = with(LocalDensity.current) { 8.dp.toPx() }
    val arrowHeight = with(LocalDensity.current) { 12.dp.toPx() }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 46.dp, start = 10.dp),
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .drawRightBubble(
                    cornerShape = cornerShape,
                    arrowWidth = arrowWidth,
                    arrowHeight = arrowHeight,
                    bubbleColor = Color.Green
                )
        ) {
            Text(
                text = message,
                modifier = Modifier.padding(8.dp),
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

fun Modifier.drawRightBubble(
    bubbleColor: Color,
    cornerShape: Float,
    arrowWidth: Float,
    arrowHeight: Float
) = then(
    background(
        color = bubbleColor,
        shape = RightBubbleShape(
            cornerShape = cornerShape,
            arrowWidth = arrowWidth,
            arrowHeight = arrowHeight
        )
    )
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {

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


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SuperTalkApplicationTheme {
        HomeScreen(rememberNavController())
    }
}