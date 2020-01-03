package com.udacoding.kotlinsimpleecommerce.Utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager (internal val context: Context) {
    internal var pref: SharedPreferences
    internal var editor: SharedPreferences.Editor

    internal var PRIVATE_MODE = 0

    //0 agar cuma bisa dibaca pada hp itu sendiri

    internal var PREF_NAME = "KotlinSimpleEcommercePref"

    init {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object {
        private val KEY_TOKEN = "tokenLogin"
        private val KEY_LOGIN = "isLogin"
    }

    //membuat session login
    fun createLoginSession(token: String) {
        editor.putString(KEY_TOKEN, token)
        editor.putBoolean(KEY_LOGIN, true)
        editor.commit()
        //commit digunakan untuk menyimpan perubahan
    }

    //logout user
    fun logout(){
        editor.clear()
        editor.commit()
    }

    val token: String?
        get() = pref.getString(KEY_TOKEN, "")

    //cek login
    val isLogin: Boolean
        get() = pref.getBoolean(KEY_LOGIN, false)


}