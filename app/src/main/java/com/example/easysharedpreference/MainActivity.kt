package com.example.easysharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.easysharedpreference.Constants.DATA_SAVED
import com.example.easysharedpreference.Constants.ENTER_NAME
import com.example.easysharedpreference.Constants.NO_DATA_FOUND
import com.example.easysharedpreference.Constants.PREF_NAME
import com.example.easysharedpreference.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPrefUtil()
        saveData()
        getData()
    }

    private fun initPrefUtil(){
        PrefUtil.initPrefUtil(this)
    }

    private fun saveData() {
        binding.saveName.setOnClickListener {
            val name = binding.nameEdt.text.toString()
            if (name.isNotEmpty()) {
                PrefUtil.saveData(PREF_NAME, name)
                snackBar(binding.root, DATA_SAVED)
            } else {
                snackBar(binding.root, "\uD83D\uDEAB $ENTER_NAME \uD83D\uDEAB")
            }
        }
    }

    private fun getData() {
        binding.getNameSaved.setOnClickListener {
            val name = PrefUtil.getData(PREF_NAME)
            if (name.isNotEmpty()) {
                binding.nameEdt.setText(name)
            } else {
                snackBar(binding.root, NO_DATA_FOUND)
            }
        }
    }

    companion object {
        fun snackBar(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
        }
    }
}