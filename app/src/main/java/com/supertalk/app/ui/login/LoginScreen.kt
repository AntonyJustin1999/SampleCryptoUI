package com.supertalk.app.ui.login

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.customwidget.RoundedBoxWithPhonePickerAndTextField
import com.supertalk.app.ui.customwidget.TermsAndConditionsCheckbox
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations


@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf("") }
    var phoneCode by remember { mutableStateOf("+1") }
    val phoneCodeOptions = listOf("+1", "+44", "+91")
    var acceptTerms by remember { mutableStateOf(false) }
    val CustomTextFieldColors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        backgroundColor = Color.White
    )
    val customTextStyle = TextStyle(
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif // Optionally set a custom font family
    )

    Scaffold(
        backgroundColor = colorResource(R.color.background),
        topBar = {
            //if(mPageCount.value > 0){
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Spacer(
                            Modifier
                                .weight(0.50f)
                                .fillMaxHeight()
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_white),
                            contentDescription = null
                        )
                    }
                }
            )
            //}
        }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image placed at the top center
            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = "App Icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(200.dp)
                )
            }

            // Add vertical space of 16dp
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Your Name",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp),
                style = customTextStyle
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                colors = CustomTextFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Mobile Number",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp),
                style = customTextStyle
            )
            Spacer(modifier = Modifier.height(8.dp))

            RoundedBoxWithPhonePickerAndTextField(
                phoneNumber = password,
                onPhoneNumberChange = { password = it },
                phoneCode = phoneCode,
                onPhoneCodeChange = { phoneCode = it },
                phoneCodeOptions = phoneCodeOptions
            )
            Spacer(modifier = Modifier.height(120.dp))
            TermsAndConditionsCheckbox(navController,
                checkedState = acceptTerms,
                onCheckedChange = { acceptTerms = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Login button
            Button(
                onClick = {
                    navController.navigate(NavDestinations.REGISTRATION_OTP_SCREEN)
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
                shape = RoundedCornerShape(30),
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
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperTalkApplicationTheme {
        LoginScreen(rememberNavController())
    }
}