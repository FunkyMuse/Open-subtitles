package com.funkymuse.opensubtitles

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.crazylegend.recyclerview.generateRecyclerWithHolder
import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.crazylegend.retrofit.retrofitResult.handle
import com.funkymuse.opensubs.OpenSubtitleItem
import com.funkymuse.opensubs.OpenSubtitlesUrl
import com.funkymuse.opensubtitles.databinding.ActivityMainBinding
import com.funkymuse.opensubtitles.databinding.ItemviewSubtitleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val subsAdapter by lazy {
        generateRecyclerWithHolder<OpenSubtitleItem, ItemviewSubtitleBinding>(
            ItemviewSubtitleBinding::inflate
        ) { item, _, _, binding,_ ->
            binding.language.text = item.languageName
            binding.subTitle.text = item.subFileName
        }
    }

    private val testViewModel by viewModels<TestViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.apply {
            setHasFixedSize(false)
            adapter = subsAdapter
        }

        binding.search.setOnClickListener {
            testViewModel.searchForMovie(
                OpenSubtitlesUrl(
                    query = binding.input.text.toString(),
                    subLanguageId = "eng"
                )
            )
        }

        lifecycleScope.launchWhenResumed {
            testViewModel.subtitles.collectLatest {
                handleSubtitles(it)
            }
        }

    }

    private fun handleSubtitles(result: RetrofitResult<List<OpenSubtitleItem>?>) {
        binding.loading.isVisible = result is RetrofitResult.Loading
        result.handle(
            callError = { throwable->
                throwable.printStackTrace()
            },
            success = {
                subsAdapter.submitList(this)
            }
        )
    }
}