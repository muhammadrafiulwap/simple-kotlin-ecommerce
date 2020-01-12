package com.udacoding.kotlinsimpleecommerce.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryProduk

class SearchViewModel : ViewModel() {

    private val repository = RepositoryProduk()

    //live data
    var responSearch = MutableLiveData<ResponseListProduk>()

    var errorApi = MutableLiveData<Throwable>()

    var isLoading = MutableLiveData<Boolean>()

    fun searchProduk(produk: String){
        isLoading.value = true
        repository.searchApi(produk,
            {
                responSearch.value = it
                isLoading.value = false
            }, {
                errorApi.value = it
                isLoading.value = false
            })
    }
}
