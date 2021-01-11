package com.funkymuse.opensubs.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 * Created by crazy on 12/7/20 to long live and prosper !
 */
class OpenSubsHeader: Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request().newBuilder().header("User-Agent", "TemporaryUserAgent").build()
        )
}