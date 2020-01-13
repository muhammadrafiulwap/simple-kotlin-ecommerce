package com.udacoding.kotlinsimpleecommerce.ui.keranjang

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.AddKeranjang.ResponseAddKeranjang
import com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang.ResponseListKeranjang
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryProduk

class KeranjangViewModel : ViewModel() {

    private val repository = RepositoryProduk()

    //live data
    var responKeranjang = MutableLiveData<ResponseListKeranjang>()

    var responDelKeranjang = MutableLiveData<ResponseAddKeranjang>()

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

    fun delKeranjang(id: String){
        isLoading.value = true
        repository.delKeranjangApi(id,
            {
                responDelKeranjang.value = it
                showKeranjang()
                isLoading.value = false
            }, {
                apiError.value = it
                isLoading.value = false
            })
    }
}
