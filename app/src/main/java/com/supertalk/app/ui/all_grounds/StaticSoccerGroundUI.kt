package com.supertalk.app.ui.all_grounds

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun StaticSoccerGroundUI(navController: NavController) {

    Box(modifier = Modifier
            .padding(start = 11.dp, end = 11.dp)
            .fillMaxWidth()
            .fillMaxHeight())
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .paint(
                painterResource(id = R.drawable.soccer_ad_pitch_2x),
                contentScale = ContentScale.FillBounds
            )
        )
        {
            Box(modifier = Modifier
                .padding(bottom = 137.dp)
                .wrapContentSize()
                .background(Color.White,RoundedCornerShape(10.dp))
                .align(Alignment.Center)
            )
            {
                Text(
                    text = "Match Starts In 12min 30 sec",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_hand_with_bg),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset {
                        IntOffset(x = -100, y = -100)
                    }
                    .size(32.dp, 32.dp)
                    .clickable { }
                ,
                tint = Color.Unspecified

            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun StaticSoccerGroundUI() {
    SuperTalkApplicationTheme {
        GroundHomeScreen(rememberNavController())
    }
}