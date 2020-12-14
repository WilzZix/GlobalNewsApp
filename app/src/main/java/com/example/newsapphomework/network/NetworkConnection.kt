package com.example.newsapphomework.network

import com.example.newsapphomework.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.LoggingEventListener
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class NetworkConnection {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl("https://newsapi.org/")
                .callFactory(getCallFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        private fun getCallFactory(): OkHttpClient {
            return OkHttpClient().newBuilder()
                .addNetworkInterceptor(getNetworkInterceptor())
                .addInterceptor(getLoggingIntercepter())
                .build()


        }

        private fun getNetworkInterceptor(): Interceptor {
            val interceptor = object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request: Request = chain.request()
                    val url: HttpUrl = request.url.newBuilder()
                        .addQueryParameter("apiKey", "d094c8cfc699450fa563f9e2463c9725")
                        //  .addQueryParameter("category", "sports")
                        .build()

                    request = request.newBuilder().url(url).build()
                    return chain.proceed(request)
                }


            }
            return interceptor
        }

        private fun getLoggingIntercepter(): HttpLoggingInterceptor {

            val httpLoggingInterceptor: HttpLoggingInterceptor =
                HttpLoggingInterceptor { message -> Timber.i("NewsApp###--> %s", message) }
            httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
            return httpLoggingInterceptor
        }
    }
}