package com.udacoding.kotlinsimpleecommerce.Utils

import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}

