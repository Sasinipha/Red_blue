package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(1500)

                    val intent = Intent(baseContext, Login::class.java)
                    startActivity(intent)
                }catch(e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}