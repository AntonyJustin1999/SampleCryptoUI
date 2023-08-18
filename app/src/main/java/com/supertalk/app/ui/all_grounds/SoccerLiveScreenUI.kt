package com.supertalk.app.ui.all_grounds

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts

data class LiveEventDataSet(val message:Message,val time:String,val isDirectionLeft:Boolean)
data class Message(val img_event: Int,val title: String,val content:String?,val background:Color)
@Composable
fun SoccerLiveScreenUI(navController: NavController) {
    liveEventView()
}

@Composable
fun RowItem(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = Color.Gray,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            repeat((1..4).random()) {
                Text(
                    text = "item $it",
                    color = Color.White,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 4.dp
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // this is required to push below composables to bottom

            Button(onClick = {
            }) { Text(text = "Button") }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun liveEventView() {

    lateinit var liveEventList: List<LiveEventDataSet>
    liveEventList = ArrayList<LiveEventDataSet>()

    // in the below line, we are adding data to our list.
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_red_rectangle,"Lionel Messi",null,
        colorResource(id = R.color.background)),"90\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_soccer_ball_img,"Goal",null,
        Color.White),"89\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_park_exchange,"LionelMessi","Ronaldo",
        colorResource(id = R.color.background)),"76\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_tabler_bandage_filled,"LionelMessi",null,
        colorResource(id = R.color.background)),"74\'",false)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_soccer_ball_img,"Goal",null,
        colorResource(id = R.color.white)),"70\'",false)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_red_rectangle,"Lionel Messi",null,
        colorResource(id = R.color.background)),"65\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_soccer_ball_img,"Goal",null,
        Color.White),"60\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_park_exchange,"LionelMessi","Ronaldo",
        colorResource(id = R.color.background)),"58\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_tabler_bandage_filled,"LionelMessi",null,
        colorResource(id = R.color.background)),"56\'",false)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_soccer_ball_img,"Goal",null,
        Color.White),"53\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_park_exchange,"LionelMessi","Ronaldo",
        colorResource(id = R.color.background)),"50\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_red_rectangle,"Lionel Messi",null,
        colorResource(id = R.color.background)),"45\'",true)
    liveEventList = liveEventList + LiveEventDataSet(Message(R.drawable.ic_soccer_ball_img,"Goal",null,
        Color.White),"40\'",true)

    liveEventList = liveEventList.reversed()

//    Column(modifier = Modifier
//        .fillMaxSize()
//        .background(colorResource(id = R.color.text_color))) {
//        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState())
//                .weight(weight = 1f, fill = false)
//        ) {
//
//        }
//    }
            Box(modifier = Modifier.fillMaxSize()){
                LazyColumn(modifier = Modifier.align(Alignment.BottomCenter)) {
                    itemsIndexed(liveEventList) { index, item ->
                        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
                        {

                            CustomizedRowUI(item,liveEventList.size,index)

//                            Row(modifier = Modifier
//                                .fillMaxWidth()
//                                .wrapContentHeight()) {
//
//                            }
                        }
                    }
                }
            }
}


@Composable
fun CustomizedRowUI(liveEvent: LiveEventDataSet,totalSize:Int,index:Int) {
    Row(
        Modifier
            //.horizontalScroll(rememberScrollState()) // this makes it scrollable
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max) // this make height of all cards to the tallest card.
            .padding(horizontal = 16.dp),
        content = {

//            repeat(3) {
//                RowItem(modifier = Modifier)
//            }

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(4.6f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (liveEvent.isDirectionLeft) {
                    LeftHorizontalBox(liveEvent)
                } else {
                    getTextView(liveEvent.time)
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.8f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                VerticalDividerWithEllipseUI(totalSize,index)
            }


            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(4.6f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (liveEvent.isDirectionLeft) {
                    getTextView(liveEvent.time)
                } else {
                    RightHorizontalBox(liveEvent)
                }
            }
        },
        //horizontalArrangement = Arrangement.spacedBy(16.dp),
    )
}

@Composable
fun LeftHorizontalBox(liveEvent: LiveEventDataSet) {
    Row(modifier = Modifier
        .padding(top = 5.dp)
        .background(
            Color.White,
            RoundedCornerShape(10.dp)
        )
        .wrapContentSize()
        .padding(10.dp)
        , verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            painter = painterResource(id = liveEvent.message.img_event),
            contentDescription = "",
            modifier = Modifier
                .size(18.dp, 18.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text(
                text = liveEvent.message.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontFamily = CustomFonts.manrope_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(2.dp))
            if(liveEvent.message.content!=null){
                Text(
                    text = liveEvent.message.content!!,
                    style = TextStyle(
                        color = colorResource(id = R.color.text_color),
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    textAlign = TextAlign.Center,
                )
            }
        }
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun RightHorizontalBox(liveEvent: LiveEventDataSet) {
    Row(modifier = Modifier
        .padding(top = 5.dp)
        .background(
            Color.White,
            RoundedCornerShape(10.dp)
        )
        .wrapContentSize()
        .padding(10.dp)
        , verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text(
                text = liveEvent.message.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontFamily = CustomFonts.manrope_bold
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(2.dp))
            if(liveEvent.message.content!=null){
                Text(
                    text = liveEvent.message.content!!,
                    style = TextStyle(
                        color = colorResource(id = R.color.text_color),
                        fontSize = 14.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    textAlign = TextAlign.Center,
                )
            }
        }
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            painter = painterResource(id = liveEvent.message.img_event),
            contentDescription = "",
            modifier = Modifier
                .size(18.dp, 18.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun VerticalDividerWithEllipseUI(totalSize:Int,index:Int) {
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Log.e("Test","VerticalDividerWithEllipseUI index = ${index} totalSize = ${totalSize}")
        print("VerticalDividerWithEllipseUI index = ${index} totalSize = ${totalSize}")
        if(index == 0 ){
            Divider(
                color = Color.Transparent,
                modifier = Modifier
                    .weight(0.6f)
                    .width(2.dp)
            )
        } else {
            Divider(
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .weight(0.6f)
                    .width(2.dp)
            )
        }


        Icon(
            painter = painterResource(id = R.drawable.ic_ellipse),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 3.dp, bottom = 3.dp)
                .size(10.dp, 10.dp),
            tint = Color.Unspecified
        )

        Divider(
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .weight(0.5f)
                .width(2.dp)
        )

    }
}

@Composable
fun getTextView(time:String) {
    Text(
        text = time,
        style = TextStyle(
            color = Color.White,
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_bold
        ),
        textAlign = TextAlign.Center,
    )
}

@Preview(showBackground = true)
@Composable
fun SoccerLiveScreenUI() {
    SuperTalkApplicationTheme {
        SoccerLiveScreenUI(rememberNavController())
    }
}