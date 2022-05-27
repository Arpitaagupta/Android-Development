package com.internshala.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Message_Activity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)


        Toast.makeText(this,intent?.getStringExtra("Message"),Toast.LENGTH_SHORT).show()

            // Here the message is in toast. But do i make it to show it on the text view page of message Activity
//        val messageData : String? = intent.getStringExtra("Message")
//        val message: TextView = findViewById(R.id.etMessage)
//        message.text = messageData


        title =  "Message"
    }
}