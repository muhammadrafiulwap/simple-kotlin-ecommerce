package com.udacoding.kotlinsimpleecommerce.ui.login

interface LoginListener {

    fun onStarted()
    fun onSuccess(message: String)
    fun onFailured(message: String)
}