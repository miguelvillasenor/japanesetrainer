package dev.mvillasenor.japanesetrainer

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen (){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Main screen") })
        }
    ) {
        Text(
            text = "This is my main screen",
            modifier = Modifier.padding(it.calculateBottomPadding())
        )
    }
}