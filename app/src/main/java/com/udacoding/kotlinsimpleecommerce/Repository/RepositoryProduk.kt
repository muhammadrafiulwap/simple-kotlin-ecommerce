package com.udacoding.kotlinsimpleecommerce.Repository

import com.udacoding.kotlinsimpleecommerce.Model.ListKategori.ResponseKategori
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.Network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryProduk {

    private val api = NetworkModule.getService()
    private val composite = CompositeDisposable()

    //getproduk
    fun getProdukApi(
        responHandler: (ResponseListProduk)-> Unit,
        errorHandler: (Throwable)-> Unit
    ) {
        composite.add(
            api.getProduk()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }

    //getproduk
    fun getProdukPromoApi(
        responHandler: (ResponseListProduk)-> Unit,
        errorHandler: (Throwable)-> Unit
    ) {
        composite.add(
            api.getProdukPromo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }

    //getkategori
    fun getKategoriApi(
        responHandler: (ResponseKategori)-> Unit,
        errorHandler: (Throwable)-> Unit
    ) {
        composite.add(
            api.getKategori()
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