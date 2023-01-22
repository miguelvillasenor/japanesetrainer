package dev.mvillasenor.japanesetrainer.network.models.subjects

import com.google.gson.annotations.SerializedName
import dev.mvillasenor.domain.subjects.CharacterImage
import dev.mvillasenor.domain.subjects.CharacterImageType
import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
import dev.mvillasenor.japanesetrainer.network.models.ResourceNetObj
import java.util.*

internal data class RadicalNetObj(
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
    val amalgamationSubjectsIds: List<Int>,
    @SerializedName("character_images")
    val characterImages: List<CharacterImageNetObj>
)

internal data class CharacterImageNetObj(
    val url: String,
    val contentType: String
)

internal fun ResourceNetObj<RadicalNetObj>.toRadicalSubject(): Subject<Radical> = Subject(
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

    data = Radical(
        amalgamationSubjectsIds = data.amalgamationSubjectsIds,
        characterImages = data.characterImages.map { it.toCharacterImage() }
    )
)

private fun CharacterImageNetObj.toCharacterImage(): CharacterImage = CharacterImage(
    url = url,
    contentType = contentTypeFromString(contentType)
)

private fun contentTypeFromString(contentType: String): CharacterImageType = when (contentType) {
    "image/png" -> CharacterImageType.Png
    else -> CharacterImageType.Svg
}