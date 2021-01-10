package com.funkymuse.opensubs

import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8


@Suppress("unused")
/**
 * This class can be used to generate a URL for the Open Subtitles REST API.
 * See: https://forum.opensubtitles.org/viewtopic.php?f=8&t=16453#p39771
 */
data class OpenSubtitlesUrl(
    val query: String,
    val subLanguageId: String,
    val episode: Int? = null,
    val imdbId: String? = null,
    val movieByteSize: Long? = null,
    val movieHash: String? = null,
    val season: Int? = null,
    val tag: String? = null,
) {

    /**
     * Build the URL by using the set parameters. According to the documentation,
     * it's important to order these options alphabetically or a redirect will
     * occur.
     */
    fun getFinalURL(): String {
        var queryString = Consts.SEARCH_URL

        if (episode != null) {
            queryString = "$queryString/episode-$episode"
        }

        if (imdbId != null) {
            queryString = "$queryString/imdbid-${String.format("%07d", imdbId)}"
        }

        if (movieByteSize != null) {
            queryString = "$queryString/moviebytesize-$movieByteSize"
        }

        if (movieHash != null) {
            queryString = "$queryString/moviehash-$movieHash"
        }

        queryString = "$queryString/query-${URLEncoder.encode(query,"utf-8")}"

        if (season != null) {
            queryString = "$queryString/season-$season"
        }

        queryString = "$queryString/sublanguageid-$subLanguageId"

        if (tag != null) {
            queryString = "$queryString/tag-$tag"
        }

        return queryString
    }
}