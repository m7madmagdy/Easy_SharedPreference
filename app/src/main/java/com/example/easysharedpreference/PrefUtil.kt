package com.example.easysharedpreference

import android.content.Context
import android.content.SharedPreferences
import com.example.easysharedpreference.Constants.PREF_FILE

object PrefUtil {
    private var sharedPreferences: SharedPreferences? = null

    fun initPrefUtil(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(PREF_FILE, 0)
    }

    fun saveData(key: String, value: String) {
        val prefsEditor = sharedPreferences?.edit()
        prefsEditor?.putString(key, value)
        prefsEditor?.apply()
    }

    fun getData(key: String): String {
        return sharedPreferences?.getString(key, "").toString()
    }

    fun setCheckedMode(key: String, value: Boolean) {
        val prefsEditor = sharedPreferences?.edit()
        prefsEditor?.putBoolean(key, value)
        prefsEditor?.apply()
    }

    fun getCheckedMode(key: String): Boolean {
        return sharedPreferences?.getBoolean(key, false)!!
    }
}