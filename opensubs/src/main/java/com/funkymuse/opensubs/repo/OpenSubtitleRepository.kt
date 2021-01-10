package com.funkymuse.opensubs.repo

import android.content.Context
import android.net.Uri
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubs.api.OpenSubsAPI
import com.funkymuse.opensubs.service.OpenSubtitleService
import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.GZIPInputStream
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
@Singleton
class OpenSubtitleRepository @Inject constructor(private val openSubsAPI: OpenSubsAPI) :
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

    private fun downloadSubtitleInternal(
        context: Context,
        subtitleItem: OpenSubtitleItem,
        destinationUri: Uri
    ) {
        val url = URL(subtitleItem.subDownloadLink)
        val urlConnection = url.openConnection() as HttpURLConnection
        val inputStream = GZIPInputStream(urlConnection.inputStream)

        val outputStream = context
            .contentResolver
            .openOutputStream(destinationUri)
            ?: throw RuntimeException("Failed to open output stream for Uri: $destinationUri")

        inputStream.use {
            it.copyTo(outputStream)
        }

        // Clean up resources
        outputStream.close()
    }


}