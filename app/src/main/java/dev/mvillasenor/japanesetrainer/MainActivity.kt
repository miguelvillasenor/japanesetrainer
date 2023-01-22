package dev.mvillasenor.japanesetrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.mvillasenor.japaneselearner.config.ui.navigation.ConfigRoutes
import dev.mvillasenor.japaneselearner.config.ui.navigation.configGraph
import dev.mvillasenor.japaneselearner.data.TestSync
import dev.mvillasenor.japanesetrainer.design.JapaneseTrainerTheme
import dev.mvillasenor.japanesetrainer.main_ui.MainRoutes
import dev.mvillasenor.japanesetrainer.main_ui.mainGraph
import dev.mvillasenor.japansetrainer.security.AppConfig
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appConfig: AppConfig

    @Inject
    lateinit var testSync: TestSync
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            testSync.runInitialSync()
        }
        setContent {
            val navController = rememberNavController()
            JapaneseTrainerTheme {
                NavHost(
                    navController = navController,
                    startDestination = getInitialRoute()
                ) {
                    mainGraph()
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
        MainRoutes.MAIN_GRAPH_ROUTE
    }

    private fun onConfigFlowFinished(navController: NavController) {
        navController.navigate(MainRoutes.MAIN_GRAPH_ROUTE) {
            popUpTo(ConfigRoutes.CONFIG_GRAPH_ROUTE) {
                inclusive = true
            }
        }
    }
}