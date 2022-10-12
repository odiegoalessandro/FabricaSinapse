package com.example.fabricadesinapse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etName = findViewById<EditText>(R.id.etName)
        val btSend = findViewById<Button>(R.id.btSend)
        val btSend2 = findViewById<Button>(R.id.btSend2)
        val btSend3 = findViewById<Button>(R.id.btSend3)

        val openSendResultActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data?.getStringExtra("RESULT")
                tvResult.text = getString(R.string.hello_name, etName.text.toString())
            } else {
                val data = result.data?.getStringExtra("RESULT")
                tvResult.text = "cancelado"
            }
        }

        fun register() {
            val intent = Intent(this, SendResultActivity::class.java)
            openSendResultActivity.launch(intent)
        }

        btSend.setOnClickListener {
            if (etName.text.isNotBlank()) {
                tvResult.text = getString(R.string.hello_name, etName.text.toString())
            } else {
                etName.error = getString(R.string.type_your_name)
            }
        }

        btSend2.setOnClickListener {
            if (etName.text.isNotBlank()) {
                val name = etName.text.toString()
                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("NAME", name)
                startActivity(intent)
            } else {
                etName.error = getString(R.string.type_your_name)
            }
        }

        btSend3.setOnClickListener {
            register()
        }
    }
}