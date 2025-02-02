package com.yasser.dailypulse.android

import android.app.Application
import com.yasser.dailypulse.dataBaseModule
import com.yasser.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@DailyPulseApp)
            modules(sharedKoinModule + viewModelsModule+ dataBaseModule)
        }
    }
}