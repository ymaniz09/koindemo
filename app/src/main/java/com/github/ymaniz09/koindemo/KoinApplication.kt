package com.github.ymaniz09.koindemo

import android.app.Application
import org.koin.android.ext.android.startKoin

class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule))
    }
}