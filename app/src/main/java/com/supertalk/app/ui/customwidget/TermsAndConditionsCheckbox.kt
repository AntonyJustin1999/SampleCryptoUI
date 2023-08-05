package com.supertalk.app.ui.customwidget

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.supertalk.app.R

@Composable
fun TermsAndConditionsCheckbox(
    navController: NavController,
    checkedState: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    var clickedLink by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(15.dp)
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        val text = "I accept terms and conditions and privacy policy"
        val annotatedText = buildAnnotatedString {
            val termsAndConditions = "terms and conditions"
            val privacyPolicy = "privacy policy"

            append(text)
            addStyle(
                style = SpanStyle(color = colorResource(R.color.violet_dark)),
                start = text.indexOf(termsAndConditions),
                end = text.indexOf(termsAndConditions) + termsAndConditions.length
            )
            addStringAnnotation(
                tag = "Clickable",
                start = text.indexOf(termsAndConditions),
                end = text.indexOf(termsAndConditions) + termsAndConditions.length,
                annotation = "terms"
            )

            addStyle(
                style = SpanStyle(color = colorResource(R.color.violet_dark)),
                start = text.indexOf(privacyPolicy),
                end = text.indexOf(privacyPolicy) + privacyPolicy.length
            )
            addStringAnnotation(
                tag = "Clickable",
                start = text.indexOf(privacyPolicy),
                end = text.indexOf(privacyPolicy) + privacyPolicy.length,
                annotation = "privacy"
            )
        }
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                val annotations = annotatedText.getStringAnnotations(
                    tag = "Clickable",
                    start = offset,
                    end = offset
                )
                if (annotations.isNotEmpty()) {
                    clickedLink = annotations.first().item
                    // Handle clicks based on the clicked link
                    when (clickedLink) {
                        "terms" -> {
                            Log.d("check", "terms")

                            navController.navigate("TERMS_AND_CONDITIONS_SCREEN?isBooleanValue=false")
                            // Handle "Terms and Conditions" click here
                        }

                        "privacy" -> {
                            navController.navigate("PRIVACY_SCREEN?isBooleanValue=true")

                            Log.d("check", "PrivacyScreen")

                            // Handle "Privacy Policy" click here
                        }
                    }
                }
            }
        )
    }
}

