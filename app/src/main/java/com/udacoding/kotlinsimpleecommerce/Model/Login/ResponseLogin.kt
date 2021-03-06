package com.udacoding.kotlinsimpleecommerce.Model.Login

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@field:SerializedName("respon")
	val respon: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)