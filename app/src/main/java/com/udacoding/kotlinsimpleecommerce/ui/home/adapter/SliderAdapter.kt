package com.udacoding.kotlinsimpleecommerce.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.DataItem
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.Constan
import kotlinx.android.synthetic.main.item_image_slider.view.*

class SliderAdapter (private val mValues: List<DataItem>?) : SliderViewAdapter<SliderAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val viewHolder = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_image_slider, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        val item = mValues?.get(position)

        viewHolder?.mText?.text = item?.nama
        Glide.with(viewHolder?.mImage!!).load(Constan.IMAGE_URL+item?.gambar).into(viewHolder.mImage)
    }

    override fun getCount(): Int = mValues?.size ?: 0


    inner class ViewHolder(view: View): SliderViewAdapter.ViewHolder(view) {

        val mView = view

        val mImage = view.iv_auto_image_slider
        val mText = view.tv_auto_image_slider


    }

}