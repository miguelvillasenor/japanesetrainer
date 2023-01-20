package dev.mvillasenor.japanesetrainer.network.models

import android.graphics.pdf.PdfDocument.Page
import java.util.Date

data class Collection<T>(
    val url: String,
    val pages: Pages,
    val totalCount: Int,
    val dataUpdatedAt: Date,
    val data: List<Resource<T>>
)

data class Pages(
    val perPage: Int,
    val nextUrl: String,
    val previousUrl:String
)
