package dev.mvillasenor.japanesetrainer

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mvillasenor.japanesetrainer.network.NetModule
import dev.mvillasenor.japanesetrainer.network.NetworkClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetModule::class])
@InstallIn(SingletonComponent::class)
class TestModule {


}