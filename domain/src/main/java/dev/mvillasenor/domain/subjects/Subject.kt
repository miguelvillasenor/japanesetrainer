package dev.mvillasenor.domain.subjects

import java.util.Date


data class Subject<T>(
    val id: Int,
    val auxiliaryMeanings: List<AuxiliaryMeaning>,
    val characters: String?,
    val createdAt: Date,
    val url: String,
    val hiddenAt: Date?,
    val lessonPosition: Int,
    val level: Int,
    val meaningMnemonic: String,
    val meanings: List<Meaning>,
    val slug: String,
    val srsId: Int,
    val data: T
)

data class Meaning(
    val meaning: String,
    val primary: Boolean,
    val acceptedAnswer: Boolean,
)

data class AuxiliaryMeaning(
    val meaning: String,
    val type: AuxiliaryMeaningType
)

enum class AuxiliaryMeaningType {
    Whitelist, Blacklist
}