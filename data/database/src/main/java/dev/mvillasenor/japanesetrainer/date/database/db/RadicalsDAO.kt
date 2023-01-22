package dev.mvillasenor.japanesetrainer.date.database.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.mvillasenor.japanesetrainer.date.database.entities.subjects.RadicalEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface RadicalsDAO {
    @Query("SELECT * FROM ${RadicalEntity.TABLE_NAME}")
    fun observeRadicals(): Flow<List<RadicalEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(radicals: List<RadicalEntity>)
}