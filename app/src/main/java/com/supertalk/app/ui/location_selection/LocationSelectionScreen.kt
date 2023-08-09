package com.supertalk.app.ui.location_selection

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import androidx.compose.animation.AnimatedVisibility as AnimatedVisibility


@Composable
fun LocationSelectionScreen(navController: NavController) {
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
                text = "Where Are You From?",
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

           RoundedCornerBoxWithAnimatedDropDown()

            Spacer(modifier = Modifier.weight(1f))

            Column {

                ButtonWithElevation(navController)

            }
        }
    }
}


@Composable
fun ButtonWithElevation(navController: NavController) {

    Button(
        onClick = {
            navController.navigate(NavDestinations.ACCOUNT_CREATION_SUCCESS_SCREEN)
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RoundedCornerBoxWithAnimatedDropDown() {
    val countries = listOf(
        "India",
        "Saudi Arabia",
        "United States",
        "France",
        "Japan"
    ) // Add more countries as needed

    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(countries[0]) }

    Surface(
        modifier = Modifier
            .height(90.dp)
            .padding(
                horizontal = 16.dp, vertical = 16.dp
            ), // Set the height
        shape = RoundedCornerShape(16.dp),
        color = Color.White // Set the background color of the Surface to white
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left Side ImageView
            Image(
                painter = painterResource(id = R.drawable.ic_flag), // Replace with the correct resource ID for the country flag
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

            // Center TextView
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = selectedItem,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .clickable { expanded = !expanded }
                        .padding(horizontal = 16.dp)
                        .align(alignment = Alignment.Center)
                )

                this@Row.AnimatedVisibility(
                    visible = expanded,
                    enter = fadeIn() + expandIn(),
                    exit = fadeOut() + shrinkOut()
                ) {
                    DropdownMenu(
                        expanded = true,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        countries.forEach { country ->
                            DropdownMenuItem(onClick = {
                                expanded = false
                                selectedItem = country
                            }) {
                                Text(country)
                            }
                        }
                    }
                }
            }

            // ... other content

            Surface(
                modifier = Modifier,
                shape = RoundedCornerShape(16.dp),
                color = colorResource(R.color.violet_dark)
            ) {
                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dropdown),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}


@Composable
fun RoundedCornerBoxWithImageTextSlidingDropDownPreview() {
    val density = LocalDensity.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(color = Color.White) {
            RoundedCornerBoxWithAnimatedDropDown()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LocationSelectionScreenPreview() {
    SuperTalkApplicationTheme {
        LocationSelectionScreen(rememberNavController())
    }
}