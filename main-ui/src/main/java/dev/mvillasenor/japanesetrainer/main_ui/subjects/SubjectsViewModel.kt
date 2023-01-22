package dev.mvillasenor.japanesetrainer.main_ui.subjects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
import dev.mvillasenor.japanesetrainer.network.NetworkClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubjectsViewModel @Inject constructor(
    private val networkClient: NetworkClient
) : ViewModel() {

    private val _screenState = MutableStateFlow(
        SubjectsScreenState()
    )
    val screenState: StateFlow<SubjectsScreenState> = _screenState

    init {
        viewModelScope.launch {
            networkClient.getRadicals().onSuccess { result ->
                _screenState.update { it.copy(radicals = result) }
            }
        }
    }

}


data class SubjectsScreenState(
    val radicals: List<Subject<Radical>> = emptyList()
)