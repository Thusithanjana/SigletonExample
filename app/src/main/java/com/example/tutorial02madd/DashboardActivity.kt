package com.example.tutorial02madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {

    lateinit var tvTitle: TextView
    lateinit var btnBack:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvTitle = findViewById(R.id.tvTitle)
        btnBack = findViewById(R.id.btnBackDashbord)

        tvTitle.text = "Hello, ${intent.getStringExtra("username")}"

        btnBack.setOnClickListener {
            back()

        }


    }

    fun back(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}