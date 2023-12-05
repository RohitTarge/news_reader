package com.application.newsreader.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.newsreader.models.Articles
import com.application.newsreader.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val articlesRepository: ArticlesRepository) : ViewModel() {

    val news : StateFlow<List<Articles>>
        get() = articlesRepository.articles

    var article : Articles?= null
    init {
        viewModelScope.launch {
            articlesRepository.getArticles()
        }
    }

}