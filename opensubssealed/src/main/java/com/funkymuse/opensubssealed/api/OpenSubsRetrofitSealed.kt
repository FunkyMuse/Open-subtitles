package com.funkymuse.opensubssealed.api

import com.crazylegend.retrofit.adapter.RetrofitResultAdapterFactory
import com.funkymuse.opensubs.Consts
import com.funkymuse.opensubs.api.OpenSubsHeader
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/**
 * Created by crazy on 1/11/21 to long live and prosper !
 */
object OpenSubsRetrofitSealed {

    fun getClient(openSubsHeader: OpenSubsHeader = OpenSubsHeader()): OpenSubsAPISealed =
        Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addCallAdapterFactory(RetrofitResultAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(openSubsHeader)
                .build())
            .build().create()
}