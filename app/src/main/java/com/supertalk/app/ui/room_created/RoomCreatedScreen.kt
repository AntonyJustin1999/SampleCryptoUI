package com.supertalk.app.ui.room_created

import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.supertalk.app.model.SportsDataSet
import com.supertalk.app.model.UsersDataSet
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations

@Composable
fun RoomCreatedScreen(navController: NavController) {
    var title = "Room Created"
    val arguments = navController.currentBackStackEntry?.arguments

    Scaffold(
        backgroundColor = colorResource(R.color.background),
        topBar = {
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            getRoomIdContainer()
            getRoomTitleContainer()
            getHeight(20)
            getSubTitle("Invite Speakers")
            getInviteUserContainer()
            getSubTitle("In Room Users")
            getInRoomUsers(context = LocalContext.current)
            getHeight(50)
            getNextButton(navController = navController)


        }
    }
}

@Composable
private fun getHeight(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
private fun getRoomIdContainer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp) // Adjust height as needed
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Room ID",
                fontSize = 14.sp,
                fontFamily = CustomFonts.manrope_bold,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.width(100.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 5.dp)
                    .height(25.dp)
                    .width(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "#A9878",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = CustomFonts.manrope_bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_upload),
                contentDescription = "Upload Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
private fun getRoomTitleContainer() {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(75.dp) // Adjust height as needed
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Room Title",
                fontSize = 16.sp,
                fontFamily = CustomFonts.manrope_regular,
                modifier = Modifier.padding(16.dp)
            )
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .width(1.dp)
                    .height(30.dp)
            )

            Text(
                text = "Big Bash",
                fontSize = 16.sp,
                fontFamily = CustomFonts.manrope_bold,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.width(100.dp))


        }
    }
}

@Composable
private fun getInviteUserContainer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp) // Adjust height as needed
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize().padding(end = 5.dp)
        ) {
            Text(
                text = "User Id",
                fontSize = 16.sp,
                fontFamily = CustomFonts.manrope_regular,
                modifier = Modifier.padding(16.dp)
            )
            Divider(
                color = colorResource(id = R.color.un_selected_background_color),
                modifier = Modifier
                    .width(1.dp)
                    .height(30.dp)
            )

            Text(
                text = "#A5272E",
                fontSize = 16.sp,
                fontFamily = CustomFonts.manrope_bold,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.width(80.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 5.dp)
                    .height(25.dp)
                    .width(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Invite",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = CustomFonts.manrope_bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize()
                )
            }


        }
    }
}

@Composable
fun getNextButton(navController: NavController) {

    Button(
        onClick = {

        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
            .height(50.dp)
            .coloredShadow(
                color = MaterialTheme.colors.primary,
                offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp
            ),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(
            text = "Next",
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_bold
            ),
        )
    }

}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun getInRoomUsers(context: Context) {
    val selectedIndex = remember { mutableStateOf(-1) }

    lateinit var usersList: List<UsersDataSet>
    usersList = ArrayList<UsersDataSet>()


    usersList = usersList + UsersDataSet("User1", R.drawable.iv_user)
    usersList = usersList + UsersDataSet("User2", R.drawable.iv_user2)
    usersList = usersList + UsersDataSet("User3", R.drawable.iv_user)
    usersList = usersList + UsersDataSet("User4", R.drawable.iv_user2)
    usersList = usersList + UsersDataSet("User5", R.drawable.iv_user)
    usersList = usersList + UsersDataSet("User6", R.drawable.iv_user2)

    LazyVerticalGrid(
        cells = GridCells.Fixed(3), // Number of columns
        modifier = Modifier.padding(horizontal = 0.dp)
    ) {
        itemsIndexed(usersList) { index, item ->
            Card(
                onClick = {
                    Toast.makeText(
                        context,
                        usersList[index].userName + " selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                    selectedIndex.value = index
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        2.dp,
                        if (selectedIndex.value == index)
                            colorResource(id = R.color.border_color_yellow)
                        else
                            colorResource(id = R.color.white),
                        shape = RoundedCornerShape(16.dp)
                    ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(13.dp))

                    Image(
                        painter = painterResource(id = usersList[index].userImg),
                        contentDescription = "img",
                        modifier = Modifier
                            .height(29.dp)
                            .width(29.dp),
                        alignment = Alignment.Center
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = usersList[index].userName,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_bold
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "joined",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 10.sp,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(R.color.green),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
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
fun RoomCreatedScreenPreview() {
    SuperTalkApplicationTheme {
        RoomCreatedScreen(rememberNavController())
    }
}