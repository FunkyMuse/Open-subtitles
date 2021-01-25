package com.funkymuse.opensubshiltsealed

import com.funkymuse.opensubs.api.OpenSubsHeader
import com.funkymuse.opensubssealed.api.OpenSubsAPISealed
import com.funkymuse.opensubssealed.api.OpenSubsRetrofitSealed
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
object OpenSubsSealedHiltModule {

    @Singleton
    @Provides
    fun header() = OpenSubsHeader()

    @Singleton
    @Provides
    fun subsRetrofit(
            openSubsHeader: OpenSubsHeader
    ): OpenSubsAPISealed =
            OpenSubsRetrofitSealed.getClient(openSubsHeader)
}