package com.example.newsapphomework.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class TopHeadLineResponse(

    @SerializedName("status")
    val status: String?,//ok

    @SerializedName("totalResults")
    val totalResults: Int?,//70

    @SerializedName("articles")
    val articles: List<Article>?
)

