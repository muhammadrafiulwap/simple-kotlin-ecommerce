package com.udacoding.kotlinsimpleecommerce.ui.produkbykategori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.kotlinsimpleecommerce.R

class ProdukByKategori : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.produk_by_kategori_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProdukByKategoriFragment.newInstance())
                .commitNow()
        }
    }

}
