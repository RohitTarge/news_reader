package com.application.newsreader.api

import com.application.newsreader.models.ArticleListItem
import com.application.newsreader.utils.Util.Companion.API_KEY
import com.application.newsreader.utils.Util.Companion.PAGE_SIZE
import retrofit2.Response
import retrofit2.http.GET

interface ArticlesAPI {
    @GET("/v2/everything?q=bitcoin&from=2023-11-04&sortBy=publishedAt&apiKey=$API_KEY&pageSize=$PAGE_SIZE")
    suspend fun getArticles() : Response<ArticleListItem>
}