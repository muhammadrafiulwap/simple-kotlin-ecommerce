package com.udacoding.kotlinsimpleecommerce.ui.keranjang

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang.DataItem
import com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang.ResponseListKeranjang
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.hide
import com.udacoding.kotlinsimpleecommerce.Utils.show
import com.udacoding.kotlinsimpleecommerce.ui.keranjang.adapter.KeranjangAdapter
import kotlinx.android.synthetic.main.keranjang_fragment.*

class KeranjangFragment : Fragment() {

    companion object {
        fun newInstance() = KeranjangFragment()
    }

    private lateinit var viewModel: KeranjangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.keranjang_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(KeranjangViewModel::class.java)

        viewModel.showKeranjang()

        attachObserve()
    }

    private fun attachObserve() {
        viewModel.responKeranjang.observe(this, Observer { showResponse(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
    }

    private fun showLoading(it: Boolean?) {
        if (it ?: false){
            pbKeranjang.show()
        } else {
            pbKeranjang.hide()
        }
    }

    private fun showResponse(it: ResponseListKeranjang?) {
        listKeranjang.adapter = KeranjangAdapter(it?.data, object : KeranjangAdapter.onItemClickListener {
            override fun itemClick(item: DataItem?) {

            }

        })
    }

}
