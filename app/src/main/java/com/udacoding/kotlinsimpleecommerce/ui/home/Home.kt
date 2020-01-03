package com.udacoding.kotlinsimpleecommerce.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.ui.home.fragment.HomeFragment
import com.udacoding.kotlinsimpleecommerce.ui.home.fragment.ProfileFragment
import kotlinx.android.synthetic.main.home_activity.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = HomeFragment()
        addFragment(fragment)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_home -> {
                val fragment = HomeFragment()
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
