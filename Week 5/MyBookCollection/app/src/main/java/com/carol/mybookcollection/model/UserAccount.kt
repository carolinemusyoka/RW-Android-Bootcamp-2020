package com.carol.mybookcollection.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class UserAccount : Serializable {
    //declaration of user table columns
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var username: String? = null
    var password: String? = null


}


