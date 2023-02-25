package com.internshala.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class RegisterYourself : AppCompatActivity() {

    lateinit var register_button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_yourself)

        register_button = findViewById(R.id.register_button)

        register_button.setOnClickListener {
            Toast.makeText(this@RegisterYourself,"You Clicked on Register yourself",Toast.LENGTH_SHORT).show()
        }
    }
}