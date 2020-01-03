package com.udacoding.kotlinsimpleecommerce.Repository

import com.udacoding.kotlinsimpleecommerce.Model.Register.ResponseRegister
import com.udacoding.kotlinsimpleecommerce.Network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RegisterRepository {

    private val api = NetworkModule.getService()
    private val composite = CompositeDisposable()

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
}