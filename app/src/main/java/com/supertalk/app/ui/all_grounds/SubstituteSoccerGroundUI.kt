package com.supertalk.app.ui.all_grounds

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.model.UsersDataSet
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts

@Composable
fun SubstituteSoccerGroundUI(navController: NavController) {

    Box(modifier = Modifier
        .padding(start = 11.dp, end = 11.dp)
        .fillMaxWidth()
        .fillMaxHeight())
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .paint(
                painterResource(id = R.drawable.ic_adview),
                contentScale = ContentScale.FillBounds
            )
        )
        {

                getGroundPlayers( )


        }
    }

}



@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun getGroundPlayers() {
    val backgroundColor = remember { mutableStateOf(Color.Blue) }
    val selectedIndex = remember { mutableStateOf(-1) }

    lateinit var usersList: List<UsersDataSet>
    usersList = ArrayList<UsersDataSet>()


    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)
    usersList = usersList + UsersDataSet("Name", R.drawable.iv_referee)




    Column {
        Spacer(modifier = Modifier.height(50.dp))
        getTeamsIconRows(backgroundColor)

        LazyVerticalGrid(
            cells = GridCells.Fixed(3), // Number of columns
            modifier = Modifier.padding(horizontal = 0.dp)
        ) {
            itemsIndexed(usersList) { index, item ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(54.dp) // Adjust the size as needed
                            .background(backgroundColor.value, shape = CircleShape)
                            .padding(2.dp)
                    ) {
                        Image(
                            painter = painterResource(id = usersList[index].userImg),
                            contentDescription = "img",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(Color.White) // Background color for the image
                                .padding(4.dp) // Adjust the padding as needed
                                .align(Alignment.Center)
                        )
                    }
                    // Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = usersList[index].userName,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_bold
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                }


            }
        }
    }
}


@Composable
fun getTeamsIconRows(backgroundColor: MutableState<Color>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Box(
            modifier = Modifier
                .size(60.dp)
                .clickable {
                 backgroundColor.value = Color.Blue
                }
        )
        {

            Icon(
                painter = painterResource(id = R.drawable.ic_paris_saint_german),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                tint = Color.Unspecified
            )
        }


        Spacer(modifier = Modifier.width(50.dp))

        Box(
            modifier = Modifier
                .size(60.dp)
                .clickable {
                    backgroundColor.value = Color.Red
                }
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.img_real_madrid),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubstituteSoccerGroundUI() {
    SuperTalkApplicationTheme {
        GroundHomeScreen(rememberNavController())
    }
}