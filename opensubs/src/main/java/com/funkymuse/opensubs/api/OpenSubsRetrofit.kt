package com.funkymuse.opensubs.api

import com.crazylegend.retrofit.RetrofitClient
import com.funkymuse.opensubs.Consts
import okhttp3.OkHttpClient
import retrofit2.create

/**
 * Created by crazy on 1/11/21 to long live and prosper !
 */
object OpenSubsRetrofit {

    fun getClient(openSubsHeader: OpenSubsHeader = OpenSubsHeader(), okHttpClientConfig: OkHttpClient.Builder.() -> Unit = {}) =
            RetrofitClient.moshiInstanceCoroutines(Consts.BASE_URL) {
                addInterceptor(openSubsHeader)
                okHttpClientConfig()
            }.create<OpenSubsAPI>()
}