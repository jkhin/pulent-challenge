package io.jk.pulent.challenge.core.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.core.net.ConnectivityManagerCompat
import org.koin.core.KoinComponent
import org.koin.core.inject

object NetworkUtils : KoinComponent {

    private val context by inject<Context>()

    fun hasInternetConnection(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activityNetwork = cm.activeNetwork ?: return false
            val networkCapabilities =
                cm.getNetworkCapabilities(activityNetwork) ?: return false
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        } else ConnectivityManagerCompat.isActiveNetworkMetered(cm)

    }

}