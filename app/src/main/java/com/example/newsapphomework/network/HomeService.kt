package com.example.newsapphomework.network

import android.telecom.Call
import com.example.newsapphomework.model.Article
import com.example.newsapphomework.model.TopHeadLineResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface HomeService {
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=d094c8cfc699450fa563f9e2463c9725
    //v2/top-headlines?country=us&apiKey=d094c8cfc699450fa563f9e2463c9725
    //http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=d094c8cfc699450fa563f9e2463c9725
//https://newsapi.org/v2/everything?q=apple&from=2020-11-09&to=2020-11-09&sortBy=popularity&apiKey=d094c8cfc699450fa563f9e2463c9725
    //Wall Street Journal News http://newsapi.org/v2/everything?domains=wsj.com&apiKey=d094c8cfc699450fa563f9e2463c9725

    //top-headlines?q=trump&apiKey=d094c8cfc699450fa563f9e2463c9725

    //https://newsapi.org/v2/top-headlines?country=us
    @GET("v2/top-headlines?country=us")
    fun getTopHeadline(

    ): retrofit2.Call<TopHeadLineResponse>


    @GET("v2/top-headlines")
    fun getCategory(
        @Query("q") q: String
    ): retrofit2.Call<TopHeadLineResponse>

}