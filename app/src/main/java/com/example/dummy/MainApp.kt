package com.example.dummy

import android.app.Application
import com.example.dummy.presentation.AppComponent
import com.example.dummy.presentation.DaggerAppComponent

class MainApp: Application() {
    //lateinit var appComponent: AppComponent = DaggerAppComponent
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}