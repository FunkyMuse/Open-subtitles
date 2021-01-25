package com.funkymuse.opensubs.repo

import android.content.Context
import android.net.Uri
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubs.api.OpenSubsAPI
import com.funkymuse.opensubs.api.OpenSubsRetrofit
import com.funkymuse.opensubs.service.OpenSubtitleService

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 * @property openSubsAPI OpenSubsAPI [com.funkymuse.opensubs.api.OpenSubsRetrofit.getClient]
 * @constructor
 */
class OpenSubtitleRepository constructor(private val openSubsAPI: OpenSubsAPI) :
    OpenSubtitleService {

    constructor() : this(OpenSubsRetrofit.getClient())

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