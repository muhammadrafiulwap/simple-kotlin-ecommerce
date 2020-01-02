package com.udacoding.kotlinsimpleecommerce.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.hide
import com.udacoding.kotlinsimpleecommerce.Utils.show
import kotlinx.android.synthetic.main.login_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class LoginFragment : Fragment(), LoginListener {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        viewModel.loginListener = this

        btnLogin.onClick {
            viewModel.loginUser("${etUsername.text}","${etPassword.text}")
        }
    }

    override fun onStarted() {
        pbLogin.show()
    }

    override fun onSuccess(message: String) {
        pbLogin.hide()
        activity?.toast(message)
    }

    override fun onFailured(message: String) {
        pbLogin.hide()
        activity?.toast(message)
    }

}
