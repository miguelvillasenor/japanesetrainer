package dev.mvillasenor.japanesetrainer.date.database.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.mvillasenor.domain.subjects.AuxiliaryMeaning
import dev.mvillasenor.japanesetrainer.date.database.entities.subjects.AuxiliaryMeaningEntity
import dev.mvillasenor.japanesetrainer.date.database.entities.subjects.CharacterImageEntity
import dev.mvillasenor.japanesetrainer.date.database.entities.subjects.MeaningEntity
import java.util.*

internal class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun intListToJson(value: List<Int>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun intListFromJson(string: String): List<Int>? {
        val itemType = object : TypeToken<List<Int>>() {}.type
        return runCatching { Gson().fromJson<List<Int>>(string, itemType) }.fold(
            { it },
            { null }
        )
    }

    @TypeConverter
    fun meaningListToJson(characterImageEntity: List<MeaningEntity>): String {
        return Gson().toJson(characterImageEntity)
    }

    @TypeConverter
    fun meaningListFromJson(string: String): List<MeaningEntity>? {
        val itemType = object : TypeToken<List<MeaningEntity>>() {}.type
        return runCatching { Gson().fromJson<List<MeaningEntity>>(string, itemType) }.fold(
            { it },
            { null }
        )
    }

    @TypeConverter
    fun auxiliaryMeaningListToJson(characterImageEntity: List<AuxiliaryMeaningEntity>): String {
        return Gson().toJson(characterImageEntity)
    }

    @TypeConverter
    fun auxiliaryMeaningListFromJson(string: String): List<AuxiliaryMeaningEntity>? {
        val itemType = object : TypeToken<List<AuxiliaryMeaningEntity>>() {}.type
        return runCatching { Gson().fromJson<List<AuxiliaryMeaningEntity>>(string, itemType) }.fold(
            { it },
            { null }
        )
    }

    @TypeConverter
    fun characterImageListToJson(characterImageEntity: List<CharacterImageEntity>): String {
        return Gson().toJson(characterImageEntity)
    }

    @TypeConverter
    fun characterImageListFromJson(string: String): List<CharacterImageEntity>? {
        val itemType = object : TypeToken<List<CharacterImageEntity>>() {}.type
        return runCatching { Gson().fromJson<List<CharacterImageEntity>>(string, itemType) }.fold(
            { it },
            { null }
        )
    }
}