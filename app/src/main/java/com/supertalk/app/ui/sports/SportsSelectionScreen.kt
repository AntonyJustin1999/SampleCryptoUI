package com.supertalk.app.ui.sports

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
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
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations

val textImageList = listOf(
    Pair("Soccer", R.drawable.ic_soccer_ball1),
    Pair("BasketBall", R.drawable.ic_basketball),
    Pair("American Football", R.drawable.ic_aus_foodball),
    Pair("Australian Football", R.drawable.ic_aus_foodball),
    Pair("Cricket", R.drawable.ic_cricket_ball),
    Pair("Golf", R.drawable.ic_golf),
    Pair("Tennis", R.drawable.ic_tennis),
    Pair("Baseball", R.drawable.ic_baseball)
)

fun showToast(s: String) {

}

@Composable
fun SportsSelectionScreen(navController: NavController) {
    val wrongCode = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(NavDestinations.BASIC_INDRO_SLIDER_SCREEN)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_white),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    Row {
                        // Spacer to push the "Skip" text to the right end
                        Spacer(modifier = Modifier.weight(1f))
                        // "Skip" text
                        Text(
                            text = "Skip",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            // You can apply more styling here, like fontSize, fontWeight, etc.
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                }
            )
        }

    )
    {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colorResource(R.color.background)),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(220.dp)
                )
            }

            Text(
                text = "What’s your preferred sports?",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontFamily = CustomFonts.manrope_extra_bold
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp)
            )
            HorizontalTextImageList { selectedText ->
                // Handle the item selection here.
                // For example, you can show a toast or perform some other action
                // based on the selectedText.
                showToast("Selected: $selectedText")
            }

            Spacer(modifier = Modifier.weight(1f))

            Column {

                ButtonWithElevation(navController, wrongCode)

            }
        }
    }
}


@Composable
fun ButtonWithElevation(navController: NavController, wrongCode: MutableState<Boolean>) {

    Button(
        onClick = {
            wrongCode.value = true
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = colorResource(id = R.color.disabled_btn_color)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
            .height(50.dp)
            .coloredShadow(
                color = MaterialTheme.colors.primary,
                offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp
            ),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(
            text = "Next", style = TextStyle(
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_bold,
                color = Color.White
            )
        )
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalTextImageList(onItemSelected: (String) -> Unit) {
    val selectedImageIndex = remember { mutableStateOf(-1) }

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        content = {
            items(textImageList.size) { index ->
                val (text, imageResId) = textImageList[index]
                TextImageItem(
                    text = text,
                    imageResId = imageResId,
                    isSelected = index == selectedImageIndex.value,
                    onItemSelected = {
                        selectedImageIndex.value = index
                        onItemSelected(text)
                    }
                )
            }
        }
    )
}

@Composable
fun TextImageItem(
    text: String,
    imageResId: Int,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val greyscaleColorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
        setToSaturation(0.5f) // Apply greyscale transformation
    })

    val normalScaleColorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
        setToSaturation(1.0f) // Apply greyscale transformation
    })

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onItemSelected) // Make the item clickable
            .border(
                1.dp,
                if (isSelected) Color(0xFFEFA142) else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White,
        elevation = if (isSelected) 2.dp else 0.dp, // Apply elevation when selected
    ) {
        Column(
            modifier = Modifier
                .background(
                    color =
                    if (isSelected) Color.White else Color.White
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Align items vertically to the center
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(4.dp))
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .size(40.dp, 35.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                colorFilter = if (isSelected) normalScaleColorFilter else greyscaleColorFilter
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                color = if (isSelected) Color.Black else Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SportsSelectionScreenPreview() {
    SuperTalkApplicationTheme {
        SportsSelectionScreen(rememberNavController())
    }
}