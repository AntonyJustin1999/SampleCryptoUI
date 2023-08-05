package com.supertalk.app.ui.customwidget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.supertalk.app.R

@Composable
fun RoundedBoxWithPhonePickerAndTextField(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    phoneCode: String,
    onPhoneCodeChange: (String) -> Unit,
    phoneCodeOptions: List<String>
) {
    val CustomTextFieldColors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        backgroundColor = Color.White
    )
    var isPickerVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable {
                    // Show the phone code picker when clicked
                    isPickerVisible = true
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Surface(
                    modifier = Modifier
                        .clickable {
                            // Show the phone code picker when clicked
                            isPickerVisible = true
                        },
                    shape = RoundedCornerShape(16.dp),
                    color = colorResource(R.color.violet_dark)
                ) {
                    FlowRow(
                        crossAxisAlignment = FlowCrossAxisAlignment.Center,
                        modifier = Modifier
                            .padding(all = 10.dp)
                    ) {
                        Text(
                            text = phoneCode,
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                TextField(
                    value = phoneNumber,
                    onValueChange = onPhoneNumberChange,
                    label = { Text("Mobile Number", fontSize = 15.sp) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    colors = CustomTextFieldColors
                )
            }

            // Phone code picker
            if (isPickerVisible) {
                PhoneCodePicker(
                    phoneCodeOptions = phoneCodeOptions,
                    onPhoneCodeSelected = {
                        onPhoneCodeChange(it)
                        isPickerVisible = false
                    }
                )
            }
        }
    }
}

@Composable
fun PhoneCodePicker(
    phoneCodeOptions: List<String>,
    onPhoneCodeSelected: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            phoneCodeOptions.forEach { phoneCodeOption ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // On phone code selected, update the value in the TextField
                            onPhoneCodeSelected(phoneCodeOption)
                        }
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = phoneCodeOption,
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}