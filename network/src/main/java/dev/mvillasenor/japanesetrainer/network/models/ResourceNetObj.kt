package dev.mvillasenor.japanesetrainer.network.models

import java.util.Date

data class Resource<T>(
    val id: Int,
    val url: String,
    val dataUpdatedAt: Date,
    val data: T
)