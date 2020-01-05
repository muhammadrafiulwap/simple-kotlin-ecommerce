package com.udacoding.kotlinsimpleecommerce.Model.ListKategori

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("kategori")
	val kategori: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
)