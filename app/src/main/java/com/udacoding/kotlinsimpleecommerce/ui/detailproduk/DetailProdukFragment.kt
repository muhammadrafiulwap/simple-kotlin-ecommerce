package com.udacoding.kotlinsimpleecommerce.ui.detailproduk

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.udacoding.kotlinsimpleecommerce.Model.AddKeranjang.ResponseAddKeranjang
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.Constan
import com.udacoding.kotlinsimpleecommerce.Utils.SessionManager
import com.udacoding.kotlinsimpleecommerce.Utils.formatToRupiah
import kotlinx.android.synthetic.main.detail_produk_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.yesButton
import java.text.NumberFormat
import java.util.*

class DetailProdukFragment : Fragment() {

    companion object {
        fun newInstance() = DetailProdukFragment()
    }

    private lateinit var viewModel: DetailProdukViewModel

    private var session: SessionManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_produk_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailProdukViewModel::class.java)

        session = SessionManager(context!!)

        tvNama.text = activity?.intent?.getStringExtra("nama")
        tvDeskripsi.text = activity?.intent?.getStringExtra("deskripsi")
        tvHarga.text = formatToRupiah(activity?.intent?.getStringExtra("harga") ?: "")

        val idproduk = activity?.intent?.getStringExtra("id")

        Glide.with(ivProduk).load(Constan.IMAGE_URL+activity?.intent?.getStringExtra("gambar")).into(ivProduk)

        cvAddToCart.onClick {
            viewModel.AddToKeranjang(session?.iduser ?: "", idproduk ?: "")
        }

        attachObserve()
    }

    private fun attachObserve() {
        viewModel.responAddKeranjang.observe(this, androidx.lifecycle.Observer { showResponse(it) })
    }

    private fun showResponse(it: ResponseAddKeranjang?) {
        if (it?.status ?: false){
            alert("${it?.data?.nama} success add to cart", "Confirmation"){
                yesButton {
                    activity?.finish()
                }
            }.show()
        }
    }

}
