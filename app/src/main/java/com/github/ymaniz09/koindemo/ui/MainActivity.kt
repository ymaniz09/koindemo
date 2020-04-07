package com.github.ymaniz09.koindemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ymaniz09.koindemo.R
import com.github.ymaniz09.koindemo.data.DataRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val currenciesListAdapter: CurrenciesListAdapter by inject()
    private val currenciesViewModel: CurrenciesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val currenciesJson = resources.openRawResource(R.raw.currencies)
            .bufferedReader().use { it.readText() }

        currenciesViewModel.getCurrencies(currenciesJson)

        observeStreams()
    }

    private fun observeStreams() {
        currenciesViewModel.observeCurrencies().observe(this, Observer {
            currenciesListAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        recyclerViewCurrencies.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = currenciesListAdapter
        }
    }
}
