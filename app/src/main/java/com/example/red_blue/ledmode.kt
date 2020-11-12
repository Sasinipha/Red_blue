package com.example.red_blue

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_ledmode.*

class ledmode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ledmode)

        loadData()

        val pr = 50
        val gr = 30
        val ml = 100
        val cw = 100
        val bl = 100
        val ryb = 100
        val uv = 100
        val vl = 100

        sw_custom.setOnClickListener {
            savedata()
        }

        sw_auto.setOnClickListener {
            savedata()
        }

        next.setOnClickListener{
            if(!sw_auto.isChecked && sw_custom.isChecked){
                val d = Intent(this , ledcontrol::class.java)
                startActivity(d)
            } else if (sw_auto.isChecked && !sw_custom.isChecked){
                val ref = FirebaseDatabase.getInstance().getReference("user/LED/")

                ref.child("Photo Red").setValue(pr)
                ref.child("Green").setValue(gr)
                ref.child("Moon Light").setValue(ml)
                ref.child("Cool White").setValue(cw)
                ref.child("Blue").setValue(bl)
                ref.child("Royal Blue").setValue(ryb)
                ref.child("UV").setValue(uv)
                ref.child("Violet").setValue(vl)
                val e = Intent(this, home :: class.java)
                startActivity(e)
            } else if (!sw_auto.isChecked && !sw_custom.isChecked){
                Toast.makeText(this,"Please select mode",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"Please choose 1 mode",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun savedata(){
        val sharedPreferences = getSharedPreferences("mode_shareed", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putBoolean("boolean_key_custom",sw_custom.isChecked)
            putBoolean("boolean_key_auto",sw_auto.isChecked)
        }.apply()
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("mode_shareed", Context.MODE_PRIVATE)
        val savedboolean_auto = sharedPreferences.getBoolean("boolean_key_auto",false)
        val savedboolean_custom = sharedPreferences.getBoolean("boolean_key_custom",false)

        sw_auto.isChecked = savedboolean_auto
        sw_custom.isChecked = savedboolean_custom
    }
} // don't add to the berden of embedded too much.