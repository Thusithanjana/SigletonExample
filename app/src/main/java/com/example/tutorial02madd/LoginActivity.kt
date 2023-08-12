package com.example.tutorial02madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    lateinit var edtUsername:EditText
    lateinit var edtPassword:EditText
    lateinit var btnLogin:Button
    lateinit var tvCreateNewAccount:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvCreateNewAccount = findViewById(R.id.tvCreateNewAccount)

        btnLogin.setOnClickListener {
            login()

        }
        tvCreateNewAccount.setOnClickListener{
            openNewAccount()
        }
    }

    private fun login(){

        if(edtUsername.text.toString() == MyCredentials.username){
            if(MyCredentials.authenticate(edtPassword.text.toString())){
                val intent = Intent(this,DashboardActivity::class.java)
                intent.putExtra("username",edtUsername.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this,"Incorrect Password",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Incorrect Username",Toast.LENGTH_LONG).show()
        }



    }

    private fun openNewAccount(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}