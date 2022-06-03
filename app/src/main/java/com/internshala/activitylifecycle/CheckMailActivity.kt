package com.internshala.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CheckMailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_mail)


        title = "Instructions"
    }
}