package dev.mvillasenor.japansetrainer.security

import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ConfigModule {

    @Provides
    @Singleton
    fun providesMainKey(application: Application): MasterKey = MasterKey.Builder(application)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    @Provides
    @Singleton
    @Named(SECURE_SHARED_PREFERENCES_NAME)
    fun providesEncryptedSharedPreferences(application: Application, masterKey: MasterKey): SharedPreferences = EncryptedSharedPreferences.create(
        application,
        SECURE_SHARED_PREFERENCES_NAME,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
    )


    @Provides
    @Singleton
    fun providesAppConfig(@Named(SECURE_SHARED_PREFERENCES_NAME) sharedPreferences: SharedPreferences): AppConfig = SharedPreferencesAppConfig(sharedPreferences)

    companion object {
        const val SECURE_SHARED_PREFERENCES_NAME = "secured_shared_preferences"
    }

}