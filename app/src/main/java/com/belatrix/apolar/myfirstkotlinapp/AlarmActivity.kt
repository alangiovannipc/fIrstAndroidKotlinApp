package com.belatrix.apolar.myfirstkotlinapp

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
        alert("PlusMinute")
        updateMinute("32")
    }

    fun subtractMinute() {
        alert("SubtractMinute")
        updateMinute("10")
    }

    fun updateHour(hour: String) {
        hour_text.text = hour
    }

    fun updateMinute(minute: String) {
        minute_text.text = minute
    }

    fun updateTimezone(timezone: String) {
        timezone_text.text = timezone;
    }

    fun alert(message: String) {
        val myToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        myToast.show()
    }


}
