package com.example.myskills

import android.app.Application
import com.example.myskills.di.apiModule
import com.example.myskills.di.repositoryModule
import com.example.myskills.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import retrofitModule

class App: Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                viewModelModule,
                apiModule,
                repositoryModule,
                retrofitModule
            ))
        }
    }
}