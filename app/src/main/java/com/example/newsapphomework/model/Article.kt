package com.example.newsapphomework.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class Article(
    @SerializedName("source")
    val source: Source?,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?,

    @SerializedName("urlToImage")
    val urlToImage: String?,

    @SerializedName("content")
    val content: String?,

    @SerializedName("publishedAt")
    val publishedAt: String?
)

