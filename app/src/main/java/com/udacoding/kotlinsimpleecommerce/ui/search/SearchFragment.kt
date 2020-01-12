package com.udacoding.kotlinsimpleecommerce.ui.search

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.DataItem
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.hide
import com.udacoding.kotlinsimpleecommerce.Utils.show
import com.udacoding.kotlinsimpleecommerce.ui.detailproduk.DetailProduk
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.ListProdukAdapter
import com.udacoding.kotlinsimpleecommerce.ui.produkbykategori.adapter.ListProdukByKategoriAdapter
import kotlinx.android.synthetic.main.search_fragment.*
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.yesButton

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        acSearch.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.searchProduk(s.toString())
            }

        })

        attachObserve()


    }

    private fun attachObserve() {
        viewModel.responSearch.observe(this, Observer { showResponse(it) })
        viewModel.errorApi.observe(this, Observer { showError(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
    }

    private fun showLoading(it: Boolean?) {
        if (it ?: false) pbSearch.show() else pbSearch.hide()
    }

    private fun showError(it: Throwable?) {
        alert(it?.message.toString(), "Error"){
            yesButton {  }
        }.show()
    }

    private fun showResponse(it: ResponseListProduk?) {
        listProduk.adapter = ListProdukByKategoriAdapter(it?.data, object : ListProdukByKategoriAdapter.onItemClickListener {
            override fun itemClick(item: DataItem?) {
                startActivity<DetailProduk>(
                    "id" to item?.id,
                    "nama" to item?.nama,
                    "deskripsi" to item?.deskripsi,
                    "harga" to item?.harga,
                    "gambar" to item?.gambar
                )
            }

        })
    }

}
