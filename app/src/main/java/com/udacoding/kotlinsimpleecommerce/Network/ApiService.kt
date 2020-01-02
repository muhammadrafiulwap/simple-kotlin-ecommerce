package com.udacoding.kotlinsimpleecommerce.Network

import com.udacoding.kotlinsimpleecommerce.Model.Login.ResponseLogin
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Single<ResponseLogin>

}