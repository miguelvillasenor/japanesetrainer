package dev.mvillasenor.japanesetrainer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.mvillasenor.japanesetrainer.network.NetworkClient
import dev.mvillasenor.japanesetrainer.ui.theme.JapaneseTrainerTheme
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkClient: NetworkClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JapaneseTrainerTheme {
                Scaffold(
                    topBar = {
                        TopAppBar {
                            Text(text = "test")
                        }
                    }
                ) { padding ->
                    Button(
                        onClick = {
                            lifecycleScope.launch {
                                val response = networkClient.test()
                                Log.d("Client response", response.toString())
                            }
                        },
                        modifier = Modifier.padding(padding)
                    ) {
                        Text(text = "Test")
                    }
                }
            }
        }
    }
}