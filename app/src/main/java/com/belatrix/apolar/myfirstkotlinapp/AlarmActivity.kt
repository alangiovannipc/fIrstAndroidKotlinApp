package com.belatrix.apolar.myfirstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        ui()
    }

    fun ui() {
        /* Hour set Event Onclick Listener */
        hour_plus_button.setOnClickListener({ plusHour() })
        hour_subtract_button.setOnClickListener({ subtractHour() })
        /* Minute set Event Onclick Listener */
        minute_plus_button.setOnClickListener({ plusMinute() })
        minute_subtract_button.setOnClickListener({ subtractMinute() })
        /* TimeZone set Event Onclick Listener */
        timezone_am_button.setOnClickListener({ updateTimezone("AM") })
        timezone_pm_button.setOnClickListener({ updateTimezone("PM") })
        /* SaveButton set Event Onclick listener */
        save_button.setOnClickListener({ saveAlarm() })
    }

    fun plusHour() {
        var hour: Int = Integer.parseInt(hour_text.text.toString())
        hour++

        if (hour <= 12) {
            updateHour(hour.toString())
        } else {
            alert("You are reached the maximum hour ")
        }
    }

    fun subtractHour() {
        var hour: Int = Integer.parseInt(hour_text.text.toString())
        hour--

        if (hour > 0) {
            updateHour(hour.toString())
        } else {
            alert("You are reached the minimum hour ")
        }
    }

    fun plusMinute() {
        var minute: Int = Integer.parseInt(minute_text.text.toString())
        minute++

        if (minute <= 59) {
            updateMinute(minute.toString())
        } else {
            alert("You are reached the maximum minute ")
        }
    }

    fun subtractMinute() {
        var minute: Int = Integer.parseInt(minute_text.text.toString())
        minute--

        if (minute >= 0) {
            updateMinute(minute.toString())
        } else {
            alert("You are reached the minimum minute ")
        }
    }

    fun updateHour(hour: String) {
        hour_text.text = hour
    }

    fun updateMinute(minute: String) {
        if (Integer.parseInt(minute) <= 9) {
            minute_text.text = "0" + minute
        } else {
            minute_text.text = minute
        }

    }

    fun updateTimezone(timezone: String) {
        timezone_text.text = timezone;
    }

    fun alert(message: String) {
        val myToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun saveAlarm() {
        val detailAlarmIntent = Intent(this, DetailAlarmActivity::class.java)
        val newDetailAlarm = hour_text.text.toString() + ":" + minute_text.text.toString() + " " + timezone_text.text.toString()
        detailAlarmIntent.putExtra(DetailAlarmActivity.NEW_ALARM, newDetailAlarm)
        startActivity(detailAlarmIntent)
    }

}
