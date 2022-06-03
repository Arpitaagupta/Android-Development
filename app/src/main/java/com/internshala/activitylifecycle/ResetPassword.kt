package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResetPassword : AppCompatActivity() {


    lateinit var btnSendInstructions : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)


        title = "Reset Password"

        btnSendInstructions = findViewById(R.id.btnSendInstructions)

        btnSendInstructions.setOnClickListener{
            val intent = Intent(this@ResetPassword,CheckMailActivity::class.java)
            startActivity(intent)
        }


    }
}