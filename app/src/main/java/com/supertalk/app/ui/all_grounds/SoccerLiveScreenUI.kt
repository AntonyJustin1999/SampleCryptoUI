package com.supertalk.app.ui.all_grounds

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
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
import com.supertalk.app.ui.theme.SuperTalkGroundApplicationTheme
import com.supertalk.app.util.CustomFonts

data class LiveEventDataSet(val img_event: Int,val message:Message,val time:String,val isDirectionLeft:Boolean)
data class Message(val title: String,val content:String?)
@Composable
fun SoccerLiveScreenUI(navController: NavController) {
    liveEventView()
}

@Composable
fun liveEventView() {

    lateinit var liveEventList: List<LiveEventDataSet>
    liveEventList = ArrayList<LiveEventDataSet>()

    // in the below line, we are adding data to our list.
    liveEventList = liveEventList + LiveEventDataSet(R.drawable.ic_red_rectangle,Message("Lionel Messi",null),"90\'",true)
    liveEventList = liveEventList + LiveEventDataSet(R.drawable.ic_soccer_ball_img,Message("Goal",null),"89\'",true)
    liveEventList = liveEventList + LiveEventDataSet(R.drawable.ic_park_exchange,Message("LionelMessi","Ronaldo"),"76\'",true)
    liveEventList = liveEventList + LiveEventDataSet(R.drawable.ic_tabler_bandage_filled,Message("LionelMessi",null),"74\'",false)
    liveEventList = liveEventList + LiveEventDataSet(R.drawable.ic_soccer_ball_img,Message("Goal",null),"70\'",false)

    LazyRow(modifier = Modifier) {
        itemsIndexed(liveEventList) { index, item ->
            Column(modifier = Modifier)
            {
                Divider(
                    color = colorResource(id = R.color.un_selected_background_color),
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                        .padding(top = 10.dp, bottom = 10.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_coin_yellow),
                    contentDescription = "",
                    modifier = Modifier
                        .size(18.dp, 18.dp),
                    tint = Color.Unspecified
                )

                Image(
                    // in the below line, we are specifying the drawable image for our image.
                    painter = painterResource(id = R.drawable.test_barcelona),
                    contentDescription = "img",
                    modifier = Modifier
                        .height(38.dp)
                        .width(38.dp),
                    alignment = Alignment.Center
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SoccerLiveScreenUI() {
    SuperTalkGroundApplicationTheme {
        SoccerLiveScreenUI(rememberNavController())
    }
}