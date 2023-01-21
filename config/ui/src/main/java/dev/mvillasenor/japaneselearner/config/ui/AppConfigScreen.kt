package dev.mvillasenor.japaneselearner.config.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun AppConfigScreen(
    onSaved: () -> Unit,
    viewModel: AppConfigViewModel = hiltViewModel()
) {
    val state = viewModel.screenState.collectAsState()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.config_ui_app_config_title)) }) },
    ) { padding ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(bottom = padding.calculateBottomPadding())
                    .fillMaxHeight()
            ) {


                ApiConfigScreenContent(
                    apiKey = state.value.apiKey,
                    onApiKeyUpdated = { viewModel.updateApiKey(it) },
                    onApiKeySaved = {
                        viewModel.saveApiKey()
                        onSaved()
                    }
                )
            }
        }

    }

}
