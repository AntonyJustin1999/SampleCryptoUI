package com.supertalk.app.ui.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.model.SportsDataSet
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(navController: NavController) {

    val selectedMenu = remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = colorResource(R.color.background)))
    {

        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val padding = 4.dp

            MyProfileImage()

            Spacer(modifier = Modifier.width(70.dp))

            Row(modifier = Modifier.border(1.dp, colorResource(id = R.color.border_color),
                RoundedCornerShape(8.dp))
                , verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_union),
                    contentDescription = "",
                    modifier = Modifier
                        .size(23.dp, 23.dp)
                        .padding(start = padding, top = padding, bottom = padding)
                )
                Text(
                    text = "1,000",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = padding, top = padding, bottom = padding)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "",
                    modifier = Modifier
                        .size(23.dp, 23.dp)
                        .padding(
                            start = padding,
                            top = padding,
                            bottom = padding,
                            end = padding + 3.dp
                        )
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Row(modifier = Modifier.border(1.dp, colorResource(id = R.color.border_color),
                RoundedCornerShape(8.dp))
                , verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cup),
                    contentDescription = "",
                    modifier = Modifier
                        .size(23.dp, 23.dp)
                        .padding(start = padding, top = padding, bottom = padding)
                )
                Text(
                    text = "8",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = padding, top = padding, bottom = padding, end = padding+3.dp)
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Row(modifier = Modifier.border(1.dp, colorResource(id = R.color.border_color),
                RoundedCornerShape(8.dp))
                , verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin),
                    contentDescription = "",
                    modifier = Modifier
                        .size(23.dp, 23.dp)
                        .padding(start = padding, top = padding, bottom = padding)
                )
                Text(
                    text = "1,000",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = padding, top = padding, bottom = padding)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "",
                    modifier = Modifier
                        .size(23.dp, 23.dp)
                        .padding(
                            start = padding,
                            top = padding,
                            bottom = padding,
                            end = padding + 3.dp
                        )
                )
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
                        painter = painterResource(id = R.drawable.ic_vector),
                        contentDescription = "Home",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(bottom = 5.dp)
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
                        painter = painterResource(id = R.drawable.ic_box),
                        contentDescription = "Room",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(bottom = 5.dp)
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
                        painter = painterResource(id = R.drawable.ic_box),
                        contentDescription = "Room",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(bottom = 5.dp)
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
                        painter = painterResource(id = R.drawable.ic_box),
                        contentDescription = "Room",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(bottom = 5.dp)
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
        }

    }
}

@Composable
private fun MyProfileImage() {
    Box(
        modifier = Modifier.size(50.dp,50.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.test_profile),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(50.dp, 50.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(width = 2.dp, Color.White, shape = RoundedCornerShape(12.dp)),
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_discount),
            tint = colorResource(id = R.color.violet_dark),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset {
                    IntOffset(x = 20, y = -20)
                }
                .size(21.dp, 21.dp)

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
                painter = painterResource(id = R.drawable.ic_discount),
                tint = colorResource(id = R.color.violet_dark),
                contentDescription = "",
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun customListView(context: Context) {
    // in the below line, we are creating and
    // initializing our array list
    lateinit var sportsList: List<SportsDataSet>
    sportsList = ArrayList<SportsDataSet>()

    // in the below line, we are adding data to our list.
    sportsList = sportsList + SportsDataSet("Soccer", R.drawable.ic_soccer)
    sportsList = sportsList + SportsDataSet("Football", R.drawable.ic_football)
    sportsList = sportsList + SportsDataSet("Basketball", R.drawable.ic_basketball)
    sportsList = sportsList + SportsDataSet("Cricket", R.drawable.ic_cricket)

    // in the below line, we are creating a
    // lazy row for displaying a horizontal list view.
    LazyRow {
        // in the below line, we are setting data for each item of our listview.
        itemsIndexed(sportsList) { index, item ->
            // in the below line, we are creating a card for our list view item.
            Card(
                // inside our grid view on below line
                // we are adding on click for each item of our grid view.
                onClick = {
                    // inside on click we are displaying the toast message.
                    Toast.makeText(
                        context,
                        sportsList[index].sportsName + " selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                // in the below line, we are adding
                // padding from our all sides.
                modifier = Modifier
                    .padding(8.dp)
                    .width(83.dp)
                    .height(85.dp)
                    .border(2.dp, colorResource(id = R.color.border_color1), shape = RoundedCornerShape (16.dp))
                , shape = RoundedCornerShape(16.dp)

                
            )
            {
                // in the below line, we are creating
                // a row for our list view item.
                Column(
                    // for our row we are adding modifier
                    // to set padding from all sides.
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // in the below line, inside row we are adding spacer
                    Spacer(modifier = Modifier.height(3.dp))

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
                            .width(29.dp)
                            .padding(5.dp),

                        alignment = Alignment.Center
                    )

                    // in the below line, we are adding spacer between image and a text
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = sportsList[index].sportsName,

                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_extra_bold
                        ),
                        modifier = Modifier.padding(4.dp),

                        // in the below line, we are adding color for our text
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SuperTalkApplicationTheme {
        HomeScreen(rememberNavController())
    }
}