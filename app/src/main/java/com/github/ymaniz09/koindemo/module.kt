package com.github.ymaniz09.koindemo

import com.github.ymaniz09.koindemo.data.DataRepository
import com.github.ymaniz09.koindemo.data.DataRepositoryImpl
import com.github.ymaniz09.koindemo.ui.CurrenciesListAdapter
import com.google.gson.Gson
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    factory { CurrenciesListAdapter() }
    factory<DataRepository> { DataRepositoryImpl(get()) }
}