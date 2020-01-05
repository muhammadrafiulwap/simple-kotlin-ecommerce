package com.udacoding.kotlinsimpleecommerce.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.ListKategori.ResponseKategori
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryProduk

class HomeViewModel : ViewModel() {

    private val repository = RepositoryProduk()

    //live data
    var responProduk = MutableLiveData<ResponseListProduk>()

    var responProdukPromo = MutableLiveData<ResponseListProduk>()

    var responKategori = MutableLiveData<ResponseKategori>()

    var errorApi = MutableLiveData<Throwable>()
//    var errorApiProdukPromo = MutableLiveData<Throwable>()
//    var errorApiKategori = MutableLiveData<Throwable>()

    var isLoading = MutableLiveData<Boolean>()

    fun getListProduk(){
        isLoading.value = true
        repository.getProdukApi(
            {
              responProduk.value = it
                isLoading.value = false
            }, {
                errorApi.value = it
                isLoading.value = false
            }
        )
    }

    fun getListProdukPromo(){
        isLoading.value = true
        repository.getProdukPromoApi(
            {
                responProdukPromo.value = it
                isLoading.value = false
            }, {
                errorApi.value = it
                isLoading.value = false
            }
        )
    }

    fun getListKategori(){
        isLoading.value = true
        repository.getKategoriApi(
            {
                responKategori.value = it
                isLoading.value = false
            }, {
                errorApi.value = it
                isLoading.value = false
            }
        )
    }

}
