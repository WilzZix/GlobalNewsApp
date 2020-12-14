package com.example.newsapphomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapphomework.R
import com.example.newsapphomework.adapter.HomeAdapter
import com.example.newsapphomework.hide
import com.example.newsapphomework.home.HomeContract
import com.example.newsapphomework.home.Presenter
import com.example.newsapphomework.model.Article
import com.example.newsapphomework.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_latest_news.*
import timber.log.Timber


class BusinessNewsFragment : Fragment(R.layout.fragment_business_news) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}