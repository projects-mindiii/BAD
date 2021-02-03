package com.bad.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bad.MainViewModel
import com.bad.data.MyRepository
import java.lang.IllegalArgumentException

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

class ViewModelFactory(private val repository: MyRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java))  {
            MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown class $modelClass")
        }
    }
}