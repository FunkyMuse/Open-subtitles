package com.funkymuse.opensubs.api

import com.funkymuse.opensubs.Consts
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/**
 * Created by crazy on 1/11/21 to long live and prosper !
 */
object OpenSubsRetrofit {

    fun getClient(openSubsHeader: OpenSubsHeader = OpenSubsHeader(), okHttpClientConfig: OkHttpClient.Builder.() -> Unit = {}) =
            Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(OkHttpClient().newBuilder().also(okHttpClientConfig)
                            .addInterceptor(openSubsHeader)
                            .build()
                    ).baseUrl(Consts.BASE_URL)
                    .build().create<OpenSubsAPI>()

}