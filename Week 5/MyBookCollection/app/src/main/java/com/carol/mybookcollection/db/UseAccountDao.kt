package com.carol.mybookcollection.db



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.carol.mybookcollection.model.UserAccount



@Dao
interface UserAccountDao {

    @Insert
    fun insert(account: UserAccount)

    @Query("SELECT * FROM useraccounts WHERE useraccounts.userId LIKE :username")
    fun getAccount(username: String): UserAccount
}
