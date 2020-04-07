package com.github.ymaniz09.koindemo.data

import com.github.ymaniz09.koindemo.model.Currency

interface DataRepository {
    fun getCurrencies(jsonString: String): List<Currency>
}