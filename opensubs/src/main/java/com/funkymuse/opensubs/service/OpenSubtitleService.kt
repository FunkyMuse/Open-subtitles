package com.funkymuse.opensubs.service

import android.content.Context
import android.net.Uri
import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
interface OpenSubtitleService {

    suspend fun search(url: String): RetrofitResult<List<OpenSubtitleItem>?>

    suspend fun search(openSubtitlesUrl: OpenSubtitlesUrl): RetrofitResult<List<OpenSubtitleItem>?>

    suspend fun downloadSubtitle(context: Context, subtitleItem: OpenSubtitleItem, destinationUri: Uri)

}