package dev.mvillasenor.japanesetrainer.date.database.entities.subjects

import com.google.gson.annotations.SerializedName
import java.util.*

internal data class KanjiNetObj(
    @SerializedName("auxiliary_meanings")
    val auxiliaryMeanings: List<String>, // TODO
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
    val meanings: List<String>, // TODO
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


