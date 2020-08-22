package com.example.red_blue

import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_ledmode.*
import kotlinx.android.synthetic.main.activity_settime.*
import java.text.SimpleDateFormat
import java.util.*

class settime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settime)

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
    }

}