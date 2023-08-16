package com.supertalk.app

import RoomCreationScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.ui.account_creation_success.AccountCreationSuccessScreen
import com.supertalk.app.ui.basic_intro_slider.BasicIntroSliderScreen
import com.supertalk.app.ui.dialog.UserKickOutScreen
import com.supertalk.app.ui.home.CardAndCoinBottomSheetScreen
import com.supertalk.app.ui.home.EnterCardDetailsScreen
import com.supertalk.app.ui.home.CardAndCoinBottomSheetScreen
import com.supertalk.app.ui.home.HomeScreen
import com.supertalk.app.ui.home.NewsDetailsScreen
import com.supertalk.app.ui.home.SelectCardScreen
import com.supertalk.app.ui.location_selection.LocationSelectionScreen
import com.supertalk.app.ui.login.LoginScreen
import com.supertalk.app.ui.prediction_screen.PredictionScreen
import com.supertalk.app.ui.privacy.PrivacyScreen
import com.supertalk.app.ui.privacy.TermsandConditionsScreen
import com.supertalk.app.ui.registration.RegistrationOTPScreen
import com.supertalk.app.ui.room_created.RoomCreatedScreen
import com.supertalk.app.ui.splash.SplashScreen
import com.supertalk.app.ui.sports.SportsSelectionScreen
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
                        startDestination = NavDestinations.HOME_SCREEN,
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
                        composable(NavDestinations.REGISTRATION_OTP_SCREEN) {
                            RegistrationOTPScreen(navController)
                        }
                        composable(NavDestinations.PRIVACY_SCREEN) {
                            PrivacyScreen(navController)
                        }
                        composable(NavDestinations.TERMS_AND_CONDITIONS_SCREEN) {
                            TermsandConditionsScreen(navController)
                        }
                        composable(NavDestinations.HOME_SCREEN) {
                            HomeScreen(navController)
                        }
                        composable(NavDestinations.SPORTS_SELECTION_SCREEN) {
                            SportsSelectionScreen(navController)
                        }
                        composable(NavDestinations.LOCATION_SELECTION_SCREEN) {
                           LocationSelectionScreen(navController)
                        }
                        composable(NavDestinations.ACCOUNT_CREATION_SUCCESS_SCREEN) {
                            AccountCreationSuccessScreen(navController)
                        }

                        composable(NavDestinations.USER_KICK_OUT_SCREEN) {
                            UserKickOutScreen(navController)
                        }
                        composable(NavDestinations.NEWS_DETAILS_SCREEN) {
                            NewsDetailsScreen(navController)
                        }
                        composable(NavDestinations.COIN_CARD_BOTTOM_SHEET_SCREEN) {
                            CardAndCoinBottomSheetScreen(navController)
                        }
                        composable(NavDestinations.CARD_DETAILS_ENTER_SCREEN) {
                            EnterCardDetailsScreen(navController)
                        }
                        composable(NavDestinations.SELECT_CARD_SCREEN) {
                            SelectCardScreen(navController)
                        }
                        composable(NavDestinations.ROOM_CREATION_SCREEN) {
                            RoomCreationScreen(navController)
                        }
                        composable(NavDestinations.PREDICTION_SCREEN) {
                            PredictionScreen(navController)
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
}