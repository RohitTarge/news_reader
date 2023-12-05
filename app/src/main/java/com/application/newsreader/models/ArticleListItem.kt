package com.application.newsreader.models

import com.google.gson.annotations.SerializedName

data class ArticleListItem (

    @SerializedName("status"       ) var status       : String?             = null,
    @SerializedName("totalResults" ) var totalResults : Int?                = null,
    @SerializedName("articles"     ) var articles     : ArrayList<Articles> = arrayListOf()

)