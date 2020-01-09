package com.udacoding.kotlinsimpleecommerce.ui.produkbykategori

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryProduk

class ProdukByKategoriViewModel : ViewModel() {

    private val repository = RepositoryProduk()

    //live data
    val responProduk = MutableLiveData<ResponseListProduk>()

    val errorApi = MutableLiveData<Throwable>()

    val isLoading = MutableLiveData<Boolean>()

    fun getListProdukByKategori(id_kategori: String){
        isLoading.value = true
        repository.getProdukByKategoriApi(
            id_kategori, {
                responProduk.value = it
                isLoading.value = false
            }, {
                errorApi.value = it
                isLoading.value = false
            }
        )
    }
}
