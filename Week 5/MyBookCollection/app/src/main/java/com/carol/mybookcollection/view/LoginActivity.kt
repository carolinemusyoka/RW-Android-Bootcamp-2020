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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.carol.mybookcollection.R
import com.carol.mybookcollection.model.UserAccount
import com.carol.mybookcollection.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    /**
     * @param isExist  bool parameter for check existency of user or not in database
     */
    var isExist = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //calling viewmodel object
        val userRepo = ViewModelProvider(this).get(UserViewModel::class.java)

        signup.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            // start your next activity
            startActivity(intent)
        }


        login.setOnClickListener {
            if (validation()) {


                userRepo.getGetAllData().observe(this, object : Observer<List<UserAccount>> {
                    override fun onChanged(t: List<UserAccount>) {
                        var userObject = t

                        for (i in userObject.indices) {
                            if (userObject[i].username?.equals(username.text.toString())!!) {

                                if (userObject[i].password?.equals(password.text.toString())!!) {

                                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                        .putExtra("UserDetials", userObject[i])
                                    // start your next activity
                                    startActivity(intent)

                                } else {
                                    Toast.makeText(this@LoginActivity, " Password is Incorrect ", Toast.LENGTH_LONG)
                                        .show()
                                }
                                isExist = true
                                break

                            } else {
                                isExist = false
                            }
                        }

                        if (isExist) {

                        } else {

                            Toast.makeText(this@LoginActivity, " User Not Registered ", Toast.LENGTH_LONG).show()
                        }

                    }

                })
            }
        }


    }

    /**
     * Attempts to sign in  the account specified by the login form.
     * If there are form errors (invalid mobile, missing fields, etc.), the
     * errors are presented in form of toast and no actual login attempt is made.
     */
    private fun validation(): Boolean {

        if (username.text.isNullOrEmpty()) {
            Toast.makeText(this@LoginActivity, " Enter Your Username ", Toast.LENGTH_LONG).show()
            return false
        }
        if (username.text.toString().length != 10) {
            Toast.makeText(this@LoginActivity, " At least 10 characters ", Toast.LENGTH_LONG).show()
            return false
        }
        if (password.text.isNullOrEmpty()) {
            Toast.makeText(this@LoginActivity, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }


}
