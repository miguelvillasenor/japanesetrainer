package dev.mvillasenor.japanesetrainer.main_ui.subjects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mvillasenor.domain.subjects.Kanji
import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
import dev.mvillasenor.japaneselearner.data.SubjectsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SubjectsViewModel @Inject constructor(
    subjectsRepository: SubjectsRepository
) : ViewModel() {

    val screenState: StateFlow<SubjectsScreenState> = subjectsRepository.observeRadicals()
        .map {
            SubjectsScreenState(
                radicals = it,
                kanjis = emptyList()
            )
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, SubjectsScreenState())

}


data class SubjectsScreenState(
    val radicals: List<Subject<Radical>> = emptyList(),
    val kanjis: List<Subject<Kanji>> = emptyList()
)