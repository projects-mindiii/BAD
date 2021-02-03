package com.bad.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bad.model.User
import com.bad.utils.SingletonBuilder

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

@Database(entities = [User::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    /**
     * This object holds the singleton of @see MyDatabase
     * */
    companion object: SingletonBuilder<MyDatabase, Context>({
        Room.databaseBuilder(it.applicationContext, MyDatabase::class.java,"my_db").build()
    })
}