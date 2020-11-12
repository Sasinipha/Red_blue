package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bt_login = findViewById<Button>(R.id.bt_login)
        val bt_regist = findViewById<Button>(R.id.bt_regist)

        bt_login.setOnClickListener {
            performLogin()
        }

        bt_regist.setOnClickListener {
            val b = Intent(this, register::class.java)
            startActivity(b)
        }
    }

    private fun performLogin(){
        val email = loginemail.text.toString()
        val password = edPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and pw", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("login", "Login with email/pw: $email/***")

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (!it.isSuccessful) {
                    Toast.makeText(this, "Please try again", Toast.LENGTH_SHORT).show()
                    return@addOnCompleteListener
                }
                else{
                    Toast.makeText(this, "Login Sucess",Toast.LENGTH_SHORT).show()
                    val a = Intent( this, home ::class.java)
                    startActivity(a)
                } // else if successful
            }
            .addOnFailureListener{
                Log.d("register", "Failed to create user: ${it.message}")
            }

    }
}