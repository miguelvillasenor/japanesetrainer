package dev.mvillasenor.japanesetrainer.main_ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.mvillasenor.japanesetrainer.main_ui.subjects.SubjectsScreen

fun NavGraphBuilder.mainGraph() {
    navigation(
        startDestination = MainRoutes.SUBJECTS_SCREEN_ROUTE,
        route = MainRoutes.MAIN_GRAPH_ROUTE
    ) {
        composable(route = MainRoutes.SUBJECTS_SCREEN_ROUTE) {
            SubjectsScreen()
        }
    }
}

object MainRoutes {
    const val MAIN_GRAPH_ROUTE = "main_graph"
    const val SUBJECTS_SCREEN_ROUTE = "subjects_screen"
}