package com.udacoding.kotlinsimpleecommerce.Repository

import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.Model.Login.ResponseLogin
import com.udacoding.kotlinsimpleecommerce.Model.Register.ResponseRegister
import com.udacoding.kotlinsimpleecommerce.Network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryUser {

    private val api = NetworkModule.getService()
    private val composite = CompositeDisposable()

    //login
    fun loginApi(
        username: String,
        password: String,
        responHandler: (ResponseLogin) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        composite.add(
            api.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                }, {
                    errorHandler(it)
                })
        )
    }

    //register
    fun registerApi(
        username: String,
        password: String,
        fullname: String,
        nohp: String,
        alamat: String,
        responHandler: (ResponseRegister)-> Unit,
        errorHandler: (Throwable)-> Unit
    ) {
        composite.add(
            api.register(username, password, fullname, nohp, alamat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }

    fun onClear(){
        composite.clear()
    }

}