package com.udacoding.kotlinsimpleecommerce.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.udacoding.kotlinsimpleecommerce.Model.Login.ResponseLogin
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.SessionManager
import com.udacoding.kotlinsimpleecommerce.Utils.hide
import com.udacoding.kotlinsimpleecommerce.Utils.show
import com.udacoding.kotlinsimpleecommerce.ui.home.Home
import com.udacoding.kotlinsimpleecommerce.ui.register.Register
import kotlinx.android.synthetic.main.login_fragment.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private var session: SessionManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        session = SessionManager(context!!)

        if (session?.isLogin ?: false){
            startActivity(intentFor<Home>().clearTop().newTask().clearTask())
        }

        attachObserve()

        cvLogin.onClick {
            viewModel.loginUser("${etUsername.text}", "${etPassword.text}")
        }

        cvRegister.onClick {
            startActivity<Register>()
        }
    }

    fun attachObserve() {
        viewModel.responseLogin.observe(this, Observer { showResponse(it) })
        viewModel.apiError.observe(this, Observer { showError(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isEmpty.observe(this, Observer { showIsEmpty(it) })
    }

    private fun showIsEmpty(it: Boolean?) {
        if (it ?: true) {
            alert ("Username or password invalid", "Warning") {
                yesButton {  }
            }.show()
        }

       //if (it == true) Log.d("ERROR", "Username or password invalid")
    }



    private fun showError(it: Throwable?) {
        alert(it?.message ?: "", "Warning" ){
            yesButton {  }
        }.show()
    }

    private fun showLoading(it: Boolean?) = if (it ?: false) pbLogin.show() else pbLogin.hide()

    private fun showResponse(it: ResponseLogin?) {

        if (it?.status ?: false) {
            session?.createLoginSession("1")
            session?.iduser = it?.data?.id
            session?.fullname = it?.data?.fullname
            session?.nohp = it?.data?.nohp
            session?.alamat = it?.data?.alamat
            startActivity(intentFor<Home>().clearTop().newTask().clearTask())
        } else {
            alert(it?.message ?: "", "Warning"){
                yesButton {  }
            }.show()
        }
    }

}
