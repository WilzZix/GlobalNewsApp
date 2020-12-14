package com.example.newsapphomework.home

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatViewInflater
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapphomework.R
import com.example.newsapphomework.adapter.HomeAdapter
import com.example.newsapphomework.hide
import com.example.newsapphomework.model.Article
import com.example.newsapphomework.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*
import timber.log.Timber

class MainActivity {//: AppCompatActivity(), HomeContract.View {
//    var adapter = HomeAdapter()
//    private var homePresenter: Presenter? = null
//
////    val newsList: MutableList<String> = ArrayList()
////
////    var page = 1
////    var isLoading = false
////    val limit = 10
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        homePresenter = Presenter(this)
//        homePresenter?.loadFirstData()
//
//
//    }
//
////    fun getPage() {
////        val start = ((page) * limit) + 1
////        val end = (page) * limit
////
////        for (i in start..end) {
////            newsList.add()
////        }
////    }
//
//    override fun showProgress() {
//        progressBar.show()
//    }
//
//    override fun showBottomProgress() {
//        progressBarBottom.show()
//    }
//
//    override fun hideProgress() {
//        progressBar.hide()
//        progressBarBottom.hide()
//    }
//
//    override fun setData(data: List<Article>) {
////        Glide.with(this)
////            .load(data[3].urlToImage)
////            // .override(400,400)
////            //.centerCrop()
////            .into(mainNewsImageView)
////        mainNewsDateTV.text = data[3].publishedAt
////        mainNewsTitle.text = data[3].title
////        mainNewsDescription.text = data[3].description
////        adapter.setData(data)
////        container.adapter = adapter
////        container.layoutManager = LinearLayoutManager(this)
//    }
//
//    override fun setMessage(message: String) {
//        Timber.i("MainActivity->serMessage %s", message)
//    }
//
//    fun nextPage(view: View) {
//        homePresenter?.loadNextPage()
//    }
//
//    override fun onStop() {
//        homePresenter?.onCancel()
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        homePresenter?.onDestroy()
//        super.onDestroy()
//    }


}