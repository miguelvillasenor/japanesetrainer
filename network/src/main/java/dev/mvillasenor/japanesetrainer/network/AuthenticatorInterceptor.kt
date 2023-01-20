package dev.mvillasenor.japanesetrainer.network

import dev.mvillasenor.japansetrainer.security.AppConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class AuthenticatorInterceptor(private val appConfig: AppConfig) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder()
            .header("Authorization", "Bearer ${appConfig.getBearerToken().orEmpty()}")
            .build().let {
                chain.proceed(it)
            }
    }
}