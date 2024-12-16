package com.example.androidcourse.di

import android.content.Context
import com.example.androidcourse.di.module.DataBindsModule
import com.example.androidcourse.di.module.DataModule
import com.example.androidcourse.di.module.DomainModule
import com.example.androidcourse.di.module.PresentationModule
import com.example.androidcourse.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author t.shkolnik
 */
@Singleton
@Component(
    modules = [
        DataModule::class,
        DataBindsModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface AppComponentFactory {

        fun create(@BindsInstance context: Context): AppComponent
    }
}