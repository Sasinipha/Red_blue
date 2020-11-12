package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val bt_submit = findViewById<Button>(R.id.submit_regist)

        bt_submit.setOnClickListener{
            performRegister()
        }

    }

    private fun performRegister(){
        val username = reName.text.toString()
        val email_add = reEmail.text.toString()
        val password = rePassword.text.toString()

        if (email_add.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username/email/pw", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("regisrer","Username is" + username)
        Log.d("register","Email is" + email_add)
        Log.d("register", "Password is $password")
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_add,password)
            .addOnCompleteListener{
                if (!it.isSuccessful) {
                    Toast.makeText(this, "Please try again", Toast.LENGTH_SHORT).show()
                    return@addOnCompleteListener
                }
                else{
                    Toast.makeText(this, "Create Success",Toast.LENGTH_SHORT).show()
                    saveusertoFirebaseDatabase()
                    val c = Intent( this, home ::class.java)
                    startActivity(c)
                } // else if successful
            }
            .addOnFailureListener{
                Log.d("register", "Failed to create user: ${it.message}")
            }
    }

    private fun saveusertoFirebaseDatabase(){
        val username = reName.text.toString()
        val ref = FirebaseDatabase.getInstance().getReference("/user/$username")

        val user = FirebaseAuth.getInstance().uid?.let { User(it, reName.text.toString()) }
        ref.setValue(user)
            .addOnSuccessListener {
                Log.d("regist", "save the user to Firebase Database")
            }
    }
}

class User (val uid : String, val username : String)