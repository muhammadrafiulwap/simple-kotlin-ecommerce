package com.udacoding.kotlinsimpleecommerce.ui.keranjang.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udacoding.kotlinsimpleecommerce.Model.ListKeranjang.DataItem
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.Constan
import com.udacoding.kotlinsimpleecommerce.Utils.formatToRupiah
import kotlinx.android.synthetic.main.item_keranjang.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class KeranjangAdapter(
    private var mValues: List<DataItem>?,
    private var listener: onItemClickListener
) :
    RecyclerView.Adapter<KeranjangAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_keranjang,
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
