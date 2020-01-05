package com.udacoding.kotlinsimpleecommerce.ui.detailproduk

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.Constan
import com.udacoding.kotlinsimpleecommerce.Utils.formatToRupiah
import kotlinx.android.synthetic.main.detail_produk_fragment.*
import java.text.NumberFormat
import java.util.*

class DetailProdukFragment : Fragment() {

    companion object {
        fun newInstance() = DetailProdukFragment()
    }

    private lateinit var viewModel: DetailProdukViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_produk_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailProdukViewModel::class.java)

        val localeId = Locale("in","ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeId)

        tvNama.text = activity?.intent?.getStringExtra("nama")
        tvDeskripsi.text = activity?.intent?.getStringExtra("deskripsi")
        tvHarga.text = formatToRupiah(activity?.intent?.getStringExtra("harga") ?: "")

        Glide.with(ivProduk).load(Constan.IMAGE_URL+activity?.intent?.getStringExtra("gambar")).into(ivProduk)
    }

}
