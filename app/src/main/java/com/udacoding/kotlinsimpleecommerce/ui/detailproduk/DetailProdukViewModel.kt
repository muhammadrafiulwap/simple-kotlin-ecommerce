package com.udacoding.kotlinsimpleecommerce.ui.detailproduk

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.AddKeranjang.ResponseAddKeranjang
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryProduk

class DetailProdukViewModel : ViewModel() {
    private val repository = RepositoryProduk()

    //live data
    var responAddKeranjang = MutableLiveData<ResponseAddKeranjang>()

    var apiError = MutableLiveData<Throwable>()

    fun AddToKeranjang(id_user: String, id_produk: String) {

        repository.addKeranjangApi(
            id_user,
            id_produk, {
                responAddKeranjang.value = it
            }, {
                apiError.value = it
            }
        )
    }

}
