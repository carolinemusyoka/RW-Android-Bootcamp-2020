package com.carol.mybookcollection.db



import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.carol.mybookcollection.model.UserAccount



@Dao
interface UserAccountDao {
    @Insert
    fun insertUserData(user: UserAccount)  //   query is written above for insert all details of user

    @Query("select * from UserAccount")
    fun getDetails(): LiveData<List<UserAccount>> //   query is written above for fetching all details of user

    @Query("DELETE FROM UserAccount WHERE id = :id")
    fun deleteByUserId(id: Long)   //  do it by your own for practise  query is written above
}