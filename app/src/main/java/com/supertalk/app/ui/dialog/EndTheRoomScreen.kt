package com.supertalk.app.ui.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts


@Preview(showBackground = true)
@Composable
fun EndTheRoomScreenPreview() {
    SuperTalkApplicationTheme {
        EndTheRoomScreen(rememberNavController())
    }
}

@Composable
fun EndTheRoomScreen(navController: NavController) {

    Scaffold(
        backgroundColor = colorResource(R.color.green_background),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomEndTheRoomDialog(value = "", setShowDialog = {}, setValue = {}, navController)
            }
        }
    )
}

@Composable
fun CustomEndTheRoomDialog(
    value: String,
    setShowDialog: (Boolean) -> Unit,
    setValue: (String) -> Unit,
    navController: NavController
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight() .offset(y = (30).dp / 2)
                    .padding(start = 16.dp, end = 16.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                        .clickable { setShowDialog(false) }
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .background(colorResource(id = R.color.background))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(top = 0.dp, start = 10.dp, end = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 40.dp,
                                        bottom = 40.dp
                                    )
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                getSubTitle(title = "Are You Sure You Want To \nEnd The Room?")
                            }
                        }

                        EndRoomButton(navController = navController)
                    }
                }
            }
        }
    }
}


@Composable
fun EndRoomButton(navController: NavController) {

    Button(
        onClick = {

        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp)
            .height(50.dp)
            .coloredShadow(
                color = MaterialTheme.colors.primary,
                offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp
            ),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(
            text = "End Room",
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_bold
            ),
        )
    }

}

@Composable
private fun getSubTitle(title: String) {
    Text(
        text = title,
        fontSize = 17.sp,
        fontFamily = CustomFonts.manrope_bold,
        textAlign = TextAlign.Center
    )

}

@Composable
private fun MyProfileImage() {
    Box(
    ) {
        Image(
            painter = painterResource(id = R.drawable.iv_kickout_user),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(90.dp, 90.dp)

        )

    }
}

