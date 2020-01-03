package com.udacoding.kotlinsimpleecommerce.Model.Register

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("nohp")
	val nohp: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("fullname")
	val fullname: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
)