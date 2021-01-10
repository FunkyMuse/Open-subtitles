package com.funkymuse.opensubs.module

import android.content.Context
import com.crazylegend.retrofit.RetrofitClient
import com.crazylegend.retrofit.adapter.RetrofitResultAdapterFactory
import com.funkymuse.opensubs.Consts
import com.funkymuse.opensubs.api.OpenSubsAPI
import com.funkymuse.opensubs.api.OpenSubsHeader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */

@Module
@InstallIn(SingletonComponent::class)
object OpenSubsModule {

    @Singleton
    @Provides
    fun subsRetrofit(
        @ApplicationContext context: Context,
        openSubsHeader: OpenSubsHeader
    ): OpenSubsAPI =
        RetrofitClient.customInstance(context, Consts.BASE_URL, false, builderCallback = {
            addCallAdapterFactory(RetrofitResultAdapterFactory())
            addConverterFactory(MoshiConverterFactory.create())
            this
        }, okHttpClientConfig = {
            addInterceptor(openSubsHeader)
        }).create()
}