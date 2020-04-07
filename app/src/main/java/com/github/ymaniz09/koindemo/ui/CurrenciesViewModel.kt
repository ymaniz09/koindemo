package com.github.ymaniz09.koindemo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ymaniz09.koindemo.data.DataRepositoryFactory
import com.github.ymaniz09.koindemo.model.Currency

class CurrenciesViewModel(private val dataRepositoryFactory: DataRepositoryFactory) : ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observeCurrencies(): MutableLiveData<List<Currency>> = currencyLiveData

    fun getCurrencies(jsonString: String) {
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }
}