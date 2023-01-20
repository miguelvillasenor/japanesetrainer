package dev.mvillasenor.japanesetrainer.network

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dev.mvillasenor.japansetrainer.security.AppConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.text.DateFormat
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun providesOkHttpClient(application: Application, appConfig: AppConfig): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(AuthenticatorInterceptor(appConfig))
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.HEADERS)
        })
        .cache(
            Cache(File(application.cacheDir, "http_cache"), 50L * 1024L * 1024L)
        )
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    @Provides
    fun providesGson(): Gson = GsonBuilder()
        .create()

    @Provides
    @Singleton
    fun providesNetworkClient(retrofit: Retrofit): NetworkClient {
        return NetworkClient(retrofit)
    }

    companion object {
        const val BASE_URL = "https://api.wanikani.com/v2/"
    }
}