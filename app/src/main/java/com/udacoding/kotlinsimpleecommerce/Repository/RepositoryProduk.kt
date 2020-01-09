package com.udacoding.kotlinsimpleecommerce.Repository

import androidx.lifecycle.LiveData
import com.udacoding.kotlinsimpleecommerce.Model.AddKeranjang.ResponseAddKeranjang
import com.udacoding.kotlinsimpleecommerce.Model.ListKategori.ResponseKategori
import com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang.ResponseListKeranjang
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.Network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryProduk {

    private val api = NetworkModule.getService()
    private val composite = CompositeDisposable()

    private lateinit var produkResult: LiveData<ResponseListProduk>


    fun Produk(): LiveData<ResponseListProduk>{
        return produkResult
    }


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

    //getprodukbykategori
    fun getProdukByKategoriApi(
        id_kategori: String,
        responHandler: (ResponseListProduk)-> Unit,
        errorHandler: (Throwable)-> Unit
    ) {
        composite.add(
            api.getProdukByKategori(id_kategori)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }

    //getlistkeranjang
    fun getListKeranjangApi(
        responHandler: (ResponseListKeranjang)-> Unit,
        errorHandler: (Throwable)-> Unit
    ) {
        composite.add(
            api.getKeranjang()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }

    //addkeranjang
    fun addKeranjangApi(
        id_user: String,
        id_produk: String,
        responHandler: (ResponseAddKeranjang)-> Unit,
        errorHandler: (Throwable)-> Unit
    ) {
        composite.add(
            api.addKeranjang(id_user, id_produk)
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