package com.batterb.constantatesttask.app

import android.app.Application
import com.batterb.constantatesttask.di.AppComponent
import com.batterb.constantatesttask.di.DaggerAppComponent
import com.batterb.constantatesttask.di.modules.ViewModelModule

class ConstantaTestTask : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .viewModelModule(ViewModelModule(this))
            .build()
    }
}