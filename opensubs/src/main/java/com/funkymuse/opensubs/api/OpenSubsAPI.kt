package com.funkymuse.opensubs.api

import com.funkymuse.opensubs.OpenSubtitleItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
interface OpenSubsAPI {

    @GET
    suspend fun getSubtitles(@Url url: String): Response<List<OpenSubtitleItem>?>

}