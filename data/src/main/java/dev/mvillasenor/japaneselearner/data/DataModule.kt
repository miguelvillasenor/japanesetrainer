package dev.mvillasenor.japaneselearner.data

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.mvillasenor.japanesetrainer.date.database.db.MainDatabase
import dev.mvillasenor.japanesetrainer.network.NetworkClient
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): MainDatabase =
        Room.databaseBuilder(
            application,
            MainDatabase::class.java,
            "main-database"
        ).build()

    @Provides
    @Singleton
    fun providesSubjectsRepository(database: MainDatabase): SubjectsRepository =
        SubjectsRepositoryImpl(database)


    @Provides
    @Singleton
    fun providesTestSync(repository: SubjectsRepository, networkClient: NetworkClient): TestSync =
        TestSync(networkClient, repository)
}