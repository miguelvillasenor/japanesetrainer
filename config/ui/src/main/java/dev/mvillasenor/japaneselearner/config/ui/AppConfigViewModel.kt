package dev.mvillasenor.japaneselearner.config.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mvillasenor.japansetrainer.security.AppConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AppConfigViewModel @Inject constructor(
    private val appConfig: AppConfig
) : ViewModel() {

    private val _screenState = MutableStateFlow(
        AppConfigScreenState(appConfig.getBearerToken() ?: "")
    )
    val screenState: StateFlow<AppConfigScreenState> = _screenState

    fun updateApiKey(newApiKey: String) {
        _screenState.update {
            it.copy(apiKey = newApiKey)
        }
    }

    fun saveApiKey() {
        appConfig.putBearerToken(_screenState.value.apiKey)
    }
}


data class AppConfigScreenState(
    val apiKey: String
)