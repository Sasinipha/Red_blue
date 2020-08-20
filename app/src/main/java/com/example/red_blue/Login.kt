package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bt_login = findViewById<Button>(R.id.bt_login)
        val bt_regist = findViewById<Button>(R.id.bt_regist)

            bt_login.setOnClickListener{
                if (edName.text.toString().equals("nt") && edPassword.text.toString().equals("1234")) {
                    val a = Intent(this, ledcontrol::class.java)
                    startActivity(a)
                    Toast.makeText(this, "Login Success.",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Login Failed.",Toast.LENGTH_SHORT).show()
                }
            }

        bt_regist.setOnClickListener{
            val b = Intent(this, register::class.java)
            startActivity(b)
        }

    }
}