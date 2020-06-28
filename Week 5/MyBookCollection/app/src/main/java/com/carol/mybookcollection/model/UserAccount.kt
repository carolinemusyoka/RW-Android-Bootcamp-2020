package com.carol.mybookcollection.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "useraccounts")
data class UserAccount
    (@PrimaryKey
     var userId: String,
     var password: String)


