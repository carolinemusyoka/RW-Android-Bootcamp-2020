package com.carol.mybookcollection.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.carol.mybookcollection.R
import com.carol.mybookcollection.databinding.ActivitySignUpBinding
import com.carol.mybookcollection.db.UserAccountDatabase
import com.carol.mybookcollection.model.UserAccount
import com.carol.mybookcollection.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignupActivity : AppCompatActivity() {
    /**
     * @param isExist  bool parameter for check existency of user or not in database
     */
    private var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //calling view mdioel object
        val userDetailsRepository = ViewModelProvider(this@SignupActivity).get(UserViewModel::class.java)

        btn_login.setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        btn_signup.setOnClickListener {
            if (validation()) {
                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<UserAccount>> {
                    override fun onChanged(t: List<UserAccount>) {
                        var userObject = t

                        for (i in userObject.indices) {


                            if (userObject[i].username?.equals(username.text.toString())!!) {
                                isExist = true
                                Toast.makeText(this@SignupActivity," User Already Registered ", Toast.LENGTH_LONG).show()
                                break

                            } else {
                                isExist = false
                                continue

                            }
                        }

                        if (isExist) {
                            Toast.makeText(this@SignupActivity, " User  Registered Successfully ", Toast.LENGTH_LONG)
                                .show()

                        } else {

                            val user = UserAccount()

                            user.fullname = fullname.text.toString()
                            user.username = username.text.toString()
                            user.password = password.text.toString()
                            val userDatabase = UserAccountDatabase
                            userDatabase.getDatabase(this@SignupActivity)?.daoAccess()?.insertUserData(user)
                            Toast.makeText(this@SignupActivity, " User  Registered Successfully", Toast.LENGTH_LONG)
                                .show()


                        }
                    }
                    })
            }

        }


    }

    /**
     * Attempts to register in  the account specified by the registration form.
     * If there are form errors (invalid name, missing fields, etc.), the
     * errors are presented in form of toast and no actual login attempt is made.
     */
    fun validation(): Boolean {
        if (fullname.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter Full Name ", Toast.LENGTH_LONG).show()
            return false
        }
        if (username.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter UserName ", Toast.LENGTH_LONG).show()
            return false
        }


        if (password.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

}




