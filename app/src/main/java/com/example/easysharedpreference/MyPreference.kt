package com.example.easysharedpreference

import android.content.Context
import android.content.SharedPreferences


class MyPreference(context: Context) {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences =
            context.getSharedPreferences("preference_file", 0)
    }

    fun saveData(key: String, value: String) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun getData(key: String): String {
        return sharedPreferences.getString(key, "").toString()
    }

    companion object {
        private var yourPreference: MyPreference? = null
        fun getInstance(context: Context): MyPreference? {
            if (yourPreference == null) {
                yourPreference = MyPreference(context)
            }
            return yourPreference
        }
    }
}