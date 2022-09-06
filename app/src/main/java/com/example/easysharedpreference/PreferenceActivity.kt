package com.example.easysharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.example.easysharedpreference.Constants.CHECKBOX
import com.example.easysharedpreference.Constants.SWITCH
import com.example.easysharedpreference.PrefUtil.initPrefUtil
import com.example.easysharedpreference.databinding.ActivityPreferenceBinding

class PreferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = getString(R.string.general_options)
        initPrefUtil(this)
        setUpCheckbox()
        setUpSwitch()
    }

    private fun setUpCheckbox(){
        val checkBox = binding.checkbox
        checkBox.isChecked = PrefUtil.getCheckedMode(CHECKBOX)
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            PrefUtil.setCheckedMode(CHECKBOX, isChecked)
        }
    }

    private fun setUpSwitch(){
        val switch = binding.switchMode
        switch.isChecked = PrefUtil.getCheckedMode(SWITCH)

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            PrefUtil.setCheckedMode(SWITCH, isChecked)
        }
    }
}