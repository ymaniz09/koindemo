package com.github.ymaniz09.koindemo.util

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.github.ymaniz09.koindemo.R

class UrlHelper {

    fun launchCurrencyUrl(context: Context, slug: String) {
        launchUrl(context, Uri.parse("$BASE_URL$slug"))
    }

    fun launchUrl(context: Context, uri: Uri) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .addDefaultShareMenuItem()
            .setToolbarColor(
                ContextCompat.getColor(context, R.color.colorPrimary)
            )
            .setShowTitle(true)
            .build()
        customTabsIntent.launchUrl(context, uri)
    }

    companion object {
        private const val BASE_URL = "https://coinmarketcap.com/currencies/"
    }
}