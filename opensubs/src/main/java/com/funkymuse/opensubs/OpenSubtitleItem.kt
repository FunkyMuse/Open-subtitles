package com.funkymuse.opensubs


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data  class OpenSubtitleItem (
        @Json(name = "IDMovie")
        val iDMovie: String?,
        @Json(name = "IDMovieImdb")
        val iDMovieImdb: String?,
        @Json(name = "IDSubMovieFile")
        val iDSubMovieFile: String?,
        @Json(name = "IDSubtitle")
        val iDSubtitle: String?,
        @Json(name = "IDSubtitleFile")
        val iDSubtitleFile: String?,
        @Json(name = "ISO639")
        val iSO639: String?,
        @Json(name = "InfoFormat")
        val infoFormat: String?,
        @Json(name = "InfoOther")
        val infoOther: String?,
        @Json(name = "InfoReleaseGroup")
        val infoReleaseGroup: String?,
        @Json(name = "LanguageName")
        val languageName: String?,
        @Json(name = "MatchedBy")
        val matchedBy: String?,
        @Json(name = "MovieByteSize")
        val movieByteSize: String?,
        @Json(name = "MovieFPS")
        val movieFPS: String?,
        @Json(name = "MovieHash")
        val movieHash: String?,
        @Json(name = "MovieImdbRating")
        val movieImdbRating: String?,
        @Json(name = "MovieKind")
        val movieKind: String?,
        @Json(name = "MovieName")
        val movieName: String?,
        @Json(name = "MovieNameEng")
        val movieNameEng: String?,
        @Json(name = "MovieReleaseName")
        val movieReleaseName: String?,
        @Json(name = "MovieTimeMS")
        val movieTimeMS: String?,
        @Json(name = "MovieYear")
        val movieYear: String?,
        @Json(name = "QueryNumber")
        val queryNumber: String?,
        @Json(name = "QueryParameters")
        val queryParameters: QueryParameters?,
        @Json(name = "Score")
        val score: Double?,
        @Json(name = "SeriesEpisode")
        val seriesEpisode: String?,
        @Json(name = "SeriesIMDBParent")
        val seriesIMDBParent: String?,
        @Json(name = "SeriesSeason")
        val seriesSeason: String?,
        @Json(name = "SubActualCD")
        val subActualCD: String?,
        @Json(name = "SubAddDate")
        val subAddDate: String?,
        @Json(name = "SubAuthorComment")
        val subAuthorComment: String?,
        @Json(name = "SubAutoTranslation")
        val subAutoTranslation: String?,
        @Json(name = "SubBad")
        val subBad: String?,
        @Json(name = "SubComments")
        val subComments: String?,
        @Json(name = "SubDownloadLink")
        val subDownloadLink: String?,
        @Json(name = "SubDownloadsCnt")
        val subDownloadsCnt: String?,
        @Json(name = "SubEncoding")
        val subEncoding: String?,
        @Json(name = "SubFeatured")
        val subFeatured: String?,
        @Json(name = "SubFileName")
        val subFileName: String?,
        @Json(name = "SubForeignPartsOnly")
        val subForeignPartsOnly: String?,
        @Json(name = "SubFormat")
        val subFormat: String?,
        @Json(name = "SubFromTrusted")
        val subFromTrusted: String?,
        @Json(name = "SubHD")
        val subHD: String?,
        @Json(name = "SubHash")
        val subHash: String?,
        @Json(name = "SubHearingImpaired")
        val subHearingImpaired: String?,
        @Json(name = "SubLanguageID")
        val subLanguageID: String?,
        @Json(name = "SubLastTS")
        val subLastTS: String?,
        @Json(name = "SubRating")
        val subRating: String?,
        @Json(name = "SubSize")
        val subSize: String?,
        @Json(name = "SubSumCD")
        val subSumCD: String?,
        @Json(name = "SubSumVotes")
        val subSumVotes: String?,
        @Json(name = "SubTSGroup")
        val subTSGroup: String?,
        @Json(name = "SubTSGroupHash")
        val subTSGroupHash: String?,
        @Json(name = "SubTranslator")
        val subTranslator: String?,
        @Json(name = "SubtitlesLink")
        val subtitlesLink: String?,
        @Json(name = "UserID")
        val userID: String?,
        @Json(name = "UserNickName")
        val userNickName: String?,
        @Json(name = "UserRank")
        val userRank: String?,
        @Json(name = "ZipDownloadLink")
        val zipDownloadLink: String?) {

    @Keep
    @JsonClass(generateAdapter = true)
    data class QueryParameters(
        @Json(name = "query")
        val query: String?
    )

}
