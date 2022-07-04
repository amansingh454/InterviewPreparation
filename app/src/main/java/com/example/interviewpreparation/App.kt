package com.example.interviewpreparation

import android.app.Application
import com.example.interviewpreparation.di.repositoryModule
import com.example.interviewpreparation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                viewModelModule + repositoryModule
            )
        }
    }

}