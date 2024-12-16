package com.example.androidcourse

import android.app.Application
import com.example.androidcourse.di.AppComponent
import com.example.androidcourse.di.DaggerAppComponent

/**
 * @author t.shkolnik
 */
class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}
