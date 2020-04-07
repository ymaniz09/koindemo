package com.github.ymaniz09.koindemo.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.github.ymaniz09.koindemo.R
import com.github.ymaniz09.koindemo.model.Currency
import com.github.ymaniz09.koindemo.util.UrlHelper
import kotlinx.android.synthetic.main.view_currency.view.*
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class CurrencyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), KoinComponent {

    val urlHelper: UrlHelper by inject()

    init {
        View.inflate(context, R.layout.view_currency, this)
        orientation = HORIZONTAL
    }

    fun setCurrency(currency: Currency) {
        textName.text = currency.name
        textSymbol.text = currency.symbol

        setOnClickListener {
            urlHelper.launchCurrencyUrl(context, currency.slug)
        }
    }
}