package com.udacoding.kotlinsimpleecommerce.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.Register.ResponseRegister
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryUser

class RegisterViewModel : ViewModel() {

    private val repository = RepositoryUser()

    //live data
    var responseRegister = MutableLiveData<ResponseRegister>()

    var apiError = MutableLiveData<Throwable>()

    var isLoading = MutableLiveData<Boolean>()

    var isEmpty = MutableLiveData<Boolean>()

    var finish = MutableLiveData<Boolean>()

    fun registerUser(username: String, password: String, fullname: String, nohp: String, alamat: String) {
        isLoading.value = true
        if (username.isNotEmpty() && password.isNotEmpty() && fullname.isNotEmpty() && nohp.isNotEmpty() && alamat.isNotEmpty()) {
            //success
            repository.registerApi(username,password,fullname,nohp,alamat,
                {
                    responseRegister.value = it
                    isLoading.value = false
                    finish.value = true
                }, {
                    apiError.value = it
                    isLoading.value = false
                })
        } else {
            //error
            isLoading.value = false
            isEmpty.value = true
        }
    }
}
