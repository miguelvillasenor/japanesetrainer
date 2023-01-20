package dev.mvillasenor.japanesetrainer.network

import dev.mvillasenor.japanesetrainer.network.models.AssignmentNetObj
import dev.mvillasenor.japanesetrainer.network.models.CollectionNetObj
import retrofit2.http.GET

internal interface WanikaniApi {

    @GET("assignments")
    suspend fun getAssignments(): CollectionNetObj<AssignmentNetObj>
}