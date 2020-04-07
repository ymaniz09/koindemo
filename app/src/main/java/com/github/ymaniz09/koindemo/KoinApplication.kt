package com.github.ymaniz09.koindemo

import android.app.Application
import com.github.ymaniz09.koindemo.di.KoinLogger
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin(
            this, listOf(
                applicationModule,
                browseModule
            ),
            loadProperties = true,
            logger = KoinLogger()
        )
    }
}