package com.udacoding.kotlinsimpleecommerce.Repository

import com.udacoding.kotlinsimpleecommerce.Model.Login.ResponseLogin
import com.udacoding.kotlinsimpleecommerce.Network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginRepository {

    private val api = NetworkModule.getService()
    private val composite = CompositeDisposable()

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
}