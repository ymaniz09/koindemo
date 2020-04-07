package com.github.ymaniz09.koindemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ymaniz09.koindemo.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val currenciesListAdapter: CurrenciesListAdapter by inject()
    private val currenciesViewModel: CurrenciesViewModel by viewModel {
        val currenciesJson = resources.openRawResource(R.raw.currencies)
            .bufferedReader().use {
                it.readText()
            }
        parametersOf(currenciesJson)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindScope(getOrCreateScope("browse"))

        setupRecyclerView()

        currenciesViewModel.getCurrencies()

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
