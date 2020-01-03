package com.udacoding.kotlinsimpleecommerce.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.Register.ResponseRegister
import com.udacoding.kotlinsimpleecommerce.Repository.Repository

class RegisterViewModel : ViewModel() {

    private val repository = Repository()

    var registerListener: RegisterListener? = null

    //live data
    var responseRegister = MutableLiveData<ResponseRegister>()
    var apiError = MutableLiveData<Throwable>()

    fun registerUser(username: String, password: String, fullname: String, nohp: String, alamat: String) {
        registerListener?.onStarted()
        if (username.isNotEmpty() && password.isNotEmpty() && fullname.isNotEmpty() && nohp.isNotEmpty() && alamat.isNotEmpty()) {
            //success
            repository.registerApi(username,password,fullname,nohp,alamat,
                {
                    responseRegister.value = it
                    registerListener?.onSuccess(it.message ?: "")
                }, {
                    apiError.value = it
                    registerListener?.onFailured(it.message ?: "")
                })
        } else {
            //error
            registerListener?.onFailured("Data harus dilengkapi")
        }
    }
}
