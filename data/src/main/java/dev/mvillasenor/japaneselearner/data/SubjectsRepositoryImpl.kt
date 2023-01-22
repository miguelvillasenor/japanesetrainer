package dev.mvillasenor.japaneselearner.data

import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
import dev.mvillasenor.japanesetrainer.date.database.db.MainDatabase
import dev.mvillasenor.japanesetrainer.date.database.entities.subjects.toDomain
import dev.mvillasenor.japanesetrainer.date.database.entities.subjects.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

internal class SubjectsRepositoryImpl(
    private val mainDatabase: MainDatabase,
    private val context: CoroutineContext = Dispatchers.IO
) : SubjectsRepository {

    override fun observeRadicals(): Flow<List<Subject<Radical>>> =
        mainDatabase.radicalsDao().observeRadicals().map { it.map { it.toDomain() } }

    override suspend fun insertRadicals(radicals: List<Subject<Radical>>) = withContext(context) {
        mainDatabase.radicalsDao().insertAll(radicals.map { it.toEntity() })
    }
}