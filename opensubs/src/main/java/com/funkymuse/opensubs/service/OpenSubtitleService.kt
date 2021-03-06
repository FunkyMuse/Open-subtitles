package com.funkymuse.opensubs.service

import android.content.Context
import android.net.Uri
import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import retrofit2.Response

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
interface OpenSubtitleService : SubsDownload {

    suspend fun search(url: String): Response<List<OpenSubtitleItem>?>

    suspend fun search(openSubtitlesUrl: OpenSubtitlesUrl): Response<List<OpenSubtitleItem>?>

    suspend fun downloadSubtitle(
        context: Context,
        subtitleItem: OpenSubtitleItem,
        destinationUri: Uri
    )

}