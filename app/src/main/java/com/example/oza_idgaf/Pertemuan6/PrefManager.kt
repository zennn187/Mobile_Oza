package com.example.oza_idgaf

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {

    private val prefName = "BinaDesaPref"
    private val isLoginKey = "isLogin"
    private val userNameKey = "userName"
    private val userEmailKey = "userEmail"
    private val userRoleKey = "userRole"

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    // ✅ Property isLogin (biar bisa prefManager.isLogin)
    var isLogin: Boolean
        get() = sharedPreferences.getBoolean(isLoginKey, false)
        set(value) = sharedPreferences.edit().putBoolean(isLoginKey, value).apply()

    // Save login status
    fun setLoggedIn(isLoggedIn: Boolean) {
        editor.putBoolean(isLoginKey, isLoggedIn)
        editor.apply()
    }

    // Check login status (PERBAIKI)
    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(isLoginKey, false)  // ← Perbaiki: tambah isLoginKey
    }

    // Save user data (PERBAIKI)
    fun saveUserData(name: String, email: String, role: String) {  // ← Perbaiki: tambah parameter role
        editor.putString(userNameKey, name)
        editor.putString(userEmailKey, email)
        editor.putString(userRoleKey, role)  // ← Perbaiki: role sudah didefinisikan
        editor.apply()
    }

    // Get user name
    fun getUserName(): String {
        return sharedPreferences.getString(userNameKey, "") ?: ""
    }

    // Get user email
    fun getUserEmail(): String {
        return sharedPreferences.getString(userEmailKey, "") ?: ""
    }

    // Get user role
    fun getUserRole(): String {
        return sharedPreferences.getString(userRoleKey, "") ?: ""
    }

    // Clear all data (for logout)
    fun clearData() {
        editor.clear()
        editor.apply()
    }

    // Method logout
    fun logout() {
        clearData()
    }
}