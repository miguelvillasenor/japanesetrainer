package dev.mvillasenor.japanesetrainer.network

import dev.mvillasenor.domain.Assignment
import dev.mvillasenor.japanesetrainer.network.mappers.toAssignment
import retrofit2.Retrofit

class NetworkClient constructor(
    private val retrofit: Retrofit
) {
    suspend fun test(): List<Assignment> {
        return retrofit.create(WanikaniApi::class.java)
            .getAssignments().data.map { it.toAssignment() }
    }
}