package dev.mvillasenor.japanesetrainer.date.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.mvillasenor.japanesetrainer.date.database.entities.Converters
import dev.mvillasenor.japanesetrainer.date.database.entities.subjects.RadicalEntity

@Database(entities = [RadicalEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class MainDatabase: RoomDatabase() {
    abstract fun radicalsDao(): RadicalsDAO
}