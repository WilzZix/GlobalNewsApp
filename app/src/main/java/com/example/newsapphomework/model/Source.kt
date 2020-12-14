package com.example.newsapphomework.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Source(

    @SerializedName("id")
    val id: Any?,

    @SerializedName("name")
    val name: String?,
)