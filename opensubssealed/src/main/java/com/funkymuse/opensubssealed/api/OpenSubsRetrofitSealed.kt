package com.funkymuse.opensubssealed.api

import android.content.Context
import com.crazylegend.retrofit.RetrofitClient
import com.crazylegend.retrofit.adapter.RetrofitResultAdapterFactory
import com.funkymuse.opensubs.Consts
import com.funkymuse.opensubs.api.OpenSubsHeader
import com.funkymuse.opensubssealed.api.OpenSubsAPISealed
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/**
 * Created by crazy on 1/11/21 to long live and prosper !
 */
object OpenSubsRetrofitSealed {

    fun getClient(context: Context, openSubsHeader: OpenSubsHeader = OpenSubsHeader()): OpenSubsAPISealed =
        RetrofitClient.customInstance(context, Consts.BASE_URL, builderCallback = {
            addCallAdapterFactory(RetrofitResultAdapterFactory())
            addConverterFactory(MoshiConverterFactory.create())
            this
        }, okHttpClientConfig = {
            addInterceptor(openSubsHeader)
        }).create()
}