package dev.mvillasenor.domain.subjects

data class Kanji(
    val amalgamationSubjectIds: List<Int>,
    val componentSubjectIds: List<Int>,
    val meaningHint: String?,
    val readingHint: String?,
    val readingMnemonic: String,
    val readings: List<KanjiReading>,
    val visuallySimilarSubjectIds: List<Int>
)

data class KanjiReading(
    val reading: String,
    val primary: Boolean,
    val acceptedAnswer: Boolean,
    val type: ReadingType
)

enum class ReadingType {
    Kunyomi, Nanori, Onyomi
}