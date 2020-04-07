package com.github.ymaniz09.koindemo

import com.github.ymaniz09.koindemo.data.DataRepository
import com.github.ymaniz09.koindemo.data.DataRepositoryFactory
import com.github.ymaniz09.koindemo.data.LocalDataRepository
import com.github.ymaniz09.koindemo.data.RemoteDataRepository
import com.github.ymaniz09.koindemo.ui.CurrenciesListAdapter
import com.github.ymaniz09.koindemo.ui.CurrenciesViewModel
import com.github.ymaniz09.koindemo.util.UrlHelper
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    single { UrlHelper(getProperty("currency_base_url")) }

    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }
    factory { DataRepositoryFactory(get("local"), get("remote")) }
}

val browseModule = module("browse") {
    factory { CurrenciesListAdapter() }
    viewModel { (jsonString: String) -> CurrenciesViewModel(get(), jsonString) }
}