package com.example.newsapphomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.newsapphomework.R
import com.example.newsapphomework.adapter.CategoryAdapter
import com.example.newsapphomework.app.TopSpacingItemDecoration
import com.example.newsapphomework.model.TopHeadLineResponse
import com.example.newsapphomework.network.HomeService
import com.example.newsapphomework.network.NetworkConnection
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.sql.DataSource

class CategoryContainerFragment : Fragment(R.layout.fragment_category_container) {

    private lateinit var categoryAdapter: CategoryAdapter
    private var service: HomeService =
        NetworkConnection.getRetrofit().create(HomeService::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addDataSet()
        initRecyclerView()
    }

    private fun addDataSet() {
        val observer = service.getTopHeadline()
            .enqueue(object : Callback<TopHeadLineResponse> {
                override fun onResponse(
                    call: Call<TopHeadLineResponse>,
                    response: Response<TopHeadLineResponse>
                ) {

                    response.body()?.let { it ->
                        it.articles?.let {
                            //categoryAdapter.setData(it)
                            categoryAdapter.submitList(it)
                        }
                    }

                }

                override fun onFailure(call: Call<TopHeadLineResponse>, t: Throwable) {
                    Timber.i("onFailure-> %s", t.message)

                }


            })
    }

    private fun initRecyclerView() {
        businessNewsRV.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
            val topSpacingItemDecoration = TopSpacingItemDecoration(12)
            addItemDecoration(topSpacingItemDecoration)
            categoryAdapter = CategoryAdapter()
            adapter = categoryAdapter
        }
    }
}




