package com.funkymuse.opensubssealed.api

import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.funkymuse.opensubs.OpenSubtitleItem
import retrofit2.http.GET
import retrofit2.http.Url


/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
interface OpenSubsAPISealed {

    @GET
    suspend fun getSubtitles(@Url url: String): RetrofitResult<List<OpenSubtitleItem>?>
    
}