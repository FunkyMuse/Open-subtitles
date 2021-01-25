package com.funkymuse.opensubssealed.api

import com.crazylegend.retrofit.RetrofitClient
import com.crazylegend.retrofit.adapter.RetrofitResultAdapterFactory
import com.funkymuse.opensubs.Consts
import com.funkymuse.opensubs.api.OpenSubsHeader
import okhttp3.OkHttpClient
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/**
 * Created by crazy on 1/11/21 to long live and prosper !
 */
object OpenSubsRetrofitSealed {

    fun getClient(openSubsHeader: OpenSubsHeader = OpenSubsHeader(), okHttpClientConfig: OkHttpClient.Builder.() -> Unit = {}): OpenSubsAPISealed =
            RetrofitClient.customInstance(Consts.BASE_URL, builderCallback = {
                addCallAdapterFactory(RetrofitResultAdapterFactory())
                addConverterFactory(MoshiConverterFactory.create())
            }, okHttpClientConfig = {
                addInterceptor(openSubsHeader)
                okHttpClientConfig()
            }).create()
}