package com.udacoding.kotlinsimpleecommerce.ui.keranjang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.kotlinsimpleecommerce.R

class keranjang : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keranjang_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, KeranjangFragment.newInstance())
                .commitNow()
        }
    }

}
