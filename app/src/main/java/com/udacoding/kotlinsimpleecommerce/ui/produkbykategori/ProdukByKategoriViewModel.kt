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

    fun getListProdukByKategori(id_kategori: String){
        repository.getProdukByKategoriApi(
            id_kategori, {
                responProduk.value = it
            }, {
                errorApi.value = it
            }
        )
    }
}
