package dev.mvillasenor.japansetrainer.security

import android.content.SharedPreferences

internal class SharedPreferencesAppConfig(private val sharedPreferences: SharedPreferences): AppConfig {

    override fun getBearerToken(): String? = sharedPreferences.getString(MAIN_BEARER_TOKEN_KEY, null)

    override fun putBearerToken(token: String) {
        with(sharedPreferences.edit()) {
            putString(MAIN_BEARER_TOKEN_KEY, token)
            apply()
        }
    }

    companion object {
        const val MAIN_BEARER_TOKEN_KEY =  "main_bearer_token"
    }
}