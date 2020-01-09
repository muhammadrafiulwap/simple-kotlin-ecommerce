package com.udacoding.kotlinsimpleecommerce.ui.keranjang

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang.ResponseListKeranjang
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryProduk

class KeranjangViewModel : ViewModel() {

    private val repository = RepositoryProduk()

    //live data
    var responKeranjang = MutableLiveData<ResponseListKeranjang>()

    var apiError = MutableLiveData<Throwable>()

    var isLoading = MutableLiveData<Boolean>()

    fun showKeranjang(){
        isLoading.value = true
        repository.getListKeranjangApi(
            {
                responKeranjang.value = it
                isLoading.value = false
            }, {
                apiError.value = it
                isLoading.value = false
            }
        )
    }
}
