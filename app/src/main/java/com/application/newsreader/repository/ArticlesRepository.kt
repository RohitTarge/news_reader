package com.application.newsreader.repository

import com.application.newsreader.api.ArticlesAPI
import com.application.newsreader.models.Articles
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ArticlesRepository @Inject constructor(private val articlesAPI: ArticlesAPI) {

    private val _articles = MutableStateFlow<List<Articles>>(emptyList())
    val articles : StateFlow<List<Articles>> get() = _articles
    suspend fun getArticles(){
        val response = articlesAPI.getArticles()
        if(response.isSuccessful && response.body() != null){
                _articles.emit(response.body()!!.articles)
        }
    }
}