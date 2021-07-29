package com.knightsol.toolbox.Retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Moiz Hassan on 28, July,2021
 */

class APIClient {

    companion object {
        fun getClient(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build()


            var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/") //Base URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()



            return retrofit
        }
        fun getIPAddressClient(): Retrofit {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build()


            var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://api.ipify.org/") //Base URL

                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()



            return retrofit
        }
    }
}