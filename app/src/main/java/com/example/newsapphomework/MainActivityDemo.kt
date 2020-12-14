package com.example.newsapphomework

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.newsapphomework.adapter.HomeAdapter
import com.example.newsapphomework.adapter.MyViewPagerAdapter
import com.example.newsapphomework.fragments.CategoryContainerFragment
import com.example.newsapphomework.fragments.CategoryFragment
import com.example.newsapphomework.fragments.LatestNewsFragment
import com.example.newsapphomework.home.HomeContract
import com.example.newsapphomework.home.Presenter
import com.example.newsapphomework.model.Article
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_latest_news.*
import timber.log.Timber

class MainActivityDemo : AppCompatActivity(), HomeContract.View {
    var adapter = HomeAdapter()
    private var homePresenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homePresenter = Presenter(this)
        homePresenter?.loadFirstData()

        val pagerAdapter = MyViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(LatestNewsFragment(), "Latest news")
        pagerAdapter.addFragment(CategoryContainerFragment(), "Category")

        pager.adapter = pagerAdapter
        tabs.setupWithViewPager(pager)

    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun showBottomProgress() {
        progressBarBottom.show()
    }

    override fun hideProgress() {
        progressBar.hide()
        progressBarBottom.hide()
    }

    override fun setData(data: List<Article>) {

        Glide.with(this)
            .load(data[3].urlToImage)
            .into(mainNewsImageView)
        mainNewsDateTV.text = data[3].publishedAt
        mainNewsTitle.text = data[3].title
        mainNewsDescription.text = data[3].description

        mainNewsTitle.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(data[3].url))
            startActivity(i)
        }
        adapter.setData(data)
        container.adapter = adapter
        container.layoutManager = LinearLayoutManager(this)

    }

    override fun setMessage(message: String) {
        Timber.i("MainActivity->serMessage %s", message)
    }
}