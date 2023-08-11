package com.supertalk.app.ui.home

import BottomSheetItem
import BottomSheetItemCard
import ButtonWithElevation
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.launch


data class BottomSheetItem(val title: String, val image: Int, val isSelected: Boolean = false)
@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun CardAndCoinBottomSheetScreen(navController: NavController) {

    val bottomSheetItems = listOf(
        BottomSheetItem(title = "Soccer", image = R.drawable.ic_soccer1),
        BottomSheetItem(title = "American FootBall", image = R.drawable.ic_football1),
        BottomSheetItem(title = "Basketball", image = R.drawable.ic_basketball),
        BottomSheetItem(title = "Tennis", image = R.drawable.ic_tennis1)
    )

    // State to control the bottom sheet visibility
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()

    // State to hold the selected item
    val selectedItem = remember { mutableStateOf<BottomSheetItem?>(null) }

    // Coroutine scope for launching actions
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(25.dp),
        backgroundColor = Color.Black,
        sheetElevation = 10.dp,
        sheetContent = {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .background(color = Color(0xfff3f0ff))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Select Sports",
                    modifier = Modifier.fillMaxWidth().padding(start = 15.dp, bottom = 15.dp),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                )

                LazyVerticalGrid(
                    cells = GridCells.Fixed(1),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(bottomSheetItems.size) { item ->

                        val isSelected = selectedItem.value?.image == bottomSheetItems[item].image
                        BottomSheetItemCard(
                            item = bottomSheetItems[item].copy(isSelected = isSelected),
                            onItemSelected = {
                                selectedItem.value = it
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                ButtonWithElevation(
                    navController,
                    true,
                    "DONE",
                    bottomSheetScaffoldState,
                    coroutineScope
                )
            }
        },
        sheetPeekHeight = 0.dp,
//        topBar = {
//            // Top app bar
//            TopAppBar(
//                modifier = Modifier.fillMaxWidth(),
//                title = { Text(text = "Create New Room", textAlign = TextAlign.Center, fontSize = 16.sp) },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        navController.navigate(NavDestinations.HOME_SCREEN)
//                    }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_baseline_arrow_white),
//                            contentDescription = null
//                        )
//                    }
//                }
//            )
//        }
    ) {



    }


}

@Preview(showBackground = true)
@Composable
fun CardAndCoinBottomSheetScreenPreView() {
    SuperTalkApplicationTheme {
        CardAndCoinBottomSheetScreen(rememberNavController())
    }
}