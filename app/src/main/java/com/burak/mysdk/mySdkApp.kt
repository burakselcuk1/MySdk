package com.burak.mysdk

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class mySdkApp : Application() {
    companion object {
        private var instance: mySdkApp? = null

        fun getInstance(): mySdkApp {
            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}