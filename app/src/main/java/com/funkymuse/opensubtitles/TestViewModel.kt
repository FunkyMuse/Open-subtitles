package com.funkymuse.opensubtitles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubshiltsealed.OpenSubtitleSealedHiltRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
@HiltViewModel
class TestViewModel @Inject constructor(private val openSubtitleRepository: OpenSubtitleSealedHiltRepository) :
        ViewModel() {

    private val subtitlesData: MutableStateFlow<RetrofitResult<List<OpenSubtitleItem>?>> =
            MutableStateFlow(RetrofitResult.Idle)
    val subtitles = subtitlesData.asStateFlow()

    fun searchForMovie(openSubtitlesUrl: OpenSubtitlesUrl) {
        subtitlesData.value = RetrofitResult.Loading
        viewModelScope.launch {
            delay(3000)
            subtitlesData.value = openSubtitleRepository.search(openSubtitlesUrl)
        }
    }
}