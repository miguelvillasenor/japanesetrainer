package dev.mvillasenor.japanesetrainer.date.database.entities.subjects

import com.google.gson.annotations.SerializedName
import java.util.*

internal data class VocabularyNetOnj(
    val id: String,
    @SerializedName("auxiliary_meanings")
    val auxiliaryMeanings: List<String>, // TODO
    val characters: String?,
    @SerializedName("created_at")
    val createdAt: Date,
    val url: String,
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

    @SerializedName("component_subject_ids")
    val componentSubjectIds: List<Int>,
    @SerializedName("context_sentences")
    val contextSentences: List<ContextSentence>,
    @SerializedName("parts_of_speech")
    val partsOfSpeech: List<String>,
    @SerializedName("spaced_repetition_system_id")
    val pronunciation_audios: List<PronunciationAudio>,
    val readings: List<VocabularyReading>,
    @SerializedName("reading_mnemonic")
    val readingMnemonic: String,
)

internal data class ContextSentence(
    val en: String,
    val ja: String,
)

internal data class PronunciationAudio(
    val url: String,
    @SerializedName("content_type")
    val contentType: String,
    val metadata: PronunciationAudioMetadata,
)

internal data class PronunciationAudioMetadata(
    val gender: String,
    @SerializedName("source_id")
    val sourceId: Int,
    val pronunciation: String,
    @SerializedName("voice_actor_id")
    val voiceActorId: Int,
    @SerializedName("voice_actor_name")
    val voiceActorName: String,
    @SerializedName("voice_description")
    val voiceDescription: String
)

internal data class VocabularyReading(
    val reading: String,
    val primary: Boolean,
    @SerializedName("accepted_answer")
    val acceptedAnswer: Boolean
)
