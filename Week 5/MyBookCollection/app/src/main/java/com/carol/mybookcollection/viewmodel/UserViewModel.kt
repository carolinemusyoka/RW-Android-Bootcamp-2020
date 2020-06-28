package com.carol.mybookcollection.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carol.mybookcollection.db.UserAccountDatabase
import com.carol.mybookcollection.repository.UserRepository

class UserViewModel(context: Context) : ViewModel() {

    private val userRepository: UserRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao())

    internal fun createUser(username: String, password: String) {
        userRepository.insertUser(username, password)
    }

    internal fun checkValidLogin(username: String, password: String): Boolean {
        return userRepository.isValidAccount(username, password)
    }

    class Factory internal constructor(ctxt: Context) : ViewModelProvider.Factory {
        private val ctxt: Context = ctxt.applicationContext

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(ctxt) as T
        }
    }
}