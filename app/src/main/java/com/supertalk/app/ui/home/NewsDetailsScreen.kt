package com.supertalk.app.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.max
import androidx.compose.ui.zIndex
import com.supertalk.app.util.NavDestinations
import kotlin.math.absoluteValue
import kotlin.math.min

@Composable
fun NewsDetailsScreen(navController: NavController) {

    NewsDetailsScreenImpl()

}

@Composable
fun SampleWidget(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center
    ) {
        Box(Modifier.zIndex(1f)) {
            val textPadding = 15.dp
            val overlayBoxHeight = 40.dp
            Card(
                elevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(textPadding)
                ) {
                    Text("Card Title")
                    Text("Card Subtitle")
                    Text("Card Content Line 1")
                    Text("Card Content Line 2")
                }
            }
            Box(
                Modifier
                    .height(overlayBoxHeight)
                    .width(40.dp)
                    .offset(x = textPadding, y = overlayBoxHeight / 2)
                    .background(Color.Red)
                    .align(Alignment.BottomCenter)
            )
        }

        Card(
            elevation = 10.dp,
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(0f)
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text("Card Title")
                Text("Card Subtitle")
                Text("Card Content Line 1")
                Text("Card Content Line 2")
            }
        }
    }
}

@Composable
fun NewsDetailsScreenImpl(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                        , horizontalArrangement = Arrangement.End){
                        Spacer(
                            Modifier
                                .weight(0.50f)
                                .fillMaxHeight())
                        IconButton(onClick = {

                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = null
                                , modifier = Modifier.size(24.dp,24.dp))
                        }
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_white), contentDescription = null)
                    }
                }
            )
        }
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
            ) {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .zIndex(1f)){
                    Image(
                        painter = painterResource(id = R.drawable.test_sports_big_img),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(220.dp)
                            .fillMaxWidth())

                    Box(modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset {
                            IntOffset(x = 0, y = 160)
                        })
                    {
                        getRoundedCornerMenu()
                    }
                }

                Column(
                    modifier = Modifier
                        .zIndex(0f)
                        //.verticalScroll(rememberScrollState())
                        //.weight(weight = 1f, fill = false)
                        .fillMaxHeight()
                        .background(colorResource(id = R.color.background))
                ) {

                    Column(
                        modifier = Modifier
                    ) {
                        Spacer(modifier = Modifier.padding(top = 70.dp))
                        getDateTextViewRow()
                        Spacer(modifier = Modifier.padding(top = 15.dp))

                        Divider(
                            color = colorResource(id = R.color.white),
                            modifier = Modifier
                                .fillMaxWidth()  //fill the max height
                                .width(1.dp)
                        )

                        Spacer(modifier = Modifier.padding(top = 20.dp))

                        Text(
                            text = "Ronaldo Gets Injured",

                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 16.sp,
                                fontFamily = CustomFonts.manrope_extra_bold
                            ),
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 16.dp, end = 16.dp),
                        )

                        Spacer(modifier = Modifier.padding(top = 10.dp))

                        Text(
                            text = "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.\n" +
                                    "\n" +
                                    "Lorem ipsum dolor sit amet consectetur. Habitant felis ipsum sollicitudin porttitor pulvinar turpis sem dis eu. Adipiscing viverra dui nunc eget.",

                            style = TextStyle(
                                color = colorResource(id = R.color.text_color),
                                fontSize = 13.sp,
                                fontFamily = CustomFonts.manrope_semi_bold
                            ),
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 16.dp, end = 16.dp),
                        )

                        Spacer(modifier = Modifier.padding(top = 20.dp))

                    }
                }
            }
        }

    }
}

