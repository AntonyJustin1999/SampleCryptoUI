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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
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
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class BottomSheetItem(val title: String, val image: Int, val isSelected: Boolean = false)

data class MatchItem(
    val title1: String,
    val title2: String,
    val image1: Int,
    val image2: Int,
    val time: String,
    val isSelected: Boolean = false
)


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
    val matchItem = listOf(
        MatchItem(
            title1 = "Barcelona",
            title2 = "Real Madrid",
            time = "45:30",
            image1 = R.drawable.test_barcelona,
            image2 = R.drawable.test_real_madrid
        ),
        MatchItem(
            title1 = "Barcelona",
            title2 = "Real Madrid",
            time = "90:30",
            image1 = R.drawable.test_barcelona,
            image2 = R.drawable.test_real_madrid
        ),
        MatchItem(
            title1 = "Barcelona",
            title2 = "Real Madrid",
            time = "35:30",
            image1 = R.drawable.test_barcelona,
            image2 = R.drawable.test_real_madrid
        ),
        MatchItem(
            title1 = "Barcelona",
            title2 = "Real Madrid",
            time = "45:60",
            image1 = R.drawable.test_barcelona,
            image2 = R.drawable.test_real_madrid
        )
    )
    val bottomSheetCountryItems = listOf(
        BottomSheetItem(title = "China", image = R.drawable.ic_thajikistan_flag),
        BottomSheetItem(title = "Japan", image = R.drawable.ic_thajikistan_flag),
        BottomSheetItem(title = "India", image = R.drawable.ic_thajikistan_flag),
        BottomSheetItem(title = "Saudi Arabia", image = R.drawable.ic_thajikistan_flag),
        BottomSheetItem(title = "Australia", image = R.drawable.ic_thajikistan_flag),
        BottomSheetItem(title = "America", image = R.drawable.ic_thajikistan_flag),
        BottomSheetItem(title = "Germany", image = R.drawable.ic_thajikistan_flag)
    )
    val leagueItems = listOf(
        BottomSheetItem(title = "English Football League", image = R.drawable.ic_english_football),
        BottomSheetItem(title = "Premier League", image = R.drawable.ic_premier),
        BottomSheetItem(title = "La Liga", image = R.drawable.ic_laliga),
    )

    val listState = rememberLazyListState()
    val fabVisibility by derivedStateOf {
        listState.firstVisibleItemIndex == 0
    }


    // State to control the bottom sheet visibility
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()

    // State to hold the selected item
    val selectedItem = remember { mutableStateOf<BottomSheetItem?>(null) }

    val selectedCountryItem = remember { mutableStateOf<BottomSheetItem?>(null) }

    val leagueSelectedItem = remember { mutableStateOf<BottomSheetItem?>(null) }

    val countrySelected = remember { mutableStateOf<Boolean?>(true) }

    val matchSelectedItem = remember { mutableStateOf<MatchItem?>(null) }


    // Coroutine scope for launching actions
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(25.dp),
        backgroundColor = Color(0xfff3f0ff),
        sheetElevation = 10.dp,
        sheetContent = {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .background(color = Color(0xfff3f0ff))
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (countrySelected.value == true) {
                        "Select Sports"
                    } else {
                        "Select Country"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, bottom = 15.dp),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                )
                LazyVerticalGrid(
                    cells = GridCells.Fixed(1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                ) {
                    if (countrySelected.value == true) {
                        items(bottomSheetItems.size) { item ->

                            val isSelected =
                                selectedItem.value?.image == bottomSheetItems[item].image
                            BottomSheetItemCard(
                                item = bottomSheetItems[item].copy(isSelected = isSelected),
                                onItemSelected = {
                                    selectedItem.value = it
                                }
                            )
                        }
                    } else {
                        items(bottomSheetCountryItems.size) { item ->

                            val isSelected =
                                selectedCountryItem.value?.title == bottomSheetCountryItems[item].title
                            BottomSheetItemCard(
                                item = bottomSheetCountryItems[item].copy(isSelected = isSelected),
                                onItemSelected = {
                                    selectedCountryItem.value = it
                                }
                            )
                        }
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
                title = {
                    Text(
                        text = "Create New Room",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                },
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
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .drawWithContent {
                        drawContent()
                        // draws a fully black area with a small keyhole at pointerOffset that’ll show part of the UI.
                        drawRect(
                            Brush.radialGradient(
                                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) listOf(
                                    Color.Transparent,
                                    Color.Transparent
                                )
                                else
                                    listOf(
                                        Color.Black.copy(alpha = 0.6f),
                                        Color.Black.copy(alpha = 0.6f)
                                    )

                            )
                        )
                    }
                    .background(
                        color = Color(0xfff3f0ff)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                TittleCard("Select Sports")
                Spacer(modifier = Modifier.height(5.dp))
                SportsList(
                    selectedItem,
                    countrySelected,
                    coroutineScope,
                    bottomSheetScaffoldState,
                    bottomSheetItems
                )
                Spacer(modifier = Modifier.height(15.dp))
                if (selectedItem.value != null) {
                    TittleCard("Select Country")
                    Spacer(modifier = Modifier.height(5.dp))
                    CountryList(
                        selectedCountryItem,
                        coroutineScope,
                        countrySelected,
                        bottomSheetScaffoldState,
                        bottomSheetCountryItems
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                if (selectedCountryItem.value != null) {
                    TittleCard("Select League")
                    Spacer(modifier = Modifier.height(18.dp))
                    LazyColumn(
                        modifier = Modifier.height(230.dp)
                    ) {
                        items(leagueItems.size) { item ->

                            val isSelected =
                                leagueSelectedItem.value?.image == leagueItems[item].image
                            BottomSheetItemCard(
                                item = leagueItems[item].copy(isSelected = isSelected),
                                onItemSelected = {
                                    leagueSelectedItem.value = it
                                }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                if (leagueSelectedItem.value != null) {
                    leagueSelectedItem.value?.let { selected ->
                        MatchList(matchItem, matchSelectedItem)
                    }
                }
                Spacer(modifier = Modifier.height(600.dp))
            }
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                ButtonWithElevation(
                    navController,
                    matchSelectedItem.value != null,
                    "NEXT",
                    bottomSheetScaffoldState,
                    coroutineScope
                )
            }
        }

    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun SportsList(
    selectedItem: MutableState<BottomSheetItem?>,
    countrySelected: MutableState<Boolean?>,
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    bottomSheetItems: List<BottomSheetItem>
) {
    if (selectedItem.value != null) {
        selectedItem.value?.let { selected ->
            Card(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
                    )
                    .wrapContentHeight(), // Make the item clickable
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    countrySelected.value = true
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            countrySelected.value = true
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            countrySelected.value = false
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
                            color = Color.White
                        )
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))
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
                            .clip(CircleShape)
                            .background(
                                color = Color.Transparent
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
                                    color = Color(0xff623CBB)
                                )
                                .height(35.dp)
                                .width(35.dp), contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(
                                    id =
                                    if (countrySelected.value == true) {
                                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                            (R.drawable.ic_arrow)
                                        } else {
                                            (R.drawable.ic_arrow_up)
                                        }
                                    } else {
                                        (R.drawable.ic_arrow)
                                    }
                                ),
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
                    color = Color.Transparent
                )
                .wrapContentHeight(), // Make the item clickable
            shape = RoundedCornerShape(18.dp),
            onClick = {
                coroutineScope.launch {
                    countrySelected.value = true
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        countrySelected.value = true
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        countrySelected.value = false
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
                        color = Color.White
                    )
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                Image(
                    painter = painterResource(id = bottomSheetItems[0].image),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                        .padding(5.dp)
                        .background(
                            color = Color.Transparent

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
                                color = Color(0xff623CBB)
                            )
                            .height(35.dp)
                            .width(35.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        Image(
                            painter = painterResource(
                                id =
                                if (countrySelected.value == true) {
                                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                        (R.drawable.ic_arrow)
                                    } else {
                                        (R.drawable.ic_arrow_up)
                                    }
                                } else {
                                    (R.drawable.ic_arrow)
                                }
                            ),
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
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun CountryList(
    selectedCountryItem: MutableState<BottomSheetItem?>,
    coroutineScope: CoroutineScope,
    countrySelected: MutableState<Boolean?>,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    bottomSheetCountryItems: List<BottomSheetItem>
) {
    if (selectedCountryItem.value != null) {
        selectedCountryItem.value?.let { selected ->
            Card(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
                    )
                    .wrapContentHeight(), // Make the item clickable
                shape = RoundedCornerShape(18.dp),
                onClick = {
                    coroutineScope.launch {
                        countrySelected.value = false
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            countrySelected.value = false
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            countrySelected.value = true
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
                            color = Color.White
                        )
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_thajikistan_flag),
                        contentDescription = "Sample Image",
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            .padding(5.dp)
                            .background(
                                color = Color.Transparent
                            ),
                        alignment = Alignment.CenterStart
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = if (selected.title != null) {
                            selected.title
                        } else {
                            bottomSheetCountryItems[0].title
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
                                    color = Color(0xff623CBB)
                                )
                                .height(35.dp)
                                .width(35.dp),
                            contentAlignment = Alignment.Center,

                            ) {
                            Image(
                                painter = painterResource(
                                    id =
                                    if (countrySelected.value == false) {
                                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                            (R.drawable.ic_arrow)
                                        } else {
                                            (R.drawable.ic_arrow_up)
                                        }
                                    } else {
                                        (R.drawable.ic_arrow)
                                    }
                                ),
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
    } else {
        Card(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()
                .background(
                    color = Color.Transparent
                )
                .wrapContentHeight(), // Make the item clickable
            shape = RoundedCornerShape(18.dp),
            onClick = {
                coroutineScope.launch {
                    countrySelected.value = false
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        countrySelected.value = false
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        countrySelected.value = true
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
                        color = Color.White
                    )
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_thajikistan_flag),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                        .padding(5.dp)
                        .background(
                            color = Color.Transparent
                        ),
                    alignment = Alignment.CenterStart
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = bottomSheetCountryItems[0].title,
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
                                color = Color(0xff623CBB)
                            )
                            .height(35.dp)
                            .width(35.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        Image(
                            painter = painterResource(
                                id = if (countrySelected.value == false) {
                                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                        (R.drawable.ic_arrow)
                                    } else {
                                        (R.drawable.ic_arrow_up)
                                    }
                                } else {
                                    (R.drawable.ic_arrow)
                                }
                            ),
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
}

@Composable
private fun TittleCard(tittle: String) {
    Text(
        text = tittle,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp),
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.Black,
    )
}

@Composable
private fun MatchList(
    matchItem: List<MatchItem>,
    matchSelectedItem: MutableState<MatchItem?>
) {
    TittleCard("Select Match")
    Spacer(modifier = Modifier.height(18.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min=250.dp, max = 450.dp)
    ) {
        items(matchItem.size) { item ->

            val isSelected =
                matchSelectedItem.value?.time == matchItem[item].time
            MatchItemCard(
                item = matchItem[item].copy(isSelected = isSelected),
                onItemSelected = {
                    matchSelectedItem.value = it
                }
            )
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
            backgroundColor = if (!active) Color(0xFFC6C6C6) else MaterialTheme.colors.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
            .height(50.dp),
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
fun BottomSheetItemCard(
    item: BottomSheetItem,
    onItemSelected: (BottomSheetItem) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, top = 6.dp, bottom = 6.dp)
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
            Spacer(modifier = Modifier.padding(4.dp))
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Sample Image",
                modifier = Modifier
                    .wrapContentSize()
                    .size(35.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = item.title, color = Color.Black, modifier = Modifier.padding(5.dp))
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun MatchItemCard(
    item: MatchItem,
    onItemSelected: (MatchItem) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, top = 6.dp, bottom = 6.dp)
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
            modifier = Modifier
                .fillMaxWidth()
                .height(106.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // in the below line, we are adding Image to display the image.
                Image(
                    // in the below line, we are specifying the drawable image for our image.
                    painter = painterResource(id = R.drawable.test_barcelona),
                    contentDescription = "img",
                    modifier = Modifier
                        .height(38.dp)
                        .width(38.dp),
                    alignment = Alignment.Center
                )

                Text(
                    text = "Barcelona",

                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    modifier = Modifier,

                    // in the below line, we are adding color for our text
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }


            Box(
                contentAlignment = Alignment.Center
            ) {
                Divider(
                    color = colorResource(id = R.color.un_selected_background_color),
                    modifier = Modifier
                        .fillMaxHeight()  //fill the max height
                        .width(1.dp)
                        .padding(top = 10.dp, bottom = 10.dp)
                )

                Column(
                    modifier = Modifier
                        .size(111.dp, 44.dp)
                        .border(
                            1.dp, colorResource(id = R.color.border_color),
                            RoundedCornerShape(11.dp)
                        )
                        .background(
                            color = colorResource(id = R.color.white),
                            RoundedCornerShape(11.dp)
                        )
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "VS",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontFamily = CustomFonts.manrope_semi_bold
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Stared ${item.time}",
                        style = TextStyle(
                            color = colorResource(id = R.color.violet_dark),
                            fontSize = 14.sp,
                            fontFamily = CustomFonts.manrope_semi_bold
                        ),
                        textAlign = TextAlign.Center,
                    )
                }


            }



            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // in the below line, we are adding Image to display the image.
                Image(
                    // in the below line, we are specifying the drawable image for our image.
                    painter = painterResource(id = R.drawable.test_real_madrid),
                    contentDescription = "img",
                    modifier = Modifier
                        .height(38.dp)
                        .width(38.dp),
                    alignment = Alignment.Center
                )

                Text(
                    text = "Real Madrid",

                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_bold
                    ),
                    modifier = Modifier,

                    // in the below line, we are adding color for our text
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }


        }
    }
}