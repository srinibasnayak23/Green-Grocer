package com.example.gronic.data.local

import android.content.Context

class Prefs(context: Context) {
    private val prefs = context.getSharedPreferences("gronic_prefs", Context.MODE_PRIVATE)

    fun saveUser(email: String, name: String? = null, empId: String? = null) {
        prefs.edit().apply {
            putString("email", email)
            putString("name", name)
            putString("emp_id", empId)
            apply()
        }
    }

    fun getUser(): String? = prefs.getString("email", null)

    fun getUserName(): String? {
        return prefs.getString("username", null)
    }

    fun clearUser() {
        prefs.edit().clear().apply()
    }

    fun getProfileImageResource(): String? {
        return prefs.getString("img_path", null)
    }
}
