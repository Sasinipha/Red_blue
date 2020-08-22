package com.example.red_blue

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ledmode.*

class ledmode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ledmode)

        loadData()

        sw_custom.setOnClickListener {
            savedata()
            if(sw_custom.isChecked){
                val d = Intent(this , ledcontrol::class.java)
                startActivity(d)
            }
        }

        sw_auto.setOnClickListener {
            savedata()
        }

    }

    private fun savedata(){
        val sharedPreferences = getSharedPreferences("shareed", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putBoolean("boolean_key_custom",sw_custom.isChecked)
            putBoolean("boolean_key_auto",sw_auto.isChecked)
        }.apply()
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("shareed", Context.MODE_PRIVATE)
        val savedboolean_auto = sharedPreferences.getBoolean("boolean_key_auto",false)
        val savedboolean_custom = sharedPreferences.getBoolean("boolean_key_custom",false)

        sw_auto.isChecked = savedboolean_auto
        sw_custom.isChecked = savedboolean_custom
    }
}