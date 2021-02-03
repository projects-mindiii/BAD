package com.bad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bad.app.MyApplication
import com.bad.data.Resource
import com.bad.factory.ViewModelFactory
import com.bad.model.User
import timber.log.Timber

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MyApplication.getRepository()
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.findUserById(3)
        viewModel.user().observe(this, {
            when(it.status) {
                Resource.Status.SUCCESS -> {
                    Timber.d("${it.data as User}")
                }
                Resource.Status.ERROR -> {
                    Timber.e(it.data as Throwable)
                }
                Resource.Status.LOADING -> {
                    Timber.i("Loading...")
                }
            }
        })
    }
}