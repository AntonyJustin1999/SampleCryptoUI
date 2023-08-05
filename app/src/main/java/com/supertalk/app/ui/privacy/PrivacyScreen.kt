package com.supertalk.app.ui.privacy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.supertalk.app.R
import com.supertalk.app.ui.theme.SuperTalkApplicationTheme

@Composable
fun PrivacyScreen(navController: NavController) {
    var title = ""
    var description = ""
    val arguments = navController.currentBackStackEntry?.arguments
    val isBooleanValue by remember {
        mutableStateOf(arguments?.getBoolean("isBooleanValue") ?: false)
    }
    title = "Privacy Policy"
    description =
        """We respect your privacy and are committed to protecting your personal information. This privacy policy explains how we collect, use, and share your personal information.

    This paragraph is short and to the point, and it provides the user with the basic information they need to know about how their personal information is being collected and used. The paragraph is also 150 characters long, which is the maximum length that Google allows for privacy policy paragraphs.

    Here are some of the key points that are included in the paragraph:

    The company respects the user's privacy.
    The company is committed to protecting the user's personal information.
    The company explains how it collects, uses, and shares the user's personal information."""
    Scaffold(
        backgroundColor = colorResource(R.color.background),
        topBar = {
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = description,
                style = MaterialTheme.typography.body1, textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrivacyScreenPreview() {
    SuperTalkApplicationTheme {
        PrivacyScreen(rememberNavController())
    }
}