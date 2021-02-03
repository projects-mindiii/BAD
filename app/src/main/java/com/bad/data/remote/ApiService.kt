package com.bad.data.remote

import com.bad.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

interface ApiService {

    /**
     * Fetch user by id from server
     *
     * @param id user id
     * @return observable user
     * */
    @GET(Endpoints.USER)
    fun getUserById(@Path("id") id: Int) : Single<User>
}