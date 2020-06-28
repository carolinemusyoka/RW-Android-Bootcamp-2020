package com.carol.mybookcollection.view

import android.content.Intent
import android.os.Bundle
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

        txtforgot.setOnClickListener {
            Toast.makeText(this, "Functionality Coming soon", Toast.LENGTH_LONG).show()
        }
        //calling view mdioel object
        val userDetailsRepository = ViewModelProvider(this).get(UserViewModel::class.java)

        btn_register.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            // start your next activity
            startActivity(intent)
        }


        btn_login.setOnClickListener {
            if (validation()) {


                userDetailsRepository.getGetAllData().observe(this,
                    Observer<List<UserAccount>> { t ->
                        var userObject = t

                        for (i in userObject.indices) {
                            if (userObject[i].username?.equals(username.text.toString())!!) {

                                if (userObject[i].password?.equals(password.text.toString())!!) {

                                    val intent = Intent(this, MainActivity::class.java)

                                    startActivity(intent)

                                } else {
                                    Toast.makeText(this, " Password is Incorrect ", Toast.LENGTH_LONG)
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

                            Toast.makeText(this, " User Not Registered ", Toast.LENGTH_LONG).show()
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
            Toast.makeText(this, " Enter UserName ", Toast.LENGTH_LONG).show()
            return false
        }

        if (password.text.isNullOrEmpty()) {
            Toast.makeText(this, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }


}

