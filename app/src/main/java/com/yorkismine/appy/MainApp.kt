package com.yorkismine.appy

import android.app.Application
import com.yorkismine.appy.di.AppComponent
import com.yorkismine.appy.di.DaggerAppComponent
import com.yorkismine.appy.di.NetworkModule

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        injector = DaggerAppComponent.builder().networkModule(NetworkModule())
            .build()
    }

    companion object {
        lateinit var injector: AppComponent
    }
}