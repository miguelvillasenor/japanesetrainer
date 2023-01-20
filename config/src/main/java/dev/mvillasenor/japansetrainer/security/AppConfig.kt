package dev.mvillasenor.japansetrainer.security

interface AppConfig {

    fun getBearerToken(): String?

    fun putBearerToken(token: String)

}