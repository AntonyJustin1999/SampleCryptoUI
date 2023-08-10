import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.theme.Shapes
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class BottomSheetItem(val title: String, val image: Int, val isSelected: Boolean = false)

@Preview(showBackground = true)
@Composable
fun RoomCreationScreenPreview() {
    SuperTalkApplicationTheme {
        RoomCreationScreen(rememberNavController())
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun RoomCreationScreen(navController: NavHostController) {
    // List of items for the bottom sheet
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
        topBar = {
            // Top app bar
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = { Text(text = "Create New Room", textAlign = TextAlign.Center, fontSize = 16.sp) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(NavDestinations.BASIC_INDRO_SLIDER_SCREEN)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_white),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        // Main content of the screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        Color(0xfff3f0ff)
                    } else {
                        Color(0xff7C8396)
                    }
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Select Sports",
                modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(15.dp))
            if (selectedItem.value != null) {
                selectedItem.value?.let { selected ->
                    Card(
                        modifier = Modifier
                            .padding(18.dp)
                            .fillMaxWidth()
                            .background(
                                color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                    Color.Transparent
                                } else {
                                    Color(0xff7C8396)
                                }
                            )
                            .wrapContentHeight(), // Make the item clickable
                        shape = RoundedCornerShape(16.dp),
                        onClick = {
                            coroutineScope.launch {
                                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                    bottomSheetScaffoldState.bottomSheetState.expand()
                                } else {
                                    bottomSheetScaffoldState.bottomSheetState.collapse()
                                }
                            }
                        },
                        elevation = 2.dp, // Apply elevation when selected
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                        Color.White
                                    } else {
                                        Color(0xff7C8396)
                                    }
                                )
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (selected.image != null) {
                                        selected.image
                                    } else {
                                        bottomSheetItems[0].image
                                    }
                                ),
                                contentDescription = "Sample Image",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(all = 5.dp)
                                    .clip(CircleShape) .background(
                                        color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                            Color.Transparent
                                        } else {
                                            Color(0xff7C8396)
                                        }
                                    ),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = if (selected.title != null) {
                                    selected.title
                                } else {
                                    bottomSheetItems[0].title
                                },
                                modifier = Modifier.padding(16.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .wrapContentSize(), // Make the item clickable
                                shape = RoundedCornerShape(8.dp),
                                elevation = 2.dp, // Apply elevation when selected
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                                Color(0xff623CBB)
                                            } else {
                                                Color(0xff7C8396)
                                            }
                                        )
                                        .height(35.dp)
                                        .width(35.dp), contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                            (R.drawable.ic_arrow)
                                        } else {
                                            (R.drawable.ic_arrow_up)
                                        }),
                                        contentDescription = "Sample Image",
                                        modifier = Modifier
                                            .size(25.dp),
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.Center
                                    )
                                }

                            }
                        }
                    }

                }
            } else {
                Card(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxWidth()
                        .background(
                            color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                Color.Transparent
                            } else {
                                Color(0xff7C8396)
                            }
                        )
                        .wrapContentHeight(), // Make the item clickable
                    shape = RoundedCornerShape(18.dp),
                    onClick = {
                        coroutineScope.launch {
                            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            } else {

                                bottomSheetScaffoldState.bottomSheetState.collapse()
                            }
                        }
                    },
                    elevation = 2.dp, // Apply elevation when selected
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                    Color.White
                                } else {
                                    Color(0xff7C8396)
                                }
                            )
                    ) {
                        Image(
                            painter = painterResource(id = bottomSheetItems[0].image),
                            contentDescription = "Sample Image",
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape).padding(5.dp)
                                .background(
                                    color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                        Color.Transparent
                                    } else {
                                        Color(0xff7C8396)
                                    }

                                ),
                            alignment = Alignment.CenterStart
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = bottomSheetItems[0].title,
                            modifier = Modifier.padding(16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .wrapContentSize(), // Make the item clickable
                            shape = RoundedCornerShape(8.dp),
                            elevation = 2.dp, // Apply elevation when selected
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                            Color(0xff623CBB)
                                        } else {
                                            Color(0x80623CBB)
                                        }
                                    )
                                    .height(35.dp)
                                    .width(35.dp),
                                contentAlignment = Alignment.Center,

                                ) {
                                Image(
                                    painter = painterResource(id = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                        (R.drawable.ic_arrow)
                                    } else {
                                        (R.drawable.ic_arrow_up)
                                    }),
                                    contentDescription = "Sample Image",
                                    modifier = Modifier
                                        .size(25.dp), contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center
                                )
                            }

                        }

                    }
                }
            }
            Text(
                text = "Select Country",
                modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
            )
            Card(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth()
                    .background(
                        color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            Color.Transparent
                        } else {
                            Color(0xff7C8396)
                        }
                    )
                    .wrapContentHeight(), // Make the item clickable
                shape = RoundedCornerShape(18.dp),
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {

                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                },
                elevation = 2.dp, // Apply elevation when selected
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                Color.White
                            } else {
                                Color(0xff7C8396)
                            }
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_thajikistan_flag),
                        contentDescription = "Sample Image",
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape).padding(5.dp)
                            .background(
                                color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                    Color.Transparent
                                } else {
                                    Color(0xff7C8396)
                                }
                            ),
                        alignment = Alignment.CenterStart
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Thajikistan",
                        modifier = Modifier.padding(16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentSize(), // Make the item clickable
                        shape = RoundedCornerShape(8.dp),
                        elevation = 2.dp, // Apply elevation when selected
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                        Color(0xff623CBB)
                                    } else {
                                        Color(0x80623CBB)
                                    }
                                )
                                .height(35.dp)
                                .width(35.dp),
                            contentAlignment = Alignment.Center,

                            ) {
                            Image(
                                painter = painterResource(id = if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                    (R.drawable.ic_arrow)
                                } else {
                                    (R.drawable.ic_arrow_up)
                                }),
                                contentDescription = "Sample Image",
                                modifier = Modifier
                                    .size(25.dp), contentScale = ContentScale.Crop,
                                alignment = Alignment.Center
                            )
                        }

                    }

                }
            }
            Spacer(modifier = Modifier.weight(1f))

            Column {

                ButtonWithElevation(navController, false, "Next", bottomSheetScaffoldState,coroutineScope)

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonWithElevation(
    navController: NavController,
    active: Boolean,
    tittle: String,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    coroutineScope: CoroutineScope
) {
    Button(
        onClick = {
            if (tittle == "DONE") {
                coroutineScope.launch {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }

        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor =  if (!active) Color(0xFFC6C6C6) else MaterialTheme.colors.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
            .height(50.dp)
        ,
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(
            text = tittle, style = TextStyle(
                fontSize = 15.sp,
                fontFamily = CustomFonts.manrope_bold,
                color = Color.White
            )
        )
    }

}


@Composable
fun BottomSheetItemCard(item: BottomSheetItem, onItemSelected: (BottomSheetItem) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                1.dp,
                if (item.isSelected) Color(0xff623CBB) else Color.Transparent, // Change border color
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                onItemSelected(item)
            },
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White,
        elevation = 2.dp, // Apply elevation when selected
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp)

        ) {
            Spacer(modifier = Modifier.padding(8.dp))
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Sample Image",
                modifier = Modifier
                    .wrapContentSize().size(30.dp)   .clip(CircleShape),
                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = item.title, color = Color.Black)
        }
    }
}