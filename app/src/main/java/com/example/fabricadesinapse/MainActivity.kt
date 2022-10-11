package com.example.fabricadesinapse

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etName = findViewById<EditText>(R.id.etName)
        val btSend = findViewById<Button>(R.id.btSend)

        btSend.setOnClickListener {
            if(etName.text.isNotBlank()){
                tvResult.text = getString(R.string.hello_name, etName.text.toString())
            } else {
                etName.error = getString(R.string.type_your_name)
            }
        }
    }
}