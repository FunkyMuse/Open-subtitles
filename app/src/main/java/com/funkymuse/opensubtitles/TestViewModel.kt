package com.funkymuse.opensubtitles

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.crazylegend.retrofit.viewmodel.viewModelSupervisorIOJob
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubs.repo.OpenSubtitleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Created by crazy on 1/10/21 to long live and prosper !
 */
class TestViewModel @ViewModelInject constructor(private val openSubtitleRepository: OpenSubtitleRepository) :
    ViewModel() {

    private val subtitlesData: MutableStateFlow<RetrofitResult<List<OpenSubtitleItem>?>> = MutableStateFlow(RetrofitResult.EmptyData)
    val subtitles: StateFlow<RetrofitResult<List<OpenSubtitleItem>?>> = subtitlesData

    fun searchForMovie(openSubtitlesUrl: OpenSubtitlesUrl) {
        subtitlesData.value = RetrofitResult.Loading
        viewModelSupervisorIOJob {
            delay(3000)
            subtitlesData.value = openSubtitleRepository.search(openSubtitlesUrl)
        }
    }
}