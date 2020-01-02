package com.udacoding.kotlinsimpleecommerce.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.kotlinsimpleecommerce.Model.Login.ResponseLogin
import com.udacoding.kotlinsimpleecommerce.Repository.LoginRepository

class LoginViewModel : ViewModel() {

    private val repository = LoginRepository()

    var loginListener: LoginListener? = null

    //live data
    var responseLogin = MutableLiveData<ResponseLogin>()
    var apiError = MutableLiveData<Throwable>()

    fun loginUser(username: String, password: String) {
        loginListener?.onStarted()
        if (username.isNotEmpty() && password.isNotEmpty()) {
            //success
            repository.loginApi(username, password,
                {
                    responseLogin.value = it
                    loginListener?.onSuccess(it.message ?: "")
                }, {
                    apiError.value = it
                    loginListener?.onFailured(it.message ?: "")
                })
        } else {
            //error
            loginListener?.onFailured("Username or password Invalid")
        }
    }
}
