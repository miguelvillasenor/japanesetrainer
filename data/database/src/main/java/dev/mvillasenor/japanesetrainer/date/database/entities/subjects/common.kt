package dev.mvillasenor.japanesetrainer.date.database.entities.subjects

import com.google.gson.annotations.SerializedName
import dev.mvillasenor.domain.subjects.AuxiliaryMeaning
import dev.mvillasenor.domain.subjects.AuxiliaryMeaningType
import dev.mvillasenor.domain.subjects.Meaning

data class MeaningEntity(
    val meaning: String,
    val primary: Boolean,
    @SerializedName("accepted_answer")
    val acceptedAnswer: Boolean,
)

data class AuxiliaryMeaningEntity(
    val meaning: String,
    val type: String
)

internal fun AuxiliaryMeaningEntity.toDomain(): AuxiliaryMeaning = AuxiliaryMeaning(
    meaning = meaning,
    type = AuxiliaryMeaningType.valueOf(type)
)

internal fun AuxiliaryMeaning.toEntity(): AuxiliaryMeaningEntity = AuxiliaryMeaningEntity(
    meaning = meaning,
    type = type.name
)

internal fun MeaningEntity.toDomain(): Meaning = Meaning(
    meaning = meaning,
    primary = primary,
    acceptedAnswer = acceptedAnswer
)

internal fun Meaning.toEntity(): MeaningEntity = MeaningEntity(
    meaning = meaning,
    primary = primary,
    acceptedAnswer = acceptedAnswer
)

private fun auxiliaryMeaningTypeFromString(type: String): AuxiliaryMeaningType = when (type) {
    "whitelist" -> AuxiliaryMeaningType.Whitelist
    else -> AuxiliaryMeaningType.Blacklist
}
