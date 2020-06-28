package com.carol.mybookcollection.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.carol.mybookcollection.R
import com.carol.mybookcollection.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {

    private var userViewModel: UserViewModel? = null
    private var usernameText: EditText? = null
    private var passwordText: EditText? = null
    private var loginButton: ImageView? = null
    private var signupButton: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usernameText = findViewById(R.id.username)
        passwordText = findViewById(R.id.password)
        loginButton = findViewById(R.id.login)
        signupButton = findViewById(R.id.signup)

        userViewModel = ViewModelProvider(this, UserViewModel.Factory(applicationContext)).get(UserViewModel::class.java)

        val signup = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
            .getBoolean("signup", true)

        if (signup) {
            signupButton!!.visibility = View.VISIBLE
            loginButton!!.visibility = View.GONE
        } else {
            signupButton!!.visibility = View.GONE
            loginButton!!.visibility = View.VISIBLE

        }

        loginButton!!.setOnClickListener {
            val isValid = userViewModel!!.checkValidLogin(usernameText!!.text.toString(), passwordText!!.text.toString())
            if (isValid) {
                Toast.makeText(baseContext, "Successfully Logged In!", Toast.LENGTH_LONG).show()
                Log.i("Successful_Login", "Login was successful")
            } else {
                Toast.makeText(baseContext, "Invalid Login!", Toast.LENGTH_SHORT).show()
                Log.i("Unsuccessful_Login", "Login was not successful")
            }
        }

        signupButton!!.setOnClickListener {
           val intent = Intent(this,signup::class.java)
            startActivity(intent)
            Toast.makeText(baseContext, " Create An Account!", Toast.LENGTH_LONG).show()
        }


    }
}
