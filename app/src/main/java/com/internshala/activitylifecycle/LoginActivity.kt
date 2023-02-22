package com.internshala.activitylifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile

import com.internshala.activitylifecycle.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {   //2. ,View.OnClickListener {  --> A class can inherit only one class but can implement multiple
    // interfaces. Here this class LoginActivity has inherited the AppCompatActivity() and implement the OnClickListener interface

    // lateinit keyword can only be used with var variables not with the val variables

    // Below are the class variables and not the member variables

    lateinit var etEmail: EditText  // -> These data types are created tby the android SDK
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView


    private lateinit var binding: ActivityMainBinding

    // App and user Status
    lateinit var account: Auth0
    var appJustLaunched = true
    var userIsAuthenticated = false

    // Auth0 Data
    //   var user = User()

    val validEmail = "0123456789"   // --> ye value hmne set ki hai

    // val validPassword = "thanos"  --> this should be used when only one password is there but when multiple passwords are there we will use array
    val validPassword = arrayOf("Arpita", "Abhishek", "bruce", "thanos")


    // Creating object of SharedPreferences class

    lateinit var sharedPreferences: SharedPreferences // -> Creating object of SharedPreferences class


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Auth0
        account = Auth0(
            getString(R.string.com_auth0_client_id),
            getString(R.string.com_auth0_domain)
        )

        title = "Log In"

//        etEmail = findViewById(R.id.etEmail)
//        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        txtForgotPassword.setOnClickListener() {
            val intent = Intent(this@LoginActivity, ResetPassword::class.java)
            startActivity(intent)
        }




       binding.btnLogin.setOnClickListener {
           WebAuthProvider.login(account)
               .withScheme(getString(R.string.com_auth0_scheme))
               .withScope("openid profile email")
               // Launch the authentication passing the callback where the results will be received
               .start(this, object : Callback<Credentials, AuthenticationException> {
                   // Called when there is an authentication failure
                   override fun onFailure(error: AuthenticationException) {
                       // Something went wrong!
                       Toast
                           .makeText(this@LoginActivity, "Login Error: \n${error.message}", Toast.LENGTH_LONG)
                           .show()
                   }

                   // Called when authentication completed successfully
                   override fun onSuccess(result: Credentials) {
                       // Get the access token from the credentials object.
                       // This can be used to call APIs
                       val accessToken = result.accessToken
                   //    showUserProfile(accessToken)

                       // Add a delay of 2 seconds
                       val handler = Handler()
                       handler.postDelayed({
                           val intent = Intent(this@LoginActivity, MainActivity::class.java)
                           startActivity(intent)
                       }, 3000)
                   }
               })


//            val intent = Intent(this@LoginActivity, MainActivity::class.java)
//            startActivity(intent)
//
//            intent.putExtra("Name", "Hey User")
        }


        /*    sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), MODE_PRIVATE)
         val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)  // -> this isLoggedIn inside getBoolean method is case sensitive. so the name should be same as the key(isLoggedIn) created in the sharedPreferences method()

        setContentView(R.layout.activity_login)


        if(isLoggedIn) {
             val intent = Intent(this@LoginActivity,MainActivity::class.java)
             startActivity(intent)
             finish()
         }







        title = "Log In"

        // once the layout is created by the onCreate method we can go ahead and connect the variables to the respective views
        // inside OnCreate() method

        etEmail = findViewById(R.id.etEmail)
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

            val Email = etEmail.text.toString() // -> .text will extract the data from etMobileNumber and convert it into a String
            val password = etPassword.text.toString()  // -> ye value hm user k input se lenge

            var nameOfAvenger = "Avenger"

          //  if ((mobileNumber == validMobileNumber) && (password == validPassword)) {
//            if ((mobileNumber == validMobileNumber) && (validPassword.contains(password))) {
//                val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                startActivity(intent)

            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if (Email == validEmail) {

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

    *//*3.  override fun onClick(p0: View?) {

        Toast.makeText(this@LoginActivity,"We clicked on the button to see this Toast",Toast.LENGTH_LONG).show()

    } *//*

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title:String) {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()  // -> we can use commit() in place of apply() but they would take more resources
        sharedPreferences.edit().putString("Title",title).apply()
    }*/

    }

//    fun login() {
//
//        WebAuthProvider
//            .login(account)
//            .withScheme(getString(R.string.com_auth0_scheme))
//            .start(this, object : Callback<Credentials, AuthenticationException> {
//
//                override fun onFailure(error: AuthenticationException) {
//                    Toast.makeText(this@LoginActivity, "Login Failure", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onSuccess(result: Credentials) {
//                    userIsAuthenticated = true
//                }
//            })
//
//    }


    private fun showUserProfile(accessToken: String) {
        val client = AuthenticationAPIClient(account)

        // With the access token, call `userInfo` and get the profile from Auth0.
        client.userInfo(accessToken)
            .start(object : Callback<UserProfile, AuthenticationException> {
                override fun onFailure(error: AuthenticationException) {
                    // Something went wrong!
                    Toast.makeText(
                        this@LoginActivity,
                        "Error getting profile \n${error.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onSuccess(result: UserProfile) {
                    // We have the user's profile!
                    binding.emailTv.text = result.email
                    Toast.makeText(
                        this@LoginActivity,
                        "Login Successful!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }





}
