package com.carol.mybookcollection.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carol.mybookcollection.db.UserAccountDatabase
import com.carol.mybookcollection.model.UserAccount
import com.carol.mybookcollection.repository.UserRepository
import kotlinx.coroutines.coroutineScope

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: UserRepository = UserRepository(application)
    private var getAllDatas: LiveData<List<UserAccount>>

    init {

        getAllDatas = repository.getAllData()!!
    }

    suspend fun insert(data: UserAccount) = coroutineScope {
        repository.insertData(data)
    }
    fun getGetAllData(): LiveData<List<UserAccount>> {
        return getAllDatas
    }
}
