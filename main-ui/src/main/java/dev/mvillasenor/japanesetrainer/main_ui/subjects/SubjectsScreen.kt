package dev.mvillasenor.japanesetrainer.main_ui.subjects

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.mvillasenor.japanesetrainer.design.properties.Spacings

@Composable
fun SubjectsScreen(
    viewModel: SubjectsViewModel = hiltViewModel()
) {
    val screenState = viewModel.screenState.collectAsState()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Subjects") }) }
    ) {
        LazyColumn(modifier = Modifier.padding(it.calculateBottomPadding())) {
            items(screenState.value.radicals) {
                Card(
                    modifier = Modifier
                        .padding(Spacings.medium)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(vertical = Spacings.medium).fillMaxWidth()) {
                        Text(
                            it.characters ?: "no character",
                            color = MaterialTheme.colors.onSurface,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 50.sp
                        )
                    }
                }

            }
        }
    }
}