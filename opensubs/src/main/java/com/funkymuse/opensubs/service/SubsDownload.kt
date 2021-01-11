package com.funkymuse.opensubs.service

import android.content.Context
import android.net.Uri
import com.funkymuse.opensubs.OpenSubtitleItem
import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.GZIPInputStream

/**
 * Created by crazy on 1/11/21 to long live and prosper !
 */
interface SubsDownload {

    fun downloadSubtitleInternal(
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