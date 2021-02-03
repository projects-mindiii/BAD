package com.bad.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bad.model.User
import io.reactivex.Single

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE id=:id LIMIT 1")
    fun get(id: Int) : Single<User>

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): User
}