package dev.mvillasenor.japanesetrainer.network

import dev.mvillasenor.japanesetrainer.network.models.CollectionNetObj
import dev.mvillasenor.japanesetrainer.network.models.subjects.RadicalNetObj
import retrofit2.Response
import retrofit2.http.GET

internal interface WanikaniApi {

    @GET("subjects?types=radical")
    suspend fun getRadicals(): Response<CollectionNetObj<RadicalNetObj>>
}