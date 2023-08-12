package com.example.tutorial02madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var username:EditText
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var retypePassword:EditText

    lateinit var btnRegister:Button
    lateinit var btnBack:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.edtRegisterUsername)
        email = findViewById(R.id.edtEmail)
        password = findViewById(R.id.edtRegisterPassword)
        retypePassword = findViewById(R.id.edtRetypePassword)

        btnRegister = findViewById(R.id.btnRegister)
        btnBack = findViewById(R.id.btnBack)


        btnBack.setOnClickListener {
            back()
        }

        btnRegister.setOnClickListener {
            register()
        }
    }


    fun back(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun register(){

        MyCredentials.username = username.text.toString()

        MyCredentials.email = email.text.toString()

        val state =  MyCredentials.setPassword(password.text.toString(),retypePassword.text.toString())

        if(state){
            Toast.makeText(this,"Register Success",Toast.LENGTH_LONG).show()
            back()
        }else{
            Toast.makeText(this,"Password mismatch",Toast.LENGTH_LONG).show()
        }

    }
}