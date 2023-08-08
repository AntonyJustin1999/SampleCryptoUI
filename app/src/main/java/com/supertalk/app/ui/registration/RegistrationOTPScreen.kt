package com.supertalk.app.ui.registration

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
<<<<<<< HEAD
import androidx.compose.foundation.text.BasicTextField
=======
>>>>>>> 199bab3a4c1c1b8e139ea3a4e639ce50591da242
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.basic_intro_slider.coloredShadow
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme
import com.supertalk.app.util.CustomFonts
import com.supertalk.app.util.NavDestinations
import kotlinx.coroutines.delay

@Composable
fun RegistrationOTPScreen(navController: NavController) {

    var timer by remember { mutableStateOf(10) }
    val isCodeSent = remember { mutableStateOf(false) }
    val isWrongCode = remember { mutableStateOf(false) }
    var otpValue by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(NavDestinations.BASIC_INDRO_SLIDER_SCREEN)
                    }) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_white), contentDescription = null)
                    }
                }
            )
        }
    )
    {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colorResource(R.color.background)),
        ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.app_icon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(220.dp)
                    )
                }

                Text(
                    text = if(isWrongCode.value) "Please Enter Correct OTP" else "Enter OTP",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontFamily = CustomFonts.manrope_extra_bold
                    ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp)
                )

//                Row(
//                    modifier = Modifier
//                        .padding(start = 15.dp, end = 15.dp, top = 15.dp)
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//
//                    val customOtp1 = CustomTextField()
//                    customOtp1.CustomTextFieldForOTP( "1",isWrongCode = isWrongCode)
//                    val customOtp2 = CustomTextField()
//                    customOtp2.CustomTextFieldForOTP( "2",isWrongCode = isWrongCode)
//                    val customOtp3 = CustomTextField()
//                    customOtp3.CustomTextFieldForOTP( "3",isWrongCode = isWrongCode)
//                    val customOtp4 = CustomTextField()
//                    customOtp4.CustomTextFieldForOTP( "4",isWrongCode = isWrongCode)
//                    val customOtp5 = CustomTextField()
//                    customOtp5.CustomTextFieldForOTP( "5",isWrongCode = isWrongCode)
//                    val customOtp6 = CustomTextField()
//                    customOtp6.CustomTextFieldForOTP( "6",isWrongCode = isWrongCode)
//
////                    OTPTextField("2",isWrongCode)
////                    OTPTextField("5",isWrongCode)
////                    OTPTextField("0",isWrongCode)
////                    OTPTextField("1",isWrongCode)
////                    OTPTextField("0",isWrongCode)
////                    OTPTextField("3",isWrongCode)
//
//                }
            val lightBlue = Color(0xffd8e6ff)
            val maxLength = 1

            BasicTextField(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                    .fillMaxWidth(),
                value = otpValue,
                onValueChange = {
                    if(it.length<=6){
                        otpValue = it
                    }
                },
                textStyle = TextStyle(
                    color = Color.Green
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                ),
                decorationBox = {
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        repeat(6){index ->
                            val char = when {
                                index >= otpValue.length -> ""
                                else -> otpValue[index].toString()
                            }
                            val isFocused = otpValue.length == index
                            Text(modifier = Modifier
                                .width(49.dp)
                                .height(62.dp)
//                                    .border(
//                                        if(isFocused) 1.dp
//                                        else 0.dp,
//                                        if(isFocused) DarkGray
//                                        else White,
//                                        RoundedCornerShape(16.dp)
//                                    )
                                    .background(color =
                                    if(isWrongCode.value) colorResource(id = R.color.otp_color_background) else Color.White,
                                        shape = RoundedCornerShape(16.dp)),
                                text = char,
                                style = TextStyle(
                                    color = if(isWrongCode.value) colorResource(id = R.color.otp_text_color) else Color.Black,
                                    fontSize = 17.sp,
                                    fontFamily = CustomFonts.manrope_medium,
                                    textAlign = TextAlign.Center
                                ),
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.weight(1f))

                Column {

                    LaunchedEffect(key1 = timer) {
                        if (timer > 0) {
                            delay(1000)
                            timer -= 1
                        } else {
                            isCodeSent.value = true
                        }
                    }

                    Text(
                        text = if(isCodeSent.value) "Resend Code" else "Resend Code In ${timer.toString()} sec",
                        style = TextStyle(
                            color = if(isCodeSent.value) colorResource(R.color.violet_dark) else colorResource(R.color.text_color),
                            fontSize = 15.sp,
                            fontFamily = CustomFonts.manrope_bold
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp, start = 13.dp, end = 13.dp)
                    )

                    ButtonWithElevation(navController,isWrongCode)

                }
        }
    }
}

@Composable
private fun OTPTextField(inputValue:String,wrongCode:MutableState<Boolean>){
    Column {
        var textState by remember { mutableStateOf(inputValue) }
        val maxLength = 1
        val lightBlue = Color(0xffd8e6ff)

        TextField(
            modifier = Modifier.size(49.dp,62.dp),
            value = textState,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if(wrongCode.value) colorResource(id = R.color.otp_color_background) else Color.White,
                cursorColor = Color.Black,
                disabledLabelColor = lightBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength){
                    textState = it
                    Log.e("Test","Text Changed = ${it}")
                }
            },
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            textStyle = TextStyle(
                color = if(wrongCode.value) colorResource(id = R.color.otp_text_color) else Color.Black,
                fontSize = 17.sp,
                fontFamily = CustomFonts.manrope_medium,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun ButtonWithElevation(navController: NavController,wrongCode:MutableState<Boolean>) {

    Button(
        onClick = {
            wrongCode.value = true
            navController.navigate(NavDestinations.REGISTRATION_OTP_SCREEN)
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
                color = MaterialTheme.colors.primary,
                offsetX = (-4).dp, offsetY = 3.dp, shadowRadius = 10.dp
            ),
        shape = RoundedCornerShape(14.dp),
        enabled = !wrongCode.value
    ) {
        Text(text = "Verify",style = TextStyle(
            fontSize = 15.sp,
            fontFamily = CustomFonts.manrope_bold,
            color = Color.White
        ))
    }

}

@Preview(showBackground = true)
@Composable
fun RegistrationOTPScreenPreview() {
    SuperTalkApplicationTheme {
        RegistrationOTPScreen(rememberNavController())
    }
}