package dev.mvillasenor.japanesetrainer.network

import dev.mvillasenor.domain.subjects.Kanji
import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
import dev.mvillasenor.japanesetrainer.network.models.subjects.toKanjiSubject
import dev.mvillasenor.japanesetrainer.network.models.subjects.toRadicalSubject
import retrofit2.Retrofit
import retrofit2.create

class NetworkClient constructor(
    private val retrofit: Retrofit
) {

    private val wanikaniApi = retrofit.create<WanikaniApi>()
    suspend fun getRadicals(): Result<List<Subject<Radical>>> = kotlin.runCatching {
        wanikaniApi.getRadicals().body()?.data?.map { it.toRadicalSubject() } ?: emptyList()
    }

    suspend fun getKanjis(): Result<List<Subject<Kanji>>> = kotlin.runCatching {
        val result = mutableListOf<Subject<Kanji>>()
        var lastResponse = wanikaniApi.getKanjis()
        result.addAll(lastResponse.body()?.data?.map { it.toKanjiSubject() } ?: emptyList())
        while (lastResponse.body()?.pages?.nextUrl != null) {
            lastResponse = wanikaniApi.getKanjis(result.lastOrNull()?.id)
            result.addAll(lastResponse.body()?.data?.map { it.toKanjiSubject() } ?: emptyList())
        }
        result
    }
}