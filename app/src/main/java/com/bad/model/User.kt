package com.bad.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

@Entity
data class User(

	@ColumnInfo
	@Json(name="website")
	val website: String? = null,

	@Embedded
	@Json(name="address")
	val address: Address? = null,

	@ColumnInfo
	@Json(name="phone")
	val phone: String? = null,

	@ColumnInfo
	@Json(name="name")
	val name: String? = null,

	@Embedded
	@Json(name="company")
	val company: Company? = null,

	@PrimaryKey
	@Json(name="id")
	val id: Int? = null,

	@ColumnInfo
	@Json(name="email")
	val email: String? = null,

	@ColumnInfo
	@Json(name="username")
	val username: String? = null
)