package com.bad.data


import com.bad.data.local.MyDatabase
import com.bad.data.remote.ApiService
import com.bad.model.User
import io.reactivex.Single

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

class MyRepository constructor(private val database: MyDatabase, private val apiService: ApiService) {

    /**
     * Find user by id, it will call api first and if get any error will try to fetch data from room db
     *
     * Currently there is limitation in error centralized handling, feel free to improvise that
     *
     * @param id
     * @return user single
     * */
    fun findUserById(id: Int): Single<User> {
        return apiService.getUserById(id)
            .doOnSuccess { user ->
                database.userDao().insert(user = user)
            }.onErrorResumeNext {
                database.userDao().get(id = id)
            }
    }
}