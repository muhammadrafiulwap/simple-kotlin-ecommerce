package com.udacoding.kotlinsimpleecommerce.ui.produkbykategori.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.DataItem
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.Constan
import com.udacoding.kotlinsimpleecommerce.Utils.formatToRupiah
import kotlinx.android.synthetic.main.item_produk_kategori.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ListProdukByKategoriAdapter(private var mValues: List<DataItem>?, private var listener: onItemClickListener) :
    RecyclerView.Adapter<ListProdukByKategoriAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_produk_kategori,
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun getItemCount(): Int = mValues?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues?.get(position)

        holder.mNama.text = item?.nama
        holder.mHarga.text = formatToRupiah(item?.harga ?: "")
        holder.mJenis.text = item?.kategori
        Glide.with(holder.mImage).load(Constan.IMAGE_URL + item?.gambar).into(holder.mImage)

        holder.view.onClick {
            listener.itemClick(item)
        }

    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val mImage = view.ivProduk
        val mNama = view.tvNama
        val mHarga = view.tvHarga
        val mJenis = view.tvJenis

    }

    interface onItemClickListener {
        fun itemClick(item: DataItem?)
    }
}