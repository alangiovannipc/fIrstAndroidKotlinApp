package com.belatrix.apolar.myfirstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_alarm.*

class DetailAlarmActivity : AppCompatActivity() {

    companion object {
        const val NEW_ALARM = "new_alarm"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_alarm)
        showNewAlarm()
    }

    fun showNewAlarm() {
        val newAlarm = intent.getStringExtra(NEW_ALARM);
        new_alarm_text.text = newAlarm
    }
}
