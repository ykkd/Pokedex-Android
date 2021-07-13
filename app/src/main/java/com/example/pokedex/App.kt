package com.example.pokedex

import android.app.Application
import com.example.api.di.networkModule
import com.example.domain.di.serviceModule
import com.example.pokedex.di.viewModelModule
import com.example.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    serviceModule,
                    viewModelModule
                )
            )
        }
    }
}