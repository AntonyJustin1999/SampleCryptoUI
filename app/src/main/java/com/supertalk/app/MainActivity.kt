package com.supertalk.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.ui.basic_intro_slider.BasicIntroSliderScreen
import com.supertalk.app.ui.login.LoginScreen
import com.supertalk.app.ui.splash.SplashScreen
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.NavDestinations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperTalkApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavDestinations.SPLASH_SCREEN,
                    ) {
                        composable(NavDestinations.SPLASH_SCREEN) {
                            SplashScreen(navController)
                        }
                        composable(NavDestinations.BASIC_INDRO_SLIDER_SCREEN) {
                            BasicIntroSliderScreen(navController)
                        }
                        composable(NavDestinations.LOGIN_SCREEN) {
                            LoginScreen(navController)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperTalkApplicationTheme {
        SplashScreen(rememberNavController())
    }
}