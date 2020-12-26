package com.fachreinrachim.mymovies.api

import android.util.Log
import com.fachreinrachim.mymovies.constants.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
object Api {
    private val httpLoggingInterceptor: HttpLoggingInterceptor by lazy {
        val interceptor = HttpLoggingInterceptor { message -> Log.d("Http", message) }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(300, TimeUnit.SECONDS)
        .readTimeout(300, TimeUnit.SECONDS)
        .writeTimeout(300, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).apply {
            addInterceptor { chain ->
                val original: Request = chain.request()
                val requestBuilder = original.newBuilder()
//                    .header("X-Client-Type", BuildConfig.X_CLIENT_TYPE_VALUE)
                val request = requestBuilder.build()
                return@addInterceptor chain.proceed(request)
            }
        }

    @JvmStatic
    val clientCollection: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: ApiService by lazy {
        clientCollection.create(ApiService::class.java)
    }

}