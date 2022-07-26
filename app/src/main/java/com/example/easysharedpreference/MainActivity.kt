package com.example.easysharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.easysharedpreference.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        saveData()
        getData()
    }

    private fun saveData() {
        binding.saveName.setOnClickListener {
            val name = binding.nameEdt.text.toString()
            if (name.isNotEmpty()) {
                MyPreference.getInstance(this)?.saveData("name", name)
                snackBar(binding.root, "Data Saved Successfully ✔")
            } else {
                snackBar(binding.root, "\uD83D\uDEAB Please enter name \uD83D\uDEAB")
            }
        }
    }

    private fun getData() {
        binding.getNameSaved.setOnClickListener {
            val name = MyPreference.getInstance(this)?.getData("name")
            if (name!!.isNotEmpty()) {
                binding.nameEdt.setText(name)
            } else {
                snackBar(binding.root, "No data saved")
            }
        }
    }

    companion object {

        fun snackBar(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
        }

        const val TAG = "MainActivity"
    }
}