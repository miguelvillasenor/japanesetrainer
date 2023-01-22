package dev.mvillasenor.japanesetrainer.network.models.subjects

import com.google.gson.annotations.SerializedName
import dev.mvillasenor.domain.subjects.Kanji
import dev.mvillasenor.domain.subjects.KanjiReading
import dev.mvillasenor.domain.subjects.ReadingType
import dev.mvillasenor.domain.subjects.Subject
import dev.mvillasenor.japanesetrainer.network.models.ResourceNetObj
import java.util.*

internal data class KanjiNetObj(
    @SerializedName("auxiliary_meanings")
    val auxiliaryMeanings: List<AuxiliaryMeaningNetObj>,
    val characters: String?,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("hidden_at")
    val hiddenAt: Date?,
    @SerializedName("lesson_position")
    val lessonPosition: Int,
    val level: Int,
    @SerializedName("meaning_mnemonic")
    val meaningMnemonic: String,
    val meanings: List<MeaningNetObj>,
    val slug: String,
    @SerializedName("spaced_repetition_system_id")
    val srsId: Int,

    @SerializedName("amalgamation_subject_ids")
    val amalgamationSubjectIds: List<Int>,
    @SerializedName("component_subject_ids")
    val componentSubjectIds: List<Int>,
    @SerializedName("meaning_hint")
    val meaningHint: String?,
    @SerializedName("reading_hint")
    val readingHint: String?,
    @SerializedName("reading_mnemonic")
    val readingMnemonic: String,
    val readings: List<KanjiReadingNetObj>,
    @SerializedName("visually_similar_subject_ids")
    val visuallySimilarSubjectIds: List<Int>
)

internal data class KanjiReadingNetObj(
    val reading: String,
    val primary: Boolean,
    @SerializedName("accepted_answer")
    val acceptedAnswer: Boolean,
    val type: String
)

internal fun ResourceNetObj<KanjiNetObj>.toKanjiSubject(): Subject<Kanji> = Subject(
    id = id,
    auxiliaryMeanings = data.auxiliaryMeanings.map { it.toAuxiliaryMeaning() },
    characters = data.characters,
    createdAt = data.createdAt,
    url = url,
    hiddenAt = data.hiddenAt,
    lessonPosition = data.lessonPosition,
    level = data.level,
    meaningMnemonic = data.meaningMnemonic,
    meanings = data.meanings.map { it.toMeaning() },
    slug = data.slug,
    srsId = data.srsId,

    data = Kanji(
        amalgamationSubjectIds = data.amalgamationSubjectIds,
        componentSubjectIds = data.componentSubjectIds,
        meaningHint = data.meaningHint,
        readingHint = data.readingHint,
        readingMnemonic = data.readingMnemonic,
        readings = data.readings.map { it.toKanjiReading() },
        visuallySimilarSubjectIds = data.visuallySimilarSubjectIds
    )
)


private fun KanjiReadingNetObj.toKanjiReading(): KanjiReading = KanjiReading(
    reading = reading,
    acceptedAnswer = acceptedAnswer,
    type = readingTypeFromString(type),
    primary = primary
)

private fun readingTypeFromString(type: String): ReadingType = when (type) {
    "kunyomi" -> ReadingType.Kunyomi
    "nanori" -> ReadingType.Nanori
    else -> ReadingType.Onyomi
}

