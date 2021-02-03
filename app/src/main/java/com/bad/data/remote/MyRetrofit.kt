package com.bad.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

object MyRetrofit {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    /**
     * Create and return retrofit object, you may modify or add the okhttp, converter factory and call adapter factory
     * @return retrofit
     * */
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    /**
     * Create and return api service object
     *
     * @return api service
     * */
    fun apis() : ApiService {
        return retrofit().create(ApiService::class.java)
    }

}