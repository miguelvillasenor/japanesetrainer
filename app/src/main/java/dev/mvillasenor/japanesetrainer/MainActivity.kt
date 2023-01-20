package dev.mvillasenor.japanesetrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.mvillasenor.japanesetrainer.network.NetworkClient
import dev.mvillasenor.japanesetrainer.ui.theme.JapaneseTrainerTheme
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var networkClient: NetworkClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            networkClient.test()
        }
        setContent {
            JapaneseTrainerTheme {
                Scaffold(
                    topBar = {
                        TopAppBar {
                            Text(text = "test")
                        }
                    }
                ){ padding ->
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding),
                        color = MaterialTheme.colors.background
                    ) {

                    }
                }

            }
        }
    }
}