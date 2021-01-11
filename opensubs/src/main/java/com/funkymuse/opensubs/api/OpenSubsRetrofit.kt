package com.funkymuse.opensubs.api

import android.content.Context
import com.crazylegend.retrofit.RetrofitClient
import com.funkymuse.opensubs.Consts
import retrofit2.create

/**
 * Created by crazy on 1/11/21 to long live and prosper !
 */
object OpenSubsRetrofit {

    fun getClient(context: Context, openSubsHeader: OpenSubsHeader = OpenSubsHeader()) =
        RetrofitClient.moshiInstanceCoroutines(context, Consts.BASE_URL) {
            addInterceptor(openSubsHeader)
        }.create<OpenSubsAPI>()
}