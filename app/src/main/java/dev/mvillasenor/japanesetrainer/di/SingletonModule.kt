package dev.mvillasenor.japanesetrainer.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mvillasenor.japanesetrainer.network.NetworkModule

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class SingletonModule