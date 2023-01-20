package dev.mvillasenor.japanesetrainer.network.mappers

import dev.mvillasenor.domain.SubjectType

internal fun subjectTypeFromString(subjectType: String): SubjectType = when (subjectType) {
    "kanji" -> SubjectType.Kanji
    "vocabulary" -> SubjectType.Vocabulary
    else -> SubjectType.Radical
}