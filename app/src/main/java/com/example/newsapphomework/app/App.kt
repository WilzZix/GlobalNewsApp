package com.example.newsapphomework.app

import android.app.Application
import com.example.newsapphomework.BuildConfig
import timber.log.Timber

open class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}