package dev.mvillasenor.japanesetrainer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.mvillasenor.japaneselearner.config.ui.AppConfigScreen
import dev.mvillasenor.japanesetrainer.design.JapaneseTrainerTheme
import dev.mvillasenor.japanesetrainer.network.NetworkClient
import dev.mvillasenor.japansetrainer.security.AppConfig
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appConfig: AppConfig

    @Inject
    lateinit var networkClient: NetworkClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            JapaneseTrainerTheme {
                NavHost(navController = navController, startDestination = "config") {
                    composable("config") { AppConfigScreen(::onApiConfigSaved) }
                }
            }
        }
    }

    private fun onApiConfigSaved() {
        lifecycleScope.launch {
            val result = networkClient.test()
            Log.d("Test", result.toString())
        }
    }
}