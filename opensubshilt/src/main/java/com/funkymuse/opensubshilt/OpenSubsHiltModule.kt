package com.funkymuse.opensubshilt

import com.funkymuse.opensubs.api.OpenSubsAPI
import com.funkymuse.opensubs.api.OpenSubsHeader
import com.funkymuse.opensubs.api.OpenSubsRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */

@Module
@InstallIn(SingletonComponent::class)
object OpenSubsHiltModule {

    @Singleton
    @Provides
    fun header() = OpenSubsHeader()

    @Singleton
    @Provides
    fun subsRetrofit(
            openSubsHeader: OpenSubsHeader
    ): OpenSubsAPI =
            OpenSubsRetrofit.getClient(openSubsHeader)
}