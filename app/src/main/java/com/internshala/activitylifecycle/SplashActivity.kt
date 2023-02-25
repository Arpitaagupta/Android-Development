package com.internshala.activitylifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.WindowManager
import android.os.Handler
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView

class SplashActivity : AppCompatActivity() {

    lateinit var txtSlogan: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        txtSlogan = findViewById(R.id.txtSlogan)



        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, 2000)


        title = "Codeguru"

        animateTextView(txtSlogan)
    }

    private fun animateTextView(textView: TextView) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1000 // 1 second
        animation.startOffset = 500 // 0.5 seconds delay before starting
        animation.repeatCount = Animation.INFINITE // repeat indefinitely
        animation.repeatMode = Animation.REVERSE // reverse animation on repeat
        textView.startAnimation(animation)
    }



    }

