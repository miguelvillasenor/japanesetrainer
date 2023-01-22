package dev.mvillasenor.japanesetrainer.network.models.subjects

import dev.mvillasenor.domain.subjects.AuxiliaryMeaning
import dev.mvillasenor.domain.subjects.AuxiliaryMeaningType
import dev.mvillasenor.domain.subjects.Meaning

internal data class MeaningNetObj(
    val meaning: String,
    val primary: Boolean,
    val acceptedAnswer: Boolean,
)

internal data class AuxiliaryMeaningNetObj(
    val meaning: String,
    val type: String
)

internal fun MeaningNetObj.toMeaning(): Meaning = Meaning(
    meaning = meaning,
    primary = primary,
    acceptedAnswer = acceptedAnswer
)

internal fun AuxiliaryMeaningNetObj.toAuxiliaryMeaning(): AuxiliaryMeaning = AuxiliaryMeaning(
    meaning = meaning,
    type = auxiliaryMeaningTypeFromString(type)
)

private fun auxiliaryMeaningTypeFromString(type: String): AuxiliaryMeaningType = when (type) {
    "whitelist" -> AuxiliaryMeaningType.Whitelist
    else -> AuxiliaryMeaningType.Blacklist
}
