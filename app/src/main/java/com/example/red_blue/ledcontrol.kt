package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AbsSeekBar
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_ledcontrol.*
import kotlinx.android.synthetic.main.activity_ledmode.*
import kotlinx.android.synthetic.main.activity_register.*

class LED (val username : String , progress : Int)
class ledcontrol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ledcontrol)


        seekbar_photored.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_red: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_red.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Photo Red")
                ref.setValue(p0.progress)
            }
        })

        seekbar_green.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_green: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_green.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Green")
                ref.setValue(p0.progress)
            }
        })

        seekbar_moonlight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_moon: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_moon.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Moon Light")
                ref.setValue(p0.progress)
            }
        })

        seekbar_coolwhite.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_cool: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_cool.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Cool White")
                ref.setValue(p0.progress)
            }
        })

        seekbar_blue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_blue: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_blue.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Blue")
                ref.setValue(p0.progress)
            }
        })

        seekbar_royalblue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_royalblue: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_royalblue.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Royal Blue")
                ref.setValue(p0.progress)
            }
        })

        seekbar_uv.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_uv: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_uv.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/UV")
                ref.setValue(p0.progress)
            }
        })

        seekbar_violet.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_violet: Int, p2: Boolean) {
                Toast.makeText(this@ledcontrol, progress_violet.toString() + " %", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Violet")
                ref.setValue(p0.progress)
            }
        })


        bt_done.setOnClickListener {
            val e = Intent(this, settime :: class.java)
            startActivity(e)
        }
        bt_cancel.setOnClickListener {
            val f = Intent(this, ledmode :: class.java)
            startActivity(f)
        }
    }
} // fighting :)

