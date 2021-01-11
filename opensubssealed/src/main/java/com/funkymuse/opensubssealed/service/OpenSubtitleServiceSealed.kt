package com.funkymuse.opensubssealed.service

import android.content.Context
import android.net.Uri
import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubs.service.SubsDownload

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
interface OpenSubtitleServiceSealed : SubsDownload {

    suspend fun search(url: String): RetrofitResult<List<OpenSubtitleItem>?>

    suspend fun search(openSubtitlesUrl: OpenSubtitlesUrl): RetrofitResult<List<OpenSubtitleItem>?>

    suspend fun downloadSubtitle(
        context: Context,
        subtitleItem: OpenSubtitleItem,
        destinationUri: Uri
    )

}