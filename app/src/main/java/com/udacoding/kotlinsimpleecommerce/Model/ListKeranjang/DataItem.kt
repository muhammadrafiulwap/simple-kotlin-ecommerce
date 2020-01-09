package com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("id_produk")
	val idProduk: String? = null,

	@field:SerializedName("jumlah")
	val jumlah: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("harga")
	val harga: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("kategori")
	val kategori: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("id_user")
	val idUser: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
)