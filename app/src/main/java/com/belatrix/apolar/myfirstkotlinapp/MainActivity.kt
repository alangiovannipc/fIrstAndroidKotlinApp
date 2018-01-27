package com.belatrix.apolar.myfirstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
//import android.widget.TextView
import android.widget.Toast
import com.belatrix.apolar.myfirstkotlinapp.SecondActivity.Companion.TOTAL_COUNT
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui()
    }

    fun ui() {
        //val toast_button = findViewById<Button>(R.id.toast_button)
        //toast_button.setOnClickListener { toastMe(it) }
        toast_button.setOnClickListener { toastMe(it) }

        //val count_button = findViewById<Button>(R.id.count_button)
        //count_button.setOnClickListener({ countMe(it) })
        count_button.setOnClickListener({ countMe(it) })

        random_button.setOnClickListener({ randomMe() })
    }

    private fun countMe(view: View) {
        //val showCountTextView = findViewById<TextView>(R.id.textView)
        val countString = textView.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++;

        textView.text = count.toString()

    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun randomMe() {
        val randomIntent = Intent(this, SecondActivity::class.java)
        var countString = textView.text.toString();
        var count = Integer.parseInt(countString);
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT,count)
        // Start the new activity.
        startActivity(randomIntent)
    }


}
