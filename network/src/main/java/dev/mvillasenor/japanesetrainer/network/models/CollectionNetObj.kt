package dev.mvillasenor.japanesetrainer.network.models

import com.google.gson.annotations.SerializedName
import java.util.*

internal data class CollectionNetObj<T>(
    val url: String,
    @SerializedName("pages")
    val pages: Pages,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("data_updated_at")
    val dataUpdatedAt: Date,
    val data: List<ResourceNetObj<T>>
)

internal data class Pages(
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("next_url")
    val nextUrl: String,
    @SerializedName("previous_url")
    val previousUrl: String
)
