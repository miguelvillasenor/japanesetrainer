package dev.mvillasenor.japanesetrainer.network

import retrofit2.Retrofit

class NetworkClient constructor(
    private val retrofit: Retrofit
) {
    suspend fun test() {
        retrofit.create(WanikaniApi::class.java).getAssignments()
    }
}