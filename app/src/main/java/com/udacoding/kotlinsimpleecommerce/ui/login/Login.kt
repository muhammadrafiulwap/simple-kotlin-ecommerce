package com.udacoding.kotlinsimpleecommerce.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.kotlinsimpleecommerce.R

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }

}
