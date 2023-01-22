package dev.mvillasenor.japaneselearner.data

import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectsRepository {
    fun observeRadicals(): Flow<List<Subject<Radical>>>

    suspend fun insertRadicals(radicals: List<Subject<Radical>>)
}