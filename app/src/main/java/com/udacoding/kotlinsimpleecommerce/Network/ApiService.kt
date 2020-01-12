package com.udacoding.kotlinsimpleecommerce.Network

import com.udacoding.kotlinsimpleecommerce.Model.AddKeranjang.ResponseAddKeranjang
import com.udacoding.kotlinsimpleecommerce.Model.ListKategori.ResponseKategori
import com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang.ResponseListKeranjang
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.Model.Login.ResponseLogin
import com.udacoding.kotlinsimpleecommerce.Model.Register.ResponseRegister
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Single<ResponseLogin>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("fullname") fullname: String,
        @Field("nohp") nohp: String,
        @Field("alamat") alamat: String
    ): Single<ResponseRegister>

    @FormUrlEncoded
    @POST("search")
    fun search(
        @Field("produk") produk: String
    ): Single<ResponseListProduk>

    @GET("getProduk")
    fun getProduk(): Observable<ResponseListProduk>

    @GET("getKeranjang")
    fun getKeranjang(): Observable<ResponseListKeranjang>

    @FormUrlEncoded
    @POST("addKeranjang")
    fun addKeranjang(
        @Field("iduser") id_user: String,
        @Field("idproduk") id_produk: String
    ): Single<ResponseAddKeranjang>

    @GET("getProdukPromo")
    fun getProdukPromo(): Observable<ResponseListProduk>

    @FormUrlEncoded
    @POST("getProdukByKategori")
    fun getProdukByKategori(
        @Field("id_kategori") id_kategori: String
    ): Observable<ResponseListProduk>

    @GET("getKategori")
    fun getKategori(): Observable<ResponseKategori>

}