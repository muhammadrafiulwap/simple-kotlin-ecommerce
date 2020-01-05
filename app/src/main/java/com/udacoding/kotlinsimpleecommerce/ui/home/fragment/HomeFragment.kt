package com.udacoding.kotlinsimpleecommerce.ui.home.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.udacoding.kotlinsimpleecommerce.Model.ListKategori.ResponseKategori
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.ui.home.HomeViewModel
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.ListKategoriAdapter
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.ListProdukAdapter
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.SliderAdapter
import kotlinx.android.synthetic.main.home_fragment.*

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
    }

    private fun showListKategori(it: ResponseKategori?) {
        listKategori.adapter = ListKategoriAdapter(it?.data)
    }

    private fun showListProduk(it: ResponseListProduk?) {
        listProduk.adapter = ListProdukAdapter(it?.data)
    }

    private fun showImageSlider(it: ResponseListProduk?) {
        imageSlider.sliderAdapter = SliderAdapter(it?.data)
    }
}
