package dev.mvillasenor.japanesetrainer.network

import retrofit2.Response
import retrofit2.http.GET

interface WanikaniApi{

    @GET("assignments")
    suspend fun getAssignments(): Response<String>
}