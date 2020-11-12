package com.example.red_blue

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_ledmode.*
import kotlinx.android.synthetic.main.activity_settime.*
import java.text.SimpleDateFormat
import java.util.*

class settime : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settime)

        lateinit var am : AlarmManager
        lateinit var pd : PendingIntent
        lateinit var context : Context
        lateinit var tp : TimePicker
        var hour : Int = 0
        var min : Int = 0

        context = this
        am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var cal  = Calendar.getInstance()
        var myIntent : Intent = Intent(this,AlarmReciver :: class.java)

        /*start_time.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    cal.set(Calendar.HOUR_OF_DAY,tp.hour)
                    cal.set(Calendar.MINUTE,tp.minute)
                    cal.set(Calendar.SECOND,0)
                    cal.set(Calendar.MILLISECOND,0)
                    hour = tp.hour
                    min = tp.minute
                }
                else{
                    cal.set(Calendar.HOUR_OF_DAY,tp.currentHour)
                    cal.set(Calendar.MINUTE,tp.currentMinute)
                    cal.set(Calendar.SECOND,0)
                    cal.set(Calendar.MILLISECOND,0)
                    hour = tp.currentHour
                    min = tp.currentMinute
                }
                var h_string = hour.toString()
                var min_string = min.toString()
                if (hour>12){
                    h_string = (hour -12).toString()
                }
                if (min < 10){
                    min_string = "0$min"
                }
                start_time_text("$h_string : $min_string")
                pd = PendingIntent.getBroadcast(this@settime,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
                am.setExact(AlarmManager.RTC,cal.timeInMillis,pd)
            }
        })

        end_time.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    cal.set(Calendar.HOUR_OF_DAY,tp.hour)
                    cal.set(Calendar.MINUTE,tp.minute)
                    cal.set(Calendar.SECOND,0)
                    cal.set(Calendar.MILLISECOND,0)
                    hour = tp.hour
                    min = tp.minute
                }
                else{
                    cal.set(Calendar.HOUR_OF_DAY,tp.currentHour)
                    cal.set(Calendar.MINUTE,tp.currentMinute)
                    cal.set(Calendar.SECOND,0)
                    cal.set(Calendar.MILLISECOND,0)
                    hour = tp.currentHour
                    min = tp.currentMinute
                }
                var h_string = hour.toString()
                var min_string = min.toString()
                if (hour>12){
                    h_string = (hour -12).toString()
                }
                if (min < 10){
                    min_string = "0$min"
                }
                start_time_text("$h_string : $min_string")
                pd = PendingIntent.getBroadcast(this@settime,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
                am.cancel(pd)
                sendBroadcast(myIntent)
            }
        })*/

        start_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val time1 = TimePickerDialog.OnTimeSetListener{timePicker , hour , minute ->
                cal.set(Calendar.HOUR_OF_DAY,hour)
                cal.set(Calendar.MINUTE,minute)
                start_time.text = SimpleDateFormat("HH : mm").format(cal.time)
            }
            TimePickerDialog(this, time1, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
        }

        end_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val time2 = TimePickerDialog.OnTimeSetListener{timePicker , hour , minute ->
                cal.set(Calendar.HOUR_OF_DAY,hour)
                cal.set(Calendar.MINUTE,minute)
                end_time.text = SimpleDateFormat("HH : mm").format(cal.time)
            }
            TimePickerDialog(this, time2, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
        }

        bt_settime.setOnClickListener(){
            Toast.makeText(this,"set time already", Toast.LENGTH_SHORT).show()
        }
    }

    private fun start_time_text(s : String){
        start_time.setText(s)
    }

    private fun end_time_text(s: String){
        end_time.setText(s)
    }

}