package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {


    var titleName: String? = "Avengers"

    lateinit var etMessage: EditText
    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {    // This onCreate() is mandatory and need to be present in every app
        super.onCreate(savedInstanceState)  // OnCreate is a method of the parent class
        setContentView(R.layout.activity_avengers)  // R is the res file which consists the id's of all the resources used
        // setContentView extract the layout from the layout directory and sets it on the main screen
        // in short the setContentView is responsible for setting the ui of the app

        println("onCreate called")

        // When we open a video in youtube and when we rotate the screen the videos continues to play
        // but in the backend the present activity gets destroyed andnew activity gets created

        // so how do we let a video play when the screen is rotated?
        // Override the OnSaveInstanceState() function.
        // Before this,save the instance of the activity in a bundle
        // pass this bundle in the argument of the SaveInstanceState() function
        // this is done to create seamless experience

        // What are bundles and what it is used for?
        // A bundle is used to pass data from one activity to another. This data can be in any form,
        // like strings,Integers,double etc.

        if (intent != null) {
            titleName = intent.getStringExtra("Name")
        }


        //  title = "The Avengers"

        title = titleName



        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)


        btnSend.setOnClickListener {

            val message: String? = etMessage.text.toString()

            if (message?.isNotEmpty() == true) {

                val intent = Intent(this@AvengersActivity, Message_Activity::class.java)
                intent.putExtra("Message", message)
                startActivity(intent)
            } else {
                Toast.makeText(this@AvengersActivity, "Write a message!", Toast.LENGTH_SHORT).show()
            }


        }


        /*
    override fun onStart() {

        super.onStart()
        println("OnStart called")
    }

    override fun onResume() {
        super.onResume()
        println("onResume called")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause called")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop called")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }


     */


    }
}
