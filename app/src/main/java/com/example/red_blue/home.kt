package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bt_selectmode.setOnClickListener{
            val h = Intent(this, ledmode::class.java)
            startActivity(h)
        }

        bt_timer.setOnClickListener{
            val i = Intent(this, settime::class.java)
            startActivity(i)
        }

    }
}