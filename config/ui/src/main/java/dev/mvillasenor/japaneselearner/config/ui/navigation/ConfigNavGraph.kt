package dev.mvillasenor.japaneselearner.config.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.mvillasenor.japaneselearner.config.ui.AppConfigScreen

fun  NavGraphBuilder.configGraph(navController: NavController, onFlowFinished: () -> Unit)  {
    navigation(route = ConfigRoutes.CONFIG_GRAPH_ROUTE, startDestination = ConfigRoutes.CONFIG_MAIN_SCREEN) {
        composable(ConfigRoutes.CONFIG_MAIN_SCREEN) {
            AppConfigScreen(onSaved = { onFlowFinished() })
        }
    }
}

object ConfigRoutes {
    const val CONFIG_GRAPH_ROUTE = "config_graph"
    internal const val CONFIG_MAIN_SCREEN = "config_main_screen"
}