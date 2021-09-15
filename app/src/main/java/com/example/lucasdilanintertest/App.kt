package com.example.lucasdilanintertest

import android.app.Application
import com.example.lucasdilanintertest.di.repositoryModule
import com.example.lucasdilanintertest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

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
                repositoryModule
            ))
        }
    }
}