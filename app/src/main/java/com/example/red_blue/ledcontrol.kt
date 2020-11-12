package com.example.red_blue

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_ledcontrol.*
import kotlinx.android.synthetic.main.activity_ledmode.*
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class LED (val PhotoRed : Int,val Green : Int,val Moonlight : Int,val Coolwhite : Int,val Blue : Int,val Royalblue : Int,val UV : Int,val Violet : Int)
class ledcontrol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ledcontrol)


        var pr = seekbar_photored.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_red: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Photo Red")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })

        var gr = seekbar_green.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_green: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Green")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })

        var ml = seekbar_moonlight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_moon: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Moon Light")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })

        var cw = seekbar_coolwhite.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_cool: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Cool White")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })

        var bl = seekbar_blue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_blue: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Blue")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })

        var ryb = seekbar_royalblue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_royalblue: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Royal Blue")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })

        var uv = seekbar_uv.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_uv: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/UV")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })

        var vl = seekbar_violet.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress_violet: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar) {
            }

            override fun onStopTrackingTouch(p0: SeekBar) {
                val ref = FirebaseDatabase.getInstance().getReference("/user/LED/Violet")
                ref.setValue(p0.progress)
                Toast.makeText(this@ledcontrol, p0.progress.toString() + " %", Toast.LENGTH_SHORT).show()
            }
        })


        bt_done.setOnClickListener {
            /*val LED = getSharedPreferences("LED", Context.MODE_PRIVATE)
            val editor = LED.edit()

            editor.putInt("photo_red",pr)
            editor.putInt("green",gr)
            editor.putInt("moon_light",ml)
            editor.putInt("cool_white",cw)
            editor.putInt("blue",bl)
            editor.putInt("royal_blue",ryb)
            editor.putInt("uv",uv)
            editor.putInt("violet",vl)
            editor.commit()*/

            /*val ref = FirebaseDatabase.getInstance().getReference("user/LED/")
            //val led = LED(pr,gr,ml,cw,bl,ryb,uv,vl)
            ref.child("Photo Red").setValue(pr)
            ref.child("Green").setValue(gr)
            ref.child("Moon Light").setValue(ml)
            ref.child("Cool White").setValue(cw)
            ref.child("Blue").setValue(bl)
            ref.child("Royal Blue").setValue(ryb)
            ref.child("UV").setValue(uv)
            ref.child("Violet").setValue(vl)*/
            val e = Intent(this, home :: class.java)
            startActivity(e)
        }


        bt_cancel.setOnClickListener {
            val f = Intent(this, ledmode :: class.java)
            startActivity(f)
        }
    }

    /*private fun loadLEDdata(p:Int,g:Int,m:Int,c:Int,b:Int,r:Int,uv:Int,v:Int){
        val LED = getSharedPreferences("LED", Context.MODE_PRIVATE)
        var pr = LED.getInt("photo_red",p)
        var gr = LED.getInt("green",g)
        var ml = LED.getInt("moon_light",m)
        var cw = LED.getInt("cool_white",c)
        var bl = LED.getInt("blue",b)
        var ryb = LED.getInt("royal_blue",r)
        var uv = LED.getInt("uv",uv)
        var vl = LED.getInt("violet",v)

        seekbar_photored.progress = pr
        seekbar_green.progress = gr
        seekbar_moonlight.progress = ml
        seekbar_coolwhite.progress = cw
        seekbar_blue.progress = bl
        seekbar_royalblue.progress = ryb
        seekbar_uv.progress = uv
        seekbar_violet.progress = vl
    }*/

} // fighting :)

