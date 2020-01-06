package com.udacoding.kotlinsimpleecommerce.ui.produkbykategori

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.DataItem
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.ui.detailproduk.DetailProduk
import com.udacoding.kotlinsimpleecommerce.ui.produkbykategori.adapter.ListProdukByKategoriAdapter
import kotlinx.android.synthetic.main.produk_by_kategori_fragment.*
import org.jetbrains.anko.support.v4.startActivity

class ProdukByKategoriFragment : Fragment() {

    companion object {
        fun newInstance() = ProdukByKategoriFragment()
    }

    private lateinit var viewModel: ProdukByKategoriViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.produk_by_kategori_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProdukByKategoriViewModel::class.java)

        val id_kategori = activity?.intent?.getStringExtra("id_kategori")
        viewModel.getListProdukByKategori(id_kategori ?: "")

        attachObserve()

    }

    private fun attachObserve() {
        viewModel.responProduk.observe(this, Observer { showProduk(it) })
    }

    private fun showProduk(it: ResponseListProduk?) {
        listProduk.adapter = ListProdukByKategoriAdapter(
            it?.data,
            object : ListProdukByKategoriAdapter.onItemClickListener {
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

}
