package dev.mvillasenor.japanesetrainer.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.wanikani.com/v2/")
            .build()
    }


    @Provides
    @Singleton
    fun providesNetworkClient(retrofit: Retrofit): NetworkClient {
        return NetworkClient(retrofit)
    }
}