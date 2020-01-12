package com.udacoding.kotlinsimpleecommerce.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.udacoding.kotlinsimpleecommerce.Model.ListProduk.ResponseListProduk
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Search
import com.udacoding.kotlinsimpleecommerce.ui.home.adapter.SliderAdapter
import com.udacoding.kotlinsimpleecommerce.ui.home.fragment.HomeFragment
import com.udacoding.kotlinsimpleecommerce.ui.home.fragment.ProfileFragment
import com.udacoding.kotlinsimpleecommerce.ui.keranjang.KeranjangFragment
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = HomeFragment()
        addFragment(fragment)

        ivSearch.onClick {
            startActivity<Search>()
        }

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_home -> {
                val fragment = HomeFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_cart -> {
                val fragment = KeranjangFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_profile -> {
                val fragment =
                    ProfileFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }


}
