package com.supertalk.app.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.supertalk.app.util.NavDestinations

@Composable
fun SelectCardScreen(navController: NavController) {

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
                        navController.navigate(NavDestinations.HOME_SCREEN)
                    }) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_white), contentDescription = null)
                    }
                }
            )
        }
    )
    {

    }
}

@Preview(showBackground = true)
@Composable
fun SelectCardScreenPreview() {
    SuperTalkApplicationTheme {
        SelectCardScreen(rememberNavController())
    }
}