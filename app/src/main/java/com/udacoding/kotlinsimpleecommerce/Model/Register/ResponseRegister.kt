package com.udacoding.kotlinsimpleecommerce.Model.Register

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("respon")
	val respon: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)