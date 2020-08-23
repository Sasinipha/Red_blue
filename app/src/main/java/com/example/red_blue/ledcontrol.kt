package com.example.red_blue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AbsSeekBar
import android.widget.ProgressBar
import android.widget.SeekBar
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
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Photo Red")
                ref.setValue(progress_red)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        seekbar_green.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_green: Int, p2: Boolean) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Green")
                ref.setValue(progress_green)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        seekbar_moonlight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_moon: Int, p2: Boolean) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Moon Light")
                ref.setValue(progress_moon)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        seekbar_coolwhite.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_cool: Int, p2: Boolean) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Cool White")
                ref.setValue(progress_cool)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        seekbar_blue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_blue: Int, p2: Boolean) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Blue")
                ref.setValue(progress_blue)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        seekbar_royalblue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_royalblue: Int, p2: Boolean) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Royal Blue")
                ref.setValue(progress_royalblue)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        seekbar_uv.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_uv: Int, p2: Boolean) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/UV")
                ref.setValue(progress_uv)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        seekbar_violet.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_violet: Int, p2: Boolean) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Violet")
                ref.setValue(progress_violet)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
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

