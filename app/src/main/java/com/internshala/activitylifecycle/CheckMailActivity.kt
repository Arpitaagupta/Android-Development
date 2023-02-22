package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CheckMailActivity : AppCompatActivity() {

    lateinit var btnOpenEmailApp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_mail)

        btnOpenEmailApp = findViewById(R.id.btnOpenEmailApp)

        btnOpenEmailApp.setOnClickListener {
            val intent = Intent(packageManager.getLaunchIntentForPackage("com.whatsapp"))

            if(intent != null) {
                startActivity(intent)
            }
        }


        title = "Instructions"
    }
}