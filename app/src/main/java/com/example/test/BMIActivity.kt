package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {
    var bmiIndex = 0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi)

        intent?.getStringExtra("personName")

        val personName = intent?.getStringExtra("personName")
        val tv = findViewById<TextView>(R.id.tvName)

        tv.setText(personName)

        if (savedInstanceState!=null){
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            val status = findViewById<TextView>(R.id.tvStatus)
            status.setText(getStatus())
        }

        val btn = findViewById<Button>(R.id.btnCal)
        btn.setOnClickListener(){

            val height = findViewById<TextView>(R.id.tfHeight).toString()
            val weight = findViewById<TextView>(R.id.tfWeight).toString()
            val status = findViewById<TextView>(R.id.tvStatus)

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())
            status.setText(getStatus())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex",bmiIndex)
    }

    fun getStatus():String{
        if (bmiIndex < 18.5)
            return "underweight"
        else if (bmiIndex < 24.9)
            return "Normal Weight"
        else if (bmiIndex < 29.9)
            return "Overweight"
        else if (bmiIndex < 34.9)
            return "Obesity I"
        else if (bmiIndex < 39.9)
            return "Obesity II"
        else
            return "Obesity III"
    }
}