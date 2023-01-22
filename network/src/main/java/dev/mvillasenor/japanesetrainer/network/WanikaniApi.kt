package dev.mvillasenor.japanesetrainer.network

import dev.mvillasenor.japanesetrainer.network.models.CollectionNetObj
import dev.mvillasenor.japanesetrainer.network.models.subjects.KanjiNetObj
import dev.mvillasenor.japanesetrainer.network.models.subjects.RadicalNetObj
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WanikaniApi {

    @GET("subjects?types=radical")
    suspend fun getRadicals(): Response<CollectionNetObj<RadicalNetObj>>

    @GET("subjects?types=kanji")
    suspend fun getKanjis(@Query("page_after_id") afterId: Int? = null): Response<CollectionNetObj<KanjiNetObj>>
}