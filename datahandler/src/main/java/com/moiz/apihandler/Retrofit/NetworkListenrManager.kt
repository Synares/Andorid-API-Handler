package com.knightsol.toolbox.Retrofit

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.os.StrictMode
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import java.io.IOException
import java.net.HttpURLConnection
import java.net.InetAddress
import java.net.URL

/**
 * Created by Moiz Hassan on 28, July,2021
 */

object NetworkListenerManager {

    @Suppress("DEPRECATION")
    fun isInternetAvailable(context: Context): Boolean {
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm?.run {
//                cm.activeNetworkInfo?.run {
//                    if (type == ConnectivityManager.TYPE_WIFI) {
//                        result = true
//                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
//                        result = true
//                    }
//                }
                return true
            }
        }
        return result
    }

    fun onLocationMap(context: Context, url : String): Boolean {
            try {

                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)

                val urlc: HttpURLConnection =
                    URL(url).openConnection() as HttpURLConnection
                urlc.setRequestProperty("User-Agent", "Test")
                urlc.setRequestProperty("Connection", "close")
                urlc.connectTimeout = 3000
                urlc.connect()
                return urlc.responseCode == 404

            } catch (e: IOException) {
                Log.e("NetworkError", "Error checking internet connection " + e.message )
            }

        return false
    }

}