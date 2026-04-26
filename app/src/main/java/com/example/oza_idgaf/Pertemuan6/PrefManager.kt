package com.example.oza_idgaf.Pertemuan6

import android.content.Context

class PrefManager(context: Context) {

    private val pref = context.getSharedPreferences("LOGIN_PREF", Context.MODE_PRIVATE)
    private val editor = pref.edit()

    fun setLogin(isLogin: Boolean) {
        editor.putBoolean("isLogin", isLogin)
        editor.apply()
    }

    fun isLogin(): Boolean {
        return pref.getBoolean("isLogin", false)
    }

    fun logout() {
        editor.clear()
        editor.apply()
    }
}