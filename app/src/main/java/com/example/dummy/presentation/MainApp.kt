package com.example.dummy.presentation

import android.app.Application

class MainApp: Application() {
    //lateinit var appComponent: AppComponent = DaggerAppComponent
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}