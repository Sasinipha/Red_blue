package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ledcontrol.*
import kotlinx.android.synthetic.main.activity_ledmode.*

class ledcontrol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ledcontrol)


        bt_done.setOnClickListener {
            val e = Intent(this, settime :: class.java)
            startActivity(e)
        }
        bt_cancel.setOnClickListener {
            val f = Intent(this, ledmode :: class.java)
            startActivity(f)
        }
    }
}