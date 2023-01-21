package dev.mvillasenor.japanesetrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.mvillasenor.japaneselearner.config.ui.navigation.ConfigRoutes
import dev.mvillasenor.japaneselearner.config.ui.navigation.configGraph
import dev.mvillasenor.japanesetrainer.design.JapaneseTrainerTheme
import dev.mvillasenor.japanesetrainer.network.NetworkClient
import dev.mvillasenor.japansetrainer.security.AppConfig
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
                NavHost(
                    navController = navController,
                    startDestination = getInitialRoute()
                ) {
                    composable("main") { MainScreen() }
                    configGraph(
                        navController = navController,
                        onFlowFinished = { onConfigFlowFinished(navController) }
                    )
                }
            }
        }
    }

    private fun getInitialRoute(): String = if (appConfig.getBearerToken().isNullOrEmpty()) {
        ConfigRoutes.CONFIG_GRAPH_ROUTE
    } else {
        "main"
    }

    private fun onConfigFlowFinished(navController: NavController) {
        navController.navigate("main") {
            popUpTo(ConfigRoutes.CONFIG_GRAPH_ROUTE) {
                inclusive = true
            }
        }
    }
}