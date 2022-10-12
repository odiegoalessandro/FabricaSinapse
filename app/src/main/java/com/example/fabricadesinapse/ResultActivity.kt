package com.example.fabricadesinapse

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("NAME")
        val tvResult = findViewById<TextView>(R.id.tvResult)

        tvResult.text = getString(R.string.hello_name, name)
    }
}