package com.internshala.activitylifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.prefs.AbstractPreferences

class LoginActivity : AppCompatActivity() {   //2. ,View.OnClickListener {  --> A class can inherit only one class but can implement multiple
    // interfaces. Here this class LoginActivity has inherited the AppCompatActivity() and implement the OnClickListener interface

    // lateinit keyword can only be used with var variables not with the val variables

    // Below are the class variables and not the member variables

    lateinit var etMobileNumber: EditText  // -> These data types are created tby the android SDK
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView

    val validMobileNumber = "0123456789"   // --> ye value hmne set ki hai
   // val validPassword = "thanos"  --> this should be used when only one password is there but when multiple passwords are there we will use array
    val validPassword = arrayOf("Arpita","Abhishek","bruce","thanos")


    // Creating object of SharedPreferences class

    lateinit var sharedPreferences: SharedPreferences // -> Creating object of SharedPreferences class


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), MODE_PRIVATE)
         val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)  // -> this isLoggedIn inside getBoolean method is case sensitive. so the name should be same as the key(isLoggedIn) created in the sharedPreferences method()

        setContentView(R.layout.activity_login)


        if(isLoggedIn) {
             val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
             startActivity(intent)
             finish()
         }







        title = "Log In"

        // once the layout is created by the onCreate method we can go ahead and connect the variables to the respective views
        // inside OnCreate() method

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        txtForgotPassword.setOnClickListener() {
               val intent = Intent(this@LoginActivity,ResetPassword::class.java)
               startActivity(intent)
        }





        //1.    btnLogin.setOnClickListener(this)  // we need to implement the onClick method. So for that we will simply put 'this'
        // inside the curly brackets\

        btnLogin.setOnClickListener {      // --> This is called the lambda representation of implementing a click listener

            //   Toast.makeText(this@LoginActivity,"We clicked on the button to see this Toast",Toast.LENGTH_LONG).show()

            val mobileNumber = etMobileNumber.text.toString() // -> .text will extract the data from etMobileNumber and convert it into a String
            val password = etPassword.text.toString()  // -> ye value hm user k input se lenge

            var nameOfAvenger = "Avenger"

          //  if ((mobileNumber == validMobileNumber) && (password == validPassword)) {
//            if ((mobileNumber == validMobileNumber) && (validPassword.contains(password))) {
//                val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
//                startActivity(intent)

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if (mobileNumber == validMobileNumber) {

                if(password == validPassword[0]) {


                    nameOfAvenger = "Heyy Arpita"
                    savePreferences(nameOfAvenger)

                 //   intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)

                }

                else if(password == validPassword[1]) {

                    nameOfAvenger = "Heyy Abhishek"
                    savePreferences(nameOfAvenger)
                //    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)

                }

                else if(password == validPassword[2]) {

                    nameOfAvenger = "The Hulk "
                    savePreferences(nameOfAvenger)
              //      intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }

                else if(password == validPassword[3]) {
                  //  savePreferences()
                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)
                 //   intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()

            }



        }


    }

    /*3.  override fun onClick(p0: View?) {

        Toast.makeText(this@LoginActivity,"We clicked on the button to see this Toast",Toast.LENGTH_LONG).show()

    } */

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title:String) {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()  // -> we can use commit() in place of apply() but they would take more resources
        sharedPreferences.edit().putString("Title",title).apply()
    }

}
