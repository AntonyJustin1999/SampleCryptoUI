package com.supertalk.app.ui.basic_intro_slider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations

@Composable
fun BasicIntroSliderScreen(navController: NavController) {

    var titleList = arrayOf<String>("Title1","Title2","Title3")
    var contentList = arrayOf<String>("You will receive your amount within 3-5 business days(dummy) - 1"
        ,"You will receive your amount within 3-5 business days(dummy) - 2"
        ,"You will receive your amount within 3-5 business days(dummy) - 3")

    val mPageCount = remember { mutableStateOf(0)}
    val mTitleList = remember { mutableStateOf(titleList)}
    val mContentList = remember { mutableStateOf(contentList)}


    Scaffold(
        topBar = {
            //if(mPageCount.value > 0){
                TopAppBar(
                    title = {
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                        , horizontalArrangement = Arrangement.End){
                            Spacer(Modifier.weight(0.50f).fillMaxHeight())
                            ClickableText(
                                text = AnnotatedString("Skip") ,
                                onClick = {
                                    navController.navigate(NavDestinations.REGISTRATION_OTP_SCREEN)
                                }
                                ,style = TextStyle(
                                    color = colorResource(R.color.white),
                                    fontSize = 17.sp,
                                    fontFamily = CustomFonts.manrope_bold
                                ),
                                modifier = Modifier.align(Alignment.CenterVertically).weight(0.10f)
                            )
                        }

                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            if(mPageCount.value>0){
                                mPageCount.value -= 1
                            }
                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_white), contentDescription = null)
                        }
                    }
                )
            //}
        }
    )
    {
        Column(
            Modifier.fillMaxHeight().background(color = colorResource(R.color.background)),
            verticalArrangement = Arrangement.Bottom,
        ) {

            Column {

                Text(
                    text = mTitleList.value[mPageCount.value],
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )

                Text(
                    text = mContentList.value[mPageCount.value],
                    style = TextStyle(
                        color = colorResource(R.color.text_color),
                        fontSize = 18.sp,
                        fontFamily = CustomFonts.manrope_semi_bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp,bottom = 60.dp,start = 13.dp, end = 13.dp)
                )

                DotsIndicator(3,mPageCount.value)

                ButtonWithElevation(navController,mPageCount)

            }
        }
    }
}

@Composable
fun DotsIndicator(totalDots: Int, selectedIndex: Int) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.primary)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color = Color.White)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
fun ButtonWithElevation(navController: NavController,mPageCount : MutableState<Int>) {

    Button(onClick = {
        if(mPageCount.value<2){
            mPageCount.value += 1
        } else{
            if(mPageCount.value >= 2){
                navController.navigate(NavDestinations.REGISTRATION_OTP_SCREEN)
                //navController.navigate(NavDestinations.LOGIN_SCREEN)
            }
        }
    },elevation =  ButtonDefaults.elevation(
        defaultElevation = 15.dp,
    ), modifier = Modifier.fillMaxWidth()
        .padding(top = 35.dp,bottom = 30.dp,start = 13.dp, end = 13.dp)
        .height(50.dp)
        .coloredShadow(color = MaterialTheme.colors.primary,
            offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(text = "Next",style = TextStyle(
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_bold
        ),)
    }

}

fun Modifier.coloredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp) = composed {
    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha= 0f).toArgb()
    this.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparent
            frameworkPaint.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
            )
            it.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                borderRadius.toPx(),
                borderRadius.toPx(),
                paint
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BasicIntroSliderPreview() {
    SuperTalkApplicationTheme {
        BasicIntroSliderScreen(rememberNavController())
    }
}