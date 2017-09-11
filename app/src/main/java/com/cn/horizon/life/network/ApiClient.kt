package com.cn.horizon.life.network

import com.cn.horizon.life.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by horizony on 2017/8/29.
 */
object ApiClient {
    fun retrofit(): ApiService {
        val builder = OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            val logInterceptor = HttpLoggingInterceptor();
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logInterceptor)
        }
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiService.API_SERVER_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java);
    }
}