package com.funkymuse.opensubs.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by crazy on 12/7/20 to long live and prosper !
 */
@Singleton
class OpenSubsHeader @Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request().newBuilder().header("User-Agent", "TemporaryUserAgent").build()
        )
}