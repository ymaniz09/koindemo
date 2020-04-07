package com.github.ymaniz09.koindemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ymaniz09.koindemo.R
import com.github.ymaniz09.koindemo.data.DataRepository
import com.github.ymaniz09.koindemo.data.DataRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val currenciesListAdapter: CurrenciesListAdapter by inject()
    private val dataRepository by inject<DataRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val currenciesJson = resources.openRawResource(R.raw.currencies)
            .bufferedReader().use { it.readText() }
        val items = dataRepository.getCurrencies(currenciesJson)
        currenciesListAdapter.submitList(items)
    }

    private fun setupRecyclerView() {
        recyclerViewCurrencies.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = currenciesListAdapter
        }
    }
}
