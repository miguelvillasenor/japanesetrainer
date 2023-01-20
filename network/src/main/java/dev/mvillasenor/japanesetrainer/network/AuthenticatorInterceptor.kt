package dev.mvillasenor.japanesetrainer.network

import okhttp3.Interceptor
import okhttp3.Response

internal class AuthenticatorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder()
            .header("Authorization", "Bearer <your-token>")
            .build().let {
                chain.proceed(it)
            }
    }
}