package com.carol.mybookcollection.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carol.mybookcollection.model.UserAccount

@Database(entities = [UserAccount::class], version = 2, exportSchema = true)
abstract class UserAccountDatabase : RoomDatabase() {

    abstract fun daoAccess(): UserAccountDao

    companion object {

        private var INSTANCE: UserAccountDatabase? = null
        fun getDatabase(context: Context): UserAccountDatabase? {

            if (INSTANCE == null) synchronized(UserAccountDatabase::class.java) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                        context, UserAccountDatabase::class.java, "USER_DATABASE"
                    ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

                }

            }

            return INSTANCE

        }
    }
}