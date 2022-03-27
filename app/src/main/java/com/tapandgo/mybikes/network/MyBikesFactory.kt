package com.tapandgo.mybikes.network

import com.squareup.moshi.Moshi
import com.tapandgo.mybikes.BuildConfig
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MyBikesFactory() {

    private val okHttpClient: OkHttpClient by lazy {
        val logger = HttpLoggingInterceptor()
        logger.level = BuildConfig.NETWORK_LOGGER_LEVEL

        OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    fun create(
        moshi: Moshi,
        baseUrl: HttpUrl = BuildConfig.URL_JCDECAUX.toHttpUrl()
    ): MyBikesService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(MyBikesService::class.java)
}