package dev.mvillasenor.domain.subjects

data class Radical(
    val amalgamationSubjectsIds: List<Int>,
    val characterImages: List<CharacterImage>
)

data class CharacterImage(
    val url: String,
    val contentType: CharacterImageType
)

enum class CharacterImageType {
    Svg, Png
}