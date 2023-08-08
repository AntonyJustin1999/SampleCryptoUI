import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.launch

data class BottomSheetItem(val title: String, val icon: ImageVector)

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
        BottomSheetItem(title = "Notification", icon = Icons.Default.Notifications),
        BottomSheetItem(title = "Mail", icon = Icons.Default.MailOutline),
        BottomSheetItem(title = "Scan", icon = Icons.Default.Search),
        BottomSheetItem(title = "Edit", icon = Icons.Default.Edit),
        BottomSheetItem(title = "Favorite", icon = Icons.Default.Favorite),
        BottomSheetItem(title = "Settings", icon = Icons.Default.Settings)
    )

    // State to control the bottom sheet visibility
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()

    // State to hold the selected item
    val selectedItem = remember { mutableStateOf<BottomSheetItem?>(null) }

    // Coroutine scope for launching actions
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            // Content of the bottom sheet
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .background(color = Color.Transparent)
                    .wrapContentHeight(), // Make the item clickable
                shape = RoundedCornerShape(16.dp),
                elevation = 2.dp, // Apply elevation when selected
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp)
                        .background(color = Color.White)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Bottom Sheet",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                        color = Color.Black
                    )

                    LazyVerticalGrid(
                        cells = GridCells.Fixed(1),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(bottomSheetItems.size) { item ->
                            BottomSheetItemCard(item = bottomSheetItems[item], onItemSelected = {
                                selectedItem.value = it
                            })
                        }
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    ButtonWithElevation(navController, true, "DONE", bottomSheetScaffoldState)
                }
            }
        },
        sheetPeekHeight = 0.dp,
        topBar = {
            // Top app bar
            TopAppBar(
                title = { Text(text = "Create New Room") },
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
                .background(color = Color(0xfff3f0ff)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            /*Button(
                modifier = Modifier.padding(20.dp),
                onClick = {

                }
            ) {
                Text(text = "Click to show Bottom Sheet")
            }*/
if(selectedItem.value!=null) {
    selectedItem.value?.let { selected ->
        Card(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .background(color = Color.Transparent)
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
            Row {
                Icon(
                    imageVector =
                    if (selected.icon != null) {
                        selected.icon
                    } else {
                        bottomSheetItems[0].icon
                    },
                    contentDescription = "",
                    tint = Color.Black
                )
                Text(
                    text = "Selected Item:" + if (selected.title != null) {
                        selected.title
                    } else {
                        bottomSheetItems[0].title
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    }
}else{
    Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)
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
        Row {
            Icon(
                imageVector =
                bottomSheetItems[0].icon,
                contentDescription = "",
                tint = Color.Black
            )
            Text(
                text =  bottomSheetItems[0].title,
                modifier = Modifier.padding(16.dp)
            )
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .background(color = Color(0xff623CBB))
                    .wrapContentHeight(), // Make the item clickable
                shape = RoundedCornerShape(5.dp),
                elevation = 2.dp, // Apply elevation when selected
            ) {

            }

        }
    }
}
            Spacer(modifier = Modifier.weight(1f))

            Column {

                ButtonWithElevation(navController, false, "Next", bottomSheetScaffoldState)

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
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    val coroutineScope = rememberCoroutineScope()

    Button(
        onClick = {
            if (tittle == "Done") {
                coroutineScope.launch {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }

        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 15.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = colorResource(id = R.color.disabled_btn_color)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 30.dp, start = 13.dp, end = 13.dp)
            .height(50.dp)
            .coloredShadow(
                color = if (!active) Color(0xFFC6C6C6) else MaterialTheme.colors.primary,
                offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp
            ),
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .clickable {
                onItemSelected(item)
            }
    ) {
        Spacer(modifier = Modifier.padding(8.dp))
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = item.title, color = Color.Black)
    }
}