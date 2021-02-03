package com.bad.app

import android.app.Application
import com.bad.data.MyRepository
import com.bad.data.local.MyDatabase
import com.bad.data.remote.MyRetrofit
import timber.log.Timber

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

class MyApplication: Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    /**
     * Companion members
     * */
    companion object {
        private lateinit var instance: MyApplication

        /**
         * Get application context
         *
         * @return applicationContext
         * */
        fun getApplicationContext() = instance.applicationContext


        private var repository: MyRepository? = null

        /**
         * Get my repository
         *
         * @return repository
         * */
        fun getRepository() : MyRepository {
            return if (repository != null) {
                repository!!
            } else {
                repository = MyRepository(MyDatabase.getInstance(getApplicationContext()),MyRetrofit.apis())
                repository!!
            }
        }
    }
}