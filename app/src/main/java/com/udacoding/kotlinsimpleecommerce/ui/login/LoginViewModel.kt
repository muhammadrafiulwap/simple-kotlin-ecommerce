package com.udacoding.kotlinsimpleecommerce.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.Login.ResponseLogin
import com.udacoding.kotlinsimpleecommerce.Repository.RepositoryUser

class LoginViewModel : ViewModel() {

    private val repository = RepositoryUser()

    //live data
    var responseLogin = MutableLiveData<ResponseLogin>()

    var apiError = MutableLiveData<Throwable>()

    var isLoading = MutableLiveData<Boolean>()

    var isEmpty = MutableLiveData<Boolean>()

    var finihActivity = MutableLiveData<Boolean>()

    fun loginUser(username: String, password: String) {
        isLoading.value = true
        if (username.isNotEmpty() && password.isNotEmpty()) {
            //success
            repository.loginApi(username, password,
                {
                    responseLogin.value = it
                    isLoading.value = false
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
