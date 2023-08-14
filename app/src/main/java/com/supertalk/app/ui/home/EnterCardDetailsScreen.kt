package com.supertalk.app.ui.home

import android.util.Log
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.max
import androidx.compose.ui.zIndex
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.min
@Composable
fun EnterCardDetailsScreen(navController: NavController) {

    val isPay = remember { mutableStateOf(true) }
    val checkedState = remember { mutableStateOf(true) }
    val cardNo = remember { mutableStateOf("4007 2777 2891 9009") }
    val cvv = remember { mutableStateOf("123") }
    val expiry = remember { mutableStateOf("26/33") }
    val name = remember { mutableStateOf("Harish Vishwakarma") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                        , horizontalArrangement = Arrangement.Center){
                        Text(
                            text = "Enter Card Details",
                            modifier = Modifier
                                .fillMaxWidth(0.5f),
                            textAlign = TextAlign.Start,
                            fontFamily = CustomFonts.manrope_semi_bold,
                            fontSize = 15.sp,
                            color = Color.White,
                        )
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

        // Main content of the screen
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .background(color = colorResource(R.color.background)),
            ) {

                getSpacerHeight(20)
                getCardNumberContainer("CardNo.",cardNo)
                getSpacerHeight(10)
                getCVVContainer("CVV",cvv)
                getSpacerHeight(10)
                getExpiryContainer("Expiry",expiry)
                getSpacerHeight(10)
                getNameContainer("Name",name)
                //getSpacerHeight(10)
                getCheckBox("Save Card",checkedState)

            }
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                Column {
                    getCardListRowUI(navController = navController)
                    getSpacerHeight(20)
                    ButtonWithElevation(navController, isPay)
                    getSpacerHeight(20)
                }
            }
        }

    }
}

@Composable
fun getCardListRowUI(navController: NavController){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            navController.navigate(NavDestinations.SELECT_CARD_SCREEN)
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {

        getSpacerWidth(10)
        Icon(
            painter = painterResource(id = R.drawable.mada_logo),
            contentDescription = "",
            modifier = Modifier
                .size(47.dp, 16.dp),
            tint = Color.Unspecified,
        )
        getSpacerWidth(10)
        Icon(
            painter = painterResource(id = R.drawable.master_card_logo),
            contentDescription = "",
            modifier = Modifier
                .size(36.dp, 20.dp),
            tint = Color.Unspecified,
        )
        getSpacerWidth(10)
        Icon(
            painter = painterResource(id = R.drawable.visa_card_logo),
            contentDescription = "",
            modifier = Modifier
                .size(47.dp, 14.dp),
            tint = Color.Unspecified,
        )
        getSpacerWidth(10)
        Icon(
            painter = painterResource(id = R.drawable.pci_dss_logo),
            contentDescription = "",
            modifier = Modifier
                .size(43.dp, 20.dp),
            tint = Color.Unspecified,
        )
    }
}

@Composable
private fun getCardNumberContainer(label:String,text_value:MutableState<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp) // Adjust height as needed
            .padding(start = 16.dp, end = 16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {

            Text(
                text = label,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_medium,
                modifier = Modifier.padding(start = 16.dp).fillMaxWidth(0.2f),
                color = colorResource(id = R.color.text_color)
            )
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .width(1.dp)
                    .height(26.dp)
            )

            TextField(
                modifier = Modifier.fillMaxWidth(1.8f),
                value = text_value.value,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    cursorColor = Color.Black,
                    //disabledLabelColor = lightBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {
                    text_value.value = it
                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.manrope_bold,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}

@Composable
private fun getCVVContainer(label:String,text_value:MutableState<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp) // Adjust height as needed
            .padding(start = 16.dp, end = 16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 5.dp)
        ) {

            Text(
                text = label,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_medium,
                modifier = Modifier.padding(start = 16.dp).fillMaxWidth(0.2f),
                color = colorResource(id = R.color.text_color)
            )
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .width(1.dp)
                    .height(26.dp)
            )

            TextField(
                modifier = Modifier,
                value = text_value.value,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    cursorColor = Color.White,
                    //disabledLabelColor = lightBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {

                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.manrope_bold,
                    textAlign = TextAlign.Start
                )
            )
            Spacer(modifier = Modifier.width(80.dp))

        }
    }
}

@Composable
private fun getExpiryContainer(label:String,text_value:MutableState<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp) // Adjust height as needed
            .padding(start = 16.dp, end = 16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 5.dp)
        ) {

            Text(
                text = label,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_medium,
                modifier = Modifier.padding(start = 16.dp).fillMaxWidth(0.2f),
                color = colorResource(id = R.color.text_color)
            )
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .width(1.dp)
                    .height(26.dp)
            )

            TextField(
                modifier = Modifier,
                value = text_value.value,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    cursorColor = Color.White,
                    //disabledLabelColor = lightBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {

                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.manrope_bold,
                    textAlign = TextAlign.Start
                )
            )
            Spacer(modifier = Modifier.width(80.dp))

        }
    }
}

@Composable
private fun getNameContainer(label:String,text_value:MutableState<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp) // Adjust height as needed
            .padding(start = 16.dp, end = 16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 5.dp)
        ) {

            Text(
                text = label,
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_medium,
                modifier = Modifier.padding(start = 16.dp).fillMaxWidth(0.2f),
                color = colorResource(id = R.color.text_color)
            )
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .width(1.dp)
                    .height(26.dp)
            )

            TextField(
                modifier = Modifier,
                value = text_value.value,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    cursorColor = Color.White,
                    //disabledLabelColor = lightBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {

                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = CustomFonts.manrope_bold,
                    textAlign = TextAlign.Start
                )
            )
            Spacer(modifier = Modifier.width(80.dp))

        }
    }
}
@Composable
fun ButtonWithElevation(navController: NavController,isPayValidation:MutableState<Boolean>) {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            isPayValidation.value = true
            scope.launch {
                delay(2000) // Introduce a 2-second delay using delay() function
                navController.navigate(NavDestinations.SPORTS_SELECTION_SCREEN)
            }

        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = colorResource(id = R.color.disabled_btn_color)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .height(50.dp)
            .coloredShadow(
                color = MaterialTheme.colors.primary,
                offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp
            ),
        shape = RoundedCornerShape(14.dp),
        enabled = isPayValidation.value
    ) {
        Text(text = "Pay",style = TextStyle(
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_bold,
            color = Color.White
        ))
    }

}

@Composable
private fun getCheckBox(label:String,checkedState:MutableState<Boolean>) {
    Row(modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            text = label,
            fontSize = 14.sp,
            fontFamily = CustomFonts.manrope_semi_bold,
            modifier = Modifier,
            color = colorResource(id = R.color.black),
            textAlign = TextAlign.Start
        )
    }

}

@Composable
private fun getSpacerHeight(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
private fun getSpacerWidth(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}

@Preview(showBackground = true)
@Composable
fun EnterCardDetailsScreenPreview() {
    SuperTalkApplicationTheme {
        EnterCardDetailsScreen(rememberNavController())
    }
}