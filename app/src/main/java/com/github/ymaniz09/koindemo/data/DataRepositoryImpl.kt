package com.github.ymaniz09.koindemo.data

import com.github.ymaniz09.koindemo.model.Currency
import com.google.gson.Gson

class DataRepositoryImpl(private val gson: Gson) : DataRepository {
    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }
}