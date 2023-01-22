package dev.mvillasenor.domain.subjects

data class Vocabulary(


    val componentSubjectIds: List<Int>,
    val contextSentences: List<ContextSentence>,
    val meaningMnemonic: String?,
    val partsOfSpeech: List<String>,
    val pronunciationAudios: List<PronunciationAudio>,
    val readings: List<VocabularyReading>,
    val readingMnemonic: String,
)

data class ContextSentence(
    val en: String,
    val ja: String,
)

data class PronunciationAudio(
    val url: String,
    val contentType: String,
    val metadata: PronunciationAudioMetadata,
)

data class PronunciationAudioMetadata(
    val gender: String,
    val sourceId: Int,
    val pronunciation: String,
    val voiceActorId: Int,
    val voiceActorName: String,
    val voiceDescription: String
)

data class VocabularyReading(
    val reading: String,
    val primary: Boolean,
    val acceptedAnswer: Boolean
)
