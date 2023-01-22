package dev.mvillasenor.japanesetrainer.network

import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
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
}