@Composable
fun getDateTextViewRow(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp)
        , verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "28/06/2023",

            style = TextStyle(
                color = colorResource(id = R.color.text_color),
                fontSize = 13.sp,
                fontFamily = CustomFonts.manrope_semi_bold
            ),
            modifier = Modifier.wrapContentSize(),
        )

        Text(
            text = "Emirates Stadium",

            style = TextStyle(
                color = colorResource(id = R.color.text_color),
                fontSize = 13.sp,
                fontFamily = CustomFonts.manrope_semi_bold
            ),
            modifier = Modifier.wrapContentSize(),
        )
    }
}
@Composable
fun getRoundedCornerMenu(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.White, RoundedCornerShape(16.dp)),
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
            Row(
                modifier = Modifier
                    .size(72.dp, 38.dp)
                    .background(
                        color = colorResource(id = R.color.light_background),
                        RoundedCornerShape(11.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    modifier = Modifier,
                    text = "2",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                    textAlign = TextAlign.End,
                )
                Text(
                    modifier = Modifier,
                    text = "1",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                    textAlign = TextAlign.Start,
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
@Composable
fun SampleToolbar(){
    // Creating a Simple Scaffold
    // Layout for the application
    Scaffold(

        // Creating a Top Bar
        topBar = { TopAppBar(title =
        { Text("GFG | Collapsing Toolbar", color = Color.White) },
            backgroundColor = Color(0xff0f9d58)) },

        // Creating Content
        content = {

            // Creating a Column Layout
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                // Creating a Scrollable list of 100 items
                val items = (1..100).map { "Item $it" }
                val lazyListState = rememberLazyListState()
                var scrolledY = 0f
                var previousOffset = 0
                LazyColumn(
                    Modifier.fillMaxSize(),
                    lazyListState,
                ) {
                    // Setting the Image as the first
                    // item and making it collapsible
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.test_img_sports_news),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .graphicsLayer {
                                    scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                    translationY = scrolledY * 0.5f
                                    previousOffset = lazyListState.firstVisibleItemScrollOffset
                                }
                                .height(240.dp)
                                .fillMaxWidth()
                        )
                    }

                    // Displaying the remaining 100 items
                    items(100) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .height(80.dp)
                        ) {
                            Text(
                                text = "Item $it",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun CollapsingToolbarInComposeApp() {
    val listState = rememberLazyListState()
    CollapsibleScaffold(
        state = listState,
        topBar = {
            TopBar(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth(),
                onBack = {},
                actions = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Blue)
                    )
                }
            ) {
                val fraction = this.fraction
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.test_img_sports_news),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }
            }
        }
    ) { insets ->
        LazyColumn(state = listState, contentPadding = insets) {
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Yellow)
                )
            }
            items(100) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(80.dp)
                ) {
                    Text(
                        text = "Item $it",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
private fun PreviewTopAppBarColumn() {
    MaterialTheme {
        val scrollState = rememberScrollState()
        CollapsibleScaffold(
            state = scrollState,
            topBar = {
                TopBar(
                    modifier = Modifier.background(Color.Red),
                    onBack = {},
                    actions = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Blue)
                        )
                    }
                ) {
                    val fraction = this.fraction
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Green)
                    ) {
                        Text(
                            text = fraction.toString(),
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                        )
                    }
                }
            }
        ) { insets ->
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Spacer(modifier = Modifier.padding(insets))
                repeat(100) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .height(80.dp)
                    ) {
                        Text(
                            text = "Item $it",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

object CollapsibleScaffoldTopBarScope
object CollapsibleTopAppBarDefaults {
    // Replicating the value in androidx.compose.material.AppBar.AppBarHeight which is private
    val minHeight = 56.dp
    val maxHeightSmall = 198.dp
    val maxHeightLarge = 320.dp
    /**
     *  When content height reach this point we start applying padding start and end
     */
    const val startScalingFraction = 0.3f
}
enum class CollapsibleTopAppBarMode {
    Default,
    Collapsed,
    Expanded;
    @Composable
    internal fun offset(): Int = when (this) {
        Default -> LocalScrollOffset.current.value ?: Int.MAX_VALUE
        Collapsed -> Int.MAX_VALUE
        Expanded -> 0
    }
    @Composable
    internal fun insets(): PaddingValues = when (this) {
        Default -> LocalInsets.current
        Collapsed,
        Expanded -> remember { PaddingValues(0.dp) }
    }
}
private val LocalScrollOffset = compositionLocalOf<State<Int?>> {
    mutableStateOf(null)
}
private val LocalInsets = compositionLocalOf {
    PaddingValues(0.dp)
}
private val LocalMaxHeight = compositionLocalOf {
    CollapsibleTopAppBarDefaults.maxHeightLarge
}
@Composable
fun CollapsibleScaffold(
    state: ScrollState,
    modifier: Modifier = Modifier,
    topBarMaxHeight: Dp = CollapsibleTopAppBarDefaults.maxHeightLarge,
    topBar: @Composable CollapsibleScaffoldTopBarScope.() -> Unit = {},
    content: @Composable (insets: PaddingValues) -> Unit
) {
    CollapsibleScaffoldInternal(
        offsetState = rememberOffsetScrollState(state),
        modifier = modifier,
        topBarMaxHeight = topBarMaxHeight,
        topBar = topBar,
        content = content
    )
}
@Composable
fun CollapsibleScaffold(
    state: LazyListState,
    modifier: Modifier = Modifier,
    topBarMaxHeight: Dp = CollapsibleTopAppBarDefaults.maxHeightLarge,
    topBar: @Composable CollapsibleScaffoldTopBarScope.() -> Unit = {},
    content: @Composable (insets: PaddingValues) -> Unit
) {
    CollapsibleScaffoldInternal(
        offsetState = rememberOffsetScrollState(state),
        modifier = modifier,
        topBarMaxHeight = topBarMaxHeight,
        topBar = topBar,
        content = content
    )
}
@Composable
private fun CollapsibleScaffoldInternal(
    offsetState: State<Int?>,
    modifier: Modifier = Modifier,
    topBarMaxHeight: Dp,
    topBar: @Composable CollapsibleScaffoldTopBarScope.() -> Unit = {},
    content: @Composable (insets: PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        backgroundColor = Color.Transparent
    ) { insets ->
        Box {
            Box(
                modifier = Modifier.padding(top = CollapsibleTopAppBarDefaults.minHeight)
            ) {
                content(
                    PaddingValues(
                        top = topBarMaxHeight - CollapsibleTopAppBarDefaults.minHeight,
                        bottom = 16.dp
                    )
                )
            }
            CompositionLocalProvider(
                LocalScrollOffset provides offsetState,
                LocalInsets provides insets,
                LocalMaxHeight provides topBarMaxHeight
            ) {
                CollapsibleScaffoldTopBarScope.topBar()
            }
        }
    }
}
@Composable
fun CollapsibleScaffoldTopBarScope.TopBar(
    modifier: Modifier = Modifier,
    mode: CollapsibleTopAppBarMode = CollapsibleTopAppBarMode.Default,
    onBack: (() -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null,
    content: (@Composable CollapsibleTopAppBarScope.() -> Unit) = { }
) {
    TopBar(
        modifier = modifier,
        mode = mode,
        actions = actions,
        content = content,
        navigationIcon = onBack?.let { {
            //BackButton(onClick = it)
        } }
    )
}
@Composable
fun CollapsibleScaffoldTopBarScope.TopBar(
    modifier: Modifier = Modifier,
    mode: CollapsibleTopAppBarMode = CollapsibleTopAppBarMode.Default,
    actions: (@Composable RowScope.() -> Unit)? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    content: (@Composable CollapsibleTopAppBarScope.() -> Unit) = { }
) {
    TopBarInternal(
        scrollOffset = mode.offset(),
        insets = mode.insets(),
        modifier = modifier.background(Color.Transparent),
        navigationIcon = navigationIcon,
        actions = actions,
        content = content
    )
}
@Composable
private fun TopBarInternal(
    scrollOffset: Int,
    insets: PaddingValues,
    modifier: Modifier = Modifier,
    navigationIcon: (@Composable () -> Unit)? = null,
    maxHeight: Dp = LocalMaxHeight.current,
    actions: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable CollapsibleTopAppBarScope.() -> Unit
) {
    val density = LocalDensity.current
    val actionsSize = remember { mutableStateOf(IntSize.Zero) }
    val navIconSize = remember { mutableStateOf(IntSize.Zero) }
    val actionWidth = with(density) { actionsSize.value.width.toDp() }
    val backWidth = with(density) { navIconSize.value.width.toDp() }
    val bodyHeight = maxHeight - CollapsibleTopAppBarDefaults.minHeight
    val maxOffset = with(density) {
        bodyHeight.roundToPx() - insets.calculateTopPadding().roundToPx()
    }
    val offset = min(scrollOffset, maxOffset)
    val fraction = 1f - kotlin.math.max(0f, offset.toFloat()) / maxOffset
    val currentMaxHeight = bodyHeight * fraction
    BoxWithConstraints(modifier = modifier) {
        val maxWidth = maxWidth
        Row(
            modifier = Modifier
                .height(CollapsibleTopAppBarDefaults.minHeight)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.onGloballyPositioned {
                    navIconSize.value = it.size
                }
            ) {
                if (navigationIcon != null) {
                    navigationIcon()
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .widthIn(0.dp, maxWidth / 2)
                    .onGloballyPositioned { actionsSize.value = it.size }
            ) {
                if (actions != null) {
                    actions()
                }
            }
        }
        val scaleFraction = (fraction / CollapsibleTopAppBarDefaults.startScalingFraction).coerceIn(0f, 1f)
        val paddingStart = if (fraction > CollapsibleTopAppBarDefaults.startScalingFraction) {
            0.dp
        } else {
            lerp(backWidth, 0.dp, scaleFraction)
        }
        val paddingEnd = if (fraction > CollapsibleTopAppBarDefaults.startScalingFraction) {
            0.dp
        } else {
            lerp(actionWidth, 0.dp, scaleFraction)
        }
        /**
         *  When content height reach minimum size, we start translating it to fit the toolbar
         */
        val minHeightDiff = currentMaxHeight - CollapsibleTopAppBarDefaults.minHeight
        val paddingTop = if (minHeightDiff > 0.dp) {
            CollapsibleTopAppBarDefaults.minHeight
        } else {
            CollapsibleTopAppBarDefaults.minHeight + minHeightDiff
        }
        BoxWithConstraints(
            modifier = Modifier
                .padding(top = paddingTop, start = paddingStart, end = paddingEnd)
                .height(max(CollapsibleTopAppBarDefaults.minHeight, currentMaxHeight))
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        ) {
            val scope = remember(fraction, this) {
                CollapsibleTopAppBarScope(fraction = fraction, scope = this)
            }
            content(scope)
        }
    }
}
class CollapsibleTopAppBarScope(
    val fraction: Float,
    scope: BoxWithConstraintsScope
) : BoxWithConstraintsScope by scope
@Composable
private fun rememberOffsetScrollState(state: ScrollState): MutableState<Int?> {
    val offsetState = rememberSaveable { mutableStateOf<Int?>(null) }
    offsetState.value = state.value
    return offsetState
}
@Composable
private fun rememberOffsetScrollState(state: LazyListState): MutableState<Int?> {
    val offsetState = rememberSaveable { mutableStateOf<Int?>(null) }
    val firstItem = remember(state) {
        derivedStateOf {
            val firstItem = state.layoutInfo.visibleItemsInfo.firstOrNull { it.index == 0 }
            firstItem?.offset?.absoluteValue
        }
    }
    offsetState.value = firstItem.value
    return offsetState
}

@Preview(showBackground = true)
@Composable
fun NewsDetailsScreenPreview() {
    SuperTalkApplicationTheme {
        NewsDetailsScreen(rememberNavController())
    }
}