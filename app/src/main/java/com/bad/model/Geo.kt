package com.bad.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

data class Geo(

	@ColumnInfo
	@Json(name="lng")
	val lng: String? = null,

	@ColumnInfo
	@Json(name="lat")
	val lat: String? = null
)