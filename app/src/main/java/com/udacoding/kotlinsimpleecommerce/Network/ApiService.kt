package com.udacoding.kotlinsimpleecommerce.Network

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

    @GET("getProduk")
    fun getProduk(): Observable<ResponseListProduk>

}