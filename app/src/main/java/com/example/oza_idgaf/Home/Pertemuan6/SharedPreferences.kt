package com.example.oza_idgaf.Home.Pertemuan6

import android.content.Context
import android.content.SharedPreferences as AndroidSharedPreferences

class SharedPreferences(context: Context) {

    private val prefName = "BinaDesaPref"
    private val isLoginKey = "isLogin"
    private val userNameKey = "userName"
    private val userEmailKey = "userEmail"
    private val userRoleKey = "userRole"

    private val keyNama = "key_nama"
    private val keyTglLahir = "key_tgl_lahir"
    private val keyGender = "key_gender"
    private val keyPassword = "key_password"
    private val keyConfirmPassword = "key_confirm_password"

    private val sharedPreferences: AndroidSharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    private val editor: AndroidSharedPreferences.Editor = sharedPreferences.edit()

    var isLogin: Boolean
        get() = sharedPreferences.getBoolean(isLoginKey, false)
        set(value) = sharedPreferences.edit().putBoolean(isLoginKey, value).apply()

    fun setLoggedIn(isLoggedIn: Boolean) {
        editor.putBoolean(isLoginKey, isLoggedIn)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(isLoginKey, false)
    }

    fun saveUserData(name: String, email: String, role: String) {
        editor.putString(userNameKey, name)
        editor.putString(userEmailKey, email)
        editor.putString(userRoleKey, role)
        editor.apply()
    }

    fun saveRegistrationData(
        nama: String,
        email: String,
        tglLahir: String,
        gender: String,
        username: String,
        passwordKey: String,
        confirmPasswordKey: String
    ) {
        editor.putString(keyNama, nama)
        editor.putString(userEmailKey, email)
        editor.putString(keyTglLahir, tglLahir)
        editor.putString(keyGender, gender)
        editor.putString(userNameKey, username)
        editor.putString(keyPassword, passwordKey)
        editor.putString(keyConfirmPassword, confirmPasswordKey)
        editor.apply()
    }

    fun getUserName(): String {
        return sharedPreferences.getString(userNameKey, "") ?: ""
    }

    fun getUserEmail(): String {
        return sharedPreferences.getString(userEmailKey, "") ?: ""
    }

    fun getUserRole(): String {
        return sharedPreferences.getString(userRoleKey, "") ?: ""
    }

    fun getNama(): String {
        return sharedPreferences.getString(keyNama, "") ?: ""
    }

    fun getTglLahir(): String {
        return sharedPreferences.getString(keyTglLahir, "") ?: ""
    }

    fun getGender(): String {
        return sharedPreferences.getString(keyGender, "") ?: ""
    }

    fun getPassword(): String {
        return sharedPreferences.getString(keyPassword, "") ?: ""
    }

    fun getConfirmPassword(): String {
        return sharedPreferences.getString(keyConfirmPassword, "") ?: ""
    }

    // Contoh implementasi di dalam PrefManager Anda
    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor.putBoolean("IsFirstTimeLaunch", isFirstTime)
        editor.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return sharedPreferences.getBoolean("IsFirstTimeLaunch", true) // Default true
    }

    fun clearData() {
        editor.clear()
        editor.apply()
    }

    fun logout() {
        clearData()
    }
}