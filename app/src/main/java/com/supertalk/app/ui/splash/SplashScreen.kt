package com.supertalk.app.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
//    val scale = remember {
//        androidx.compose.animation.core.Animatable(0f)
//    }

    // AnimationEffect
//    LaunchedEffect(key1 = true) {
//        scale.animateTo(
//            targetValue = 0.7f,
//            animationSpec = tween(
//                durationMillis = 800,
//                easing = {
//                    OvershootInterpolator(4f).getInterpolation(it)
//                })
//        )
//        delay(3000L)
//        navController.navigate("main_screen")
//    }

    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.navigate(NavDestinations.BASIC_INDRO_SLIDER_SCREEN)
    }


    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.background))
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SuperTalkApplicationTheme {
        SplashScreen(rememberNavController())
    }
}