package com.udacoding.kotlinsimpleecommerce.ui.home.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.udacoding.kotlinsimpleecommerce.Model.ListKategori.ResponseKategori
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.DataItem
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.hide
import com.udacoding.kotlinsimpleecommerce.Utils.show
import com.udacoding.kotlinsimpleecommerce.ui.detailproduk.DetailProduk
import com.udacoding.kotlinsimpleecommerce.ui.home.HomeViewModel
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.ListKategoriAdapter
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.ListProdukAdapter
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.SliderAdapter
import com.udacoding.kotlinsimpleecommerce.ui.produkbykategori.ProdukByKategori
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.getListProdukPromo()
        viewModel.getListProduk()
        viewModel.getListKategori()

        attachObserve()

    }

    private fun attachObserve() {
        viewModel.responProdukPromo.observe(this, Observer { showImageSlider(it) })
        viewModel.responProduk.observe(this, Observer { showListProduk(it) })
        viewModel.responKategori.observe(this, Observer { showListKategori(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.errorApi.observe(this, Observer { showError(it) })
    }

    private fun showLoading(it: Boolean?) {
        if (it ?: false) {
            pbKategori.show()
            pbProduk.show()
        } else {
            pbKategori.hide()
            pbProduk.hide()
        }
    }

    private fun showError(it: Throwable?) {
        Log.d("ERROR",it?.message ?: "")
    }

    private fun showListKategori(it: ResponseKategori?) {
        listKategori.adapter = ListKategoriAdapter(it?.data, object: ListKategoriAdapter.onItemClickListener {
            override fun itemClick(item: com.udacoding.kotlinsimpleecommerce.Model.ListKategori.DataItem?) {
                startActivity<ProdukByKategori>(
                    "id_kategori" to item?.id,
                    "kategori" to item?.kategori
                )
            }


        })
    }

    private fun showListProduk(it: ResponseListProduk?) {
        listProduk.adapter = ListProdukAdapter(it?.data, object: ListProdukAdapter.onItemClickListener {
            override fun itemClick(item: DataItem?) {
                startActivity<DetailProduk>(
                    "id" to item?.id,
                    "nama" to item?.nama,
                    "deskripsi" to item?.deskripsi,
                    "harga" to item?.harga,
                    "gambar" to item?.gambar)
            }
        })
    }

    private fun showImageSlider(it: ResponseListProduk?) {
        imageSlider.sliderAdapter = SliderAdapter(it?.data, object : SliderAdapter.OnItemClickListener {
            override fun itemClick(dataItem: DataItem?) {
                startActivity<DetailProduk>(
                    "id" to dataItem?.id,
                    "nama" to dataItem?.nama,
                    "deskripsi" to dataItem?.deskripsi,
                    "harga" to dataItem?.harga,
                    "gambar" to dataItem?.gambar
                )
            }

        })
    }
}
