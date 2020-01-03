package com.udacoding.kotlinsimpleecommerce.ui.register

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.hide
import com.udacoding.kotlinsimpleecommerce.Utils.show
import kotlinx.android.synthetic.main.register_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.toast

class RegisterFragment : Fragment(), RegisterListener {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        viewModel.registerListener = this

        btnRegister.onClick {
            viewModel.registerUser("${etUsername.text}","${etPassword.text}", "${etFullname.text}","${etNoHp.text}","${etAlamat.text}")
        }

    }

    override fun onStarted() {
        pbRegister.show()
    }

    override fun onSuccess(message: String) {
        pbRegister.hide()
        activity?.toast(message)
        activity?.finish()
    }

    override fun onFailured(message: String) {
        pbRegister.hide()
        activity?.toast(message)
    }

}
