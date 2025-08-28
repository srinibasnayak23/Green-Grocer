package com.example.gronic.data.local

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("gronic_prefs", Context.MODE_PRIVATE)

    fun saveUser(email: String) {
        prefs.edit().putString("user_email", email).apply()
    }

    fun getUser(): String? {
        return prefs.getString("user_email", null)
    }

    fun clearUser() {
        prefs.edit().remove("user_email").apply()
    }
}
