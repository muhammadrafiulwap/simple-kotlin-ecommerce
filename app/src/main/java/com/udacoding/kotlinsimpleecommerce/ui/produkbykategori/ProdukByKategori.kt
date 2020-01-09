package com.udacoding.kotlinsimpleecommerce.ui.produkbykategori

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.kotlinsimpleecommerce.R
import kotlinx.android.synthetic.main.produk_by_kategori_activity.*

class ProdukByKategori : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.produk_by_kategori_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProdukByKategoriFragment.newInstance())
                .commitNow()
        }

        titleBar.text = "Kategori "+intent?.getStringExtra("kategori")

    }

}
