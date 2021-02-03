package com.bad.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

data class Company(

	@ColumnInfo
	@Json(name="bs")
	val bs: String? = null,

	@ColumnInfo
	@Json(name="catchPhrase")
	val catchPhrase: String? = null,

	@ColumnInfo(name = "company_name")
	@Json(name="name")
	val name: String? = null
)