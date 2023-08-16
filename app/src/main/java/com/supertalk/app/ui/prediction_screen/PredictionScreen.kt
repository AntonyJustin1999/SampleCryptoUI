package com.supertalk.app.ui.prediction_screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
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


@Composable
fun PredictionScreen(navController: NavController) {
    var title = "Select Your Prediction"
    val context = LocalContext.current

    Scaffold(
        backgroundColor = colorResource(R.color.background),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = title,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_bold
                            ),
                            modifier = Modifier.wrapContentWidth()
                        )
                        IconButton(onClick = { /* Handle icon click */ }) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_attention),
                                contentDescription = "Forward",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        ClickableText(
                            text = AnnotatedString("Skip"),
                            onClick = {
                                // Handle skip click
                            },
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_bold
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(0.2f)
                                .wrapContentWidth(Alignment.End)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation click */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )


        }
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                getSubTitle("Predict Match Result")
                getHeight(height = 10)
                PredictMatchResultWidget(context)
                getHeight(height = 16)
                getSubTitle(title = "Predict Result Per Half")
                getHeight(height = 10)
                PredictMatchResultPerHalfWidget(context)
                getHeight(height = 16)
                getSubTitle(title = "Predict Goal Scorers")
                getHeight(height = 10)
                PredictMatchGoalScorersWidget(context)
                getHeight(height = 16)
                getSubTitle(title = "Predict Cards")
                getHeight(height = 10)
                PredictMatchCardsWidget(context)
                getHeight(height = 16)
                getSubTitle(title = "Predict Squad")
                getHeight(height = 10)
                PredictSquadWidget(context)
                getHeight(height = 16)
                ButtonWithElevation(
                    navController,
                    "NEXT"
                )
                getHeight(height = 10)
            }
        }
    }
}

@Composable
private fun getHeight(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun PredictMatchResultWidget(context: Context) {
    val contextForToast = LocalContext.current.applicationContext

    var sliderValue by remember {
        mutableStateOf(0f) // pass the initial value
    }
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
        //.padding(start = 15.dp, end = 15.dp, top = 15.dp),
    )
    {

        Column() {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
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
        }
        Divider(
            color = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier
                .fillMaxWidth()  //fill the max height
                .height(1.dp)
                .padding(start = 10.dp, end = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Set Tokens",
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "3,000",
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(
                    color = Color(0xff7553C5),
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 13.dp)
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Column(
            modifier = Modifier.background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Slider(
                    value = sliderValue,
                    onValueChange = { newValue ->
                        sliderValue = newValue
                    },
                    onValueChangeFinished = {
                        Toast.makeText(
                            contextForToast,
                            "sliderValue = $sliderValue",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    valueRange = 1f..10f,
                    steps = 0
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "10",
                    style = TextStyle(
                        color = Color(0xff7C8396),
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_regular
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(20.dp, 20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "1,000",
                    style = TextStyle(
                        color = Color(0xff7C8396),
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_regular
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(20.dp, 20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
            }

            /*   Text(text = "sliderValue = $sliderValue")*/
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Get If Correct",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "8,000",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 5.dp)
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .background(
                    colorResource(id = R.color.white),
                    RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        }

    }
}


@Composable
fun PredictMatchResultPerHalfWidget(context: Context) {
    val contextForToast = LocalContext.current.applicationContext

    var sliderValue by remember {
        mutableStateOf(0f) // pass the initial value
    }
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
        //.padding(start = 15.dp, end = 15.dp, top = 15.dp),
    )
    {

        Column() {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
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
                        Column() {
                            Row(
                                modifier = Modifier
                                    .size(72.dp, 38.dp)
                                    .padding(all = 2.dp)
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

                            Row(
                                modifier = Modifier
                                    .size(72.dp, 38.dp)
                                    .padding(all = 2.dp)
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
        }
        Divider(
            color = colorResource(id = R.color.un_selected_background_color),
            modifier = Modifier
                .fillMaxWidth()  //fill the max height
                .height(1.dp)
                .padding(start = 10.dp, end = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Set Tokens",
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "3,000",
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(
                    color = Color(0xff7553C5),
                    fontSize = 18.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 13.dp)
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Column(
            modifier = Modifier.background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Slider(
                    value = sliderValue,
                    onValueChange = { newValue ->
                        sliderValue = newValue
                    },
                    onValueChangeFinished = {
                        Toast.makeText(
                            contextForToast,
                            "sliderValue = $sliderValue",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    valueRange = 1f..10f,
                    steps = 0
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "10",
                    style = TextStyle(
                        color = Color(0xff7C8396),
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_regular
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(20.dp, 20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "1,000",
                    style = TextStyle(
                        color = Color(0xff7C8396),
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_regular
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(20.dp, 20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
            }

            /*   Text(text = "sliderValue = $sliderValue")*/
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Get If Correct",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "8,000",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 5.dp)
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .background(
                    colorResource(id = R.color.white),
                    RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        }

    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PredictMatchGoalScorersWidget(context: Context) {
    val contextForToast = LocalContext.current.applicationContext

    var sliderValue by remember {
        mutableStateOf(0f) // pass the initial value
    }
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
        //.padding(start = 15.dp, end = 15.dp, top = 15.dp),
    )
    {

        Column(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp)),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.test_barcelona),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Transparent

                        ),
                    alignment = Alignment.CenterStart
                )
                Text(
                    text = "Barcelona",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    )
                )
                Spacer(modifier = Modifier.weight(1f))

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(8.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xff623CBB)
                            )
                            .height(35.dp)
                            .width(35.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        Image(
                            painter = painterResource(
                                id =
                                (R.drawable.ic_arrow)
                            ),
                            contentDescription = "Sample Image",
                            modifier = Modifier
                                .size(25.dp), contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    }

                }

            }
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(5.dp)
                    .background(
                        Color.White
                    )
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 50.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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

        Column(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp)),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.test_barcelona),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Transparent

                        ),
                    alignment = Alignment.CenterStart
                )
                Text(
                    text = "Barcelona",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    )
                )
                Spacer(modifier = Modifier.weight(1f))

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(8.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xff623CBB)
                            )
                            .height(35.dp)
                            .width(35.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        Image(
                            painter = painterResource(
                                id =
                                (R.drawable.ic_arrow)
                            ),
                            contentDescription = "Sample Image",
                            modifier = Modifier
                                .size(25.dp), contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    }

                }

            }
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(5.dp)
                    .background(
                        Color.White
                    )
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 50.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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

        Column(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp)),
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Set Tokens",
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "3,000",
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = Color(0xff7553C5),
                        fontSize = 18.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 13.dp)
                        .size(20.dp, 20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
            Column(
                modifier = Modifier.background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Slider(
                        value = sliderValue,
                        onValueChange = { newValue ->
                            sliderValue = newValue
                        },
                        onValueChangeFinished = {
                            Toast.makeText(
                                contextForToast,
                                "sliderValue = $sliderValue",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        },
                        valueRange = 1f..10f,
                        steps = 0
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "10",
                        style = TextStyle(
                            color = Color(0xff7C8396),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_regular
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coin_yellow),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(20.dp, 20.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "1,000",
                        style = TextStyle(
                            color = Color(0xff7C8396),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_regular
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coin_yellow),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(20.dp, 20.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }

                /*   Text(text = "sliderValue = $sliderValue")*/
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Get If Correct",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "8,000",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 5.dp)
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .background(
                    colorResource(id = R.color.white),
                    RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PredictMatchCardsWidget(context: Context) {
    val contextForToast = LocalContext.current.applicationContext

    var sliderValue by remember {
        mutableStateOf(0f) // pass the initial value
    }
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
    )
    {

        Column(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.test_barcelona),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Transparent

                        ),
                    alignment = Alignment.CenterStart
                )
                Text(
                    text = "Barcelona",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    )
                )

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(5.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xffEC5C4D)
                            )
                            .height(38.dp)
                            .width(28.dp)
                    )

                }
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.light_background),
                                RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            ),
                            text = "2",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            textAlign = TextAlign.End,
                        )
                    }


                }
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(5.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xffEFA142)
                            )
                            .height(38.dp)
                            .width(28.dp)
                    )

                }
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.light_background),
                                RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            ),
                            text = "2",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            textAlign = TextAlign.End,
                        )
                    }


                }
                Spacer(modifier = Modifier.width(width = 10.dp))

            }
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.test_real_madrid),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Transparent

                        ),
                    alignment = Alignment.CenterStart
                )
                Text(
                    text = "Real Madrid",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    )
                )

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(5.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xffEC5C4D)
                            )
                            .height(38.dp)
                            .width(28.dp)
                    )

                }
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.light_background),
                                RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            ),
                            text = "2",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            textAlign = TextAlign.End,
                        )
                    }


                }
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(5.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xffEFA142)
                            )
                            .height(38.dp)
                            .width(28.dp)
                    )

                }
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.light_background),
                                RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            ),
                            text = "2",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            textAlign = TextAlign.End,
                        )
                    }


                }
                Spacer(modifier = Modifier.width(width = 10.dp))

            }

            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )

            Column(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .background(Color.White),
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth()
                        .background(
                            Color.White,
                            RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Set Tokens",
                        modifier = Modifier.padding(top = 10.dp),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontFamily = CustomFonts.manrope_semi_bold
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "3,000",
                        modifier = Modifier.padding(top = 10.dp),
                        style = TextStyle(
                            color = Color(0xff7553C5),
                            fontSize = 18.sp,
                            fontFamily = CustomFonts.manrope_semi_bold
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coin_yellow),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 13.dp)
                            .size(20.dp, 20.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
                Column(
                    modifier = Modifier.background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Slider(
                            value = sliderValue,
                            onValueChange = { newValue ->
                                sliderValue = newValue
                            },
                            onValueChangeFinished = {
                                Toast.makeText(
                                    contextForToast,
                                    "sliderValue = $sliderValue",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            },
                            valueRange = 1f..10f,
                            steps = 0
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "10",
                            style = TextStyle(
                                color = Color(0xff7C8396),
                                fontSize = 14.sp,
                                fontFamily = CustomFonts.manrope_regular
                            ),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_coin_yellow),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .size(20.dp, 20.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "1,000",
                            style = TextStyle(
                                color = Color(0xff7C8396),
                                fontSize = 14.sp,
                                fontFamily = CustomFonts.manrope_regular
                            ),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_coin_yellow),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .size(20.dp, 20.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                    /*   Text(text = "sliderValue = $sliderValue")*/
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Get If Correct",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "8,000",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 5.dp)
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .background(
                    colorResource(id = R.color.white),
                    RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PredictSquadWidget(context: Context) {
    val contextForToast = LocalContext.current.applicationContext

    var sliderValue by remember {
        mutableStateOf(0f) // pass the initial value
    }
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
        //.padding(start = 15.dp, end = 15.dp, top = 15.dp),
    )
    {

        Column(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp)),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.test_barcelona),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Transparent

                        ),
                    alignment = Alignment.CenterStart
                )
                Text(
                    text = "Barcelona",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    )
                )
                Spacer(modifier = Modifier.weight(1f))

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(8.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xff623CBB)
                            )
                            .height(35.dp)
                            .width(35.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        Image(
                            painter = painterResource(
                                id =
                                (R.drawable.ic_arrow)
                            ),
                            contentDescription = "Sample Image",
                            modifier = Modifier
                                .size(25.dp), contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    }

                }

            }
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(5.dp)
                    .background(
                        Color.White
                    )
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 25.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 25.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 25.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Formation",
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = Color(0xff7C8396),
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.light_background),
                                RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            ),
                            text = "4-4-2",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            textAlign = TextAlign.End,
                        )
                    }


                }
                Spacer(modifier = Modifier.width(5.dp))
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp)),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.test_real_madrid),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Transparent

                        ),
                    alignment = Alignment.CenterStart
                )
                Text(
                    text = "Real Madrid",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    )
                )
                Spacer(modifier = Modifier.weight(1f))

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentSize(), // Make the item clickable
                    shape = RoundedCornerShape(8.dp),
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xff623CBB)
                            )
                            .height(35.dp)
                            .width(35.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        Image(
                            painter = painterResource(
                                id =
                                (R.drawable.ic_arrow)
                            ),
                            contentDescription = "Sample Image",
                            modifier = Modifier
                                .size(25.dp), contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    }

                }

            }
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(5.dp)
                    .background(
                        Color.White
                    )
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 25.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 25.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
                Spacer(modifier = Modifier.width(width = 25.dp))
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // in the below line, we are adding Image to display the image.
                    Image(
                        // in the below line, we are specifying the drawable image for our image.
                        painter = painterResource(id = R.drawable.ic_test_messi),
                        contentDescription = "img",
                        modifier = Modifier.size(30.dp),
                        alignment = Alignment.Center
                    )

                    Text(
                        text = "Messi",

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
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(1.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Formation",
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = Color(0xff7C8396),
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.light_background),
                                RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            ),
                            text = "4-4-2",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            textAlign = TextAlign.End,
                        )
                    }


                }
                Spacer(modifier = Modifier.width(5.dp))
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp)),
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Set Tokens",
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "3,000",
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = Color(0xff7553C5),
                        fontSize = 18.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 13.dp)
                        .size(20.dp, 20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
            Column(
                modifier = Modifier.background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Slider(
                        value = sliderValue,
                        onValueChange = { newValue ->
                            sliderValue = newValue
                        },
                        onValueChangeFinished = {
                            Toast.makeText(
                                contextForToast,
                                "sliderValue = $sliderValue",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        },
                        valueRange = 1f..10f,
                        steps = 0
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "10",
                        style = TextStyle(
                            color = Color(0xff7C8396),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_regular
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coin_yellow),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(20.dp, 20.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "1,000",
                        style = TextStyle(
                            color = Color(0xff7C8396),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_regular
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coin_yellow),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(20.dp, 20.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Get If Correct",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "8,000",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontFamily = CustomFonts.manrope_semi_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_coin_yellow),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 5.dp)
                    .size(20.dp, 20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .background(
                    colorResource(id = R.color.white),
                    RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonWithElevation(
    navController: NavController,
    tittle: String
) {
    Button(
        onClick = {
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
            .height(50.dp),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(
            text = tittle, style = TextStyle(
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_bold,
                color = Color.White
            )
        )
    }

}


@Composable
private fun getSubTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontFamily = CustomFonts.manrope_bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun PredictionScreenPreview() {
    SuperTalkApplicationTheme {
        PredictionScreen(rememberNavController())
    }
}