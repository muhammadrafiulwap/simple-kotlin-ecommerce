package com.udacoding.kotlinsimpleecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.kotlinsimpleecommerce.ui.search.SearchFragment

class Search : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }

}
