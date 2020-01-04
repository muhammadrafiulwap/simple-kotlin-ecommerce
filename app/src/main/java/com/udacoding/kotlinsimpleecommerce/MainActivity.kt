package com.udacoding.kotlinsimpleecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.udacoding.kotlinsimpleecommerce.ui.login.Login
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({

            startActivity<Login>()

        }, SPLASH_TIME_OUT)


    }
}
