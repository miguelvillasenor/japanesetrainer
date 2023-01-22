package dev.mvillasenor.japanesetrainer.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mvillasenor.japaneselearner.data.DataModule
import dev.mvillasenor.japanesetrainer.network.NetworkModule
import dev.mvillasenor.japansetrainer.security.ConfigModule

@Module(includes = [NetworkModule::class, ConfigModule::class, DataModule::class])
@InstallIn(SingletonComponent::class)
class SingletonModule