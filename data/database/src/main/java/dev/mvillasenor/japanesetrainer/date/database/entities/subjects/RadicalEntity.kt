package dev.mvillasenor.japanesetrainer.date.database.entities.subjects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.mvillasenor.domain.subjects.CharacterImage
import dev.mvillasenor.domain.subjects.CharacterImageType
import dev.mvillasenor.domain.subjects.Radical
import dev.mvillasenor.domain.subjects.Subject
import java.util.*


@Entity(tableName = "radicals")
data class RadicalEntity(
    @PrimaryKey
    val id: Int,
    val url: String,
    @ColumnInfo("auxiliary_meanings")
    val auxiliaryMeanings: List<AuxiliaryMeaningEntity>,
    val characters: String?,
    @ColumnInfo("created_at")
    val createdAt: Date,
    @ColumnInfo("hidden_at")
    val hiddenAt: Date?,
    @ColumnInfo("lesson_position")
    val lessonPosition: Int,
    val level: Int,
    @ColumnInfo("meaning_mnemonic")
    val meaningMnemonic: String,
    val meanings: List<MeaningEntity>,
    val slug: String,
    @ColumnInfo("spaced_repetition_system_id")
    val srsId: Int,

    @ColumnInfo("amalgamation_subject_ids")
    val amalgamationSubjectsIds: List<Int>,
    @ColumnInfo("character_images")
    val characterImages: List<CharacterImageEntity>
) {
    companion object {
        const val TABLE_NAME = "radicals"
    }
}

data class CharacterImageEntity(
    val url: String,
    val contentType: String
)

fun Subject<Radical>.toEntity(): RadicalEntity = RadicalEntity(
    id = id,
    url = url,
    auxiliaryMeanings = auxiliaryMeanings.map { it.toEntity() },
    characters = characters,
    createdAt = createdAt,
    lessonPosition = lessonPosition,
    hiddenAt = hiddenAt,
    level = level,
    meaningMnemonic = meaningMnemonic,
    meanings = meanings.map { it.toEntity() },
    slug = slug,
    srsId = srsId,
    amalgamationSubjectsIds = data.amalgamationSubjectsIds,
    characterImages = data.characterImages.map { it.toEntity() }
)

fun RadicalEntity.toDomain(): Subject<Radical> = Subject(
    id = id,
    auxiliaryMeanings = auxiliaryMeanings.map { it.toDomain() },
    characters = characters,
    createdAt = createdAt,
    url = url,
    hiddenAt = hiddenAt,
    lessonPosition = lessonPosition,
    level = level,
    meaningMnemonic = meaningMnemonic,
    meanings = meanings.map { it.toDomain() },
    slug = slug,
    srsId = srsId,
    data = Radical(
        amalgamationSubjectsIds = amalgamationSubjectsIds,
        characterImages = characterImages.map { it.toDomain() }
    )
)


private fun CharacterImage.toEntity(): CharacterImageEntity = CharacterImageEntity(
    url = url,
    contentType = contentType.name
)

private fun CharacterImageEntity.toDomain(): CharacterImage = CharacterImage(
    url = url,
    contentType = CharacterImageType.valueOf(contentType)
)

