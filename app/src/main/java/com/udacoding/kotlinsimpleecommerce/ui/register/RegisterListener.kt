package com.udacoding.kotlinsimpleecommerce.ui.register

interface RegisterListener {

    fun onStarted()
    fun onSuccess(message: String)
    fun onFailured(message: String)

}