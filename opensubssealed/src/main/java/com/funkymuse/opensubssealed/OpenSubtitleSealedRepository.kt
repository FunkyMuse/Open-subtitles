package com.funkymuse.opensubssealed

import android.content.Context
import android.net.Uri
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubssealed.api.OpenSubsAPISealed
import com.funkymuse.opensubssealed.api.OpenSubsRetrofitSealed
import com.funkymuse.opensubssealed.service.OpenSubtitleServiceSealed

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
class OpenSubtitleSealedRepository constructor(private val openSubsAPI: OpenSubsAPISealed) :
        OpenSubtitleServiceSealed {

    constructor() : this(OpenSubsRetrofitSealed.getClient())

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