package com.funkymuse.opensubshilt

import android.content.Context
import android.net.Uri
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubs.api.OpenSubsAPI
import com.funkymuse.opensubs.service.OpenSubtitleService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
@Singleton
class OpenSubtitleHiltRepository @Inject constructor(private val openSubsAPI: OpenSubsAPI) :
    OpenSubtitleService {

    override suspend fun search(url: String) =
        openSubsAPI.getSubtitles(url)

    override suspend fun search(openSubtitlesUrl: OpenSubtitlesUrl) =
        openSubsAPI.getSubtitles(openSubtitlesUrl.getFinalURL())

    override suspend fun downloadSubtitle(
        context: Context,
        subtitleItem: OpenSubtitleItem,
        destinationUri: Uri
    ) {
        downloadSubtitleInternal(context, subtitleItem, destinationUri)
    }


}