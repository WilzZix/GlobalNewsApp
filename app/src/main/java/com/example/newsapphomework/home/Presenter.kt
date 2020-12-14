package com.example.newsapphomework.home

import com.example.newsapphomework.model.TopHeadLineResponse
import com.example.newsapphomework.network.HomeService
import com.example.newsapphomework.network.NetworkConnection
import io.reactivex.disposables.CompositeDisposable


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class Presenter(var view: HomeContract.View) : HomeContract.Presenter {
    private var service: HomeService =
        NetworkConnection.getRetrofit().create(HomeService::class.java)
    private var compositeDisposable: CompositeDisposable? = null


    override fun loadFirstData() {

        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }

        view.showProgress()
        val observer = service.getTopHeadline()
            .enqueue(object : Callback<TopHeadLineResponse> {
                override fun onResponse(
                    call: Call<TopHeadLineResponse>,
                    response: Response<TopHeadLineResponse>
                ) {
                    view.hideProgress()
                    response.body()?.let { it ->
                        it.articles?.let {
                            view.setData(it)
                        }
                    }
                    view.hideProgress()
                }

                override fun onFailure(call: Call<TopHeadLineResponse>, t: Throwable) {
                    Timber.i("onFailure-> %s", t.message)
                    view.hideProgress()
                }
            })
    }

    override fun loadNextPage() {
        view.showProgress()
        // service.getTopHeadline("sport", ++page)
        service.getTopHeadline()
    }

    override fun onCancel() {
        compositeDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    override fun onDestroy() {
        compositeDisposable?.clear()
    }
}