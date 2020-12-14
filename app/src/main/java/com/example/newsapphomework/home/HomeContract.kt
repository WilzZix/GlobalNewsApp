package com.example.newsapphomework.home

import com.example.newsapphomework.model.Article

interface HomeContract {
    interface View {
        fun showProgress()
        fun showBottomProgress()
        fun hideProgress()
        fun setData(data: List<Article>)
        fun setMessage(message: String)
    }

    interface Presenter {
        fun loadFirstData()
        fun loadNextPage()
        fun onCancel()
        fun onDestroy()
    }
}