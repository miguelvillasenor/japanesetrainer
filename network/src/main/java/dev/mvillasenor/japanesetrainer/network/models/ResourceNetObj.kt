package dev.mvillasenor.japanesetrainer.network.models

import com.google.gson.annotations.SerializedName
import java.util.*

internal data class ResourceNetObj<T>(
    val id: Int,
    val url: String,
    @SerializedName("data_updated_at")
    val dataUpdatedAt: Date,
    val data: T
)