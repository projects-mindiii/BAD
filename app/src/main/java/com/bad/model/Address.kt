package com.bad.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import com.squareup.moshi.Json

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

data class Address(

	@ColumnInfo
	@Json(name="zipcode")
	val zipcode: String? = null,

	@Embedded
	@Json(name="geo")
	val geo: Geo? = null,

	@ColumnInfo
	@Json(name="suite")
	val suite: String? = null,

	@ColumnInfo
	@Json(name="city")
	val city: String? = null,

	@ColumnInfo
	@Json(name="street")
	val street: String? = null
)