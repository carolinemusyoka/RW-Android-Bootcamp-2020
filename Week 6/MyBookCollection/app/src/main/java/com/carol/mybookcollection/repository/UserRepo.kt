package com.carol.mybookcollection.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.carol.mybookcollection.model.UserAccount
import com.carol.mybookcollection.db.UserAccountDao
import com.carol.mybookcollection.db.UserAccountDatabase

class UserRepository (application: Application) {
    private var daoAccess: UserAccountDao? = null
    private var allData: LiveData<List<UserAccount>>? = null

    init {
        //fetching user database
        val db = UserAccountDatabase.getDatabase(application)
        daoAccess = db?.daoAccess()
        allData = daoAccess?.getDetails()

    }


    fun getAllData(): LiveData<List<UserAccount>>? {
        return allData
    }

    fun insertData(data: UserAccount) {
        daoAccess?.let { LoginInsertion(it).execute(data) }
    }

    private class LoginInsertion(private val daoAccess: UserAccountDao) :
        AsyncTask<UserAccount, Void, Void>() {

         override fun doInBackground(vararg data: UserAccount): Void? {

            daoAccess.insertUserData(data[0])
            return null

        }

    }
}