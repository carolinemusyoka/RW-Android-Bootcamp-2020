package com.carol.mybookcollection.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carol.mybookcollection.model.UserAccount

@Database(entities = [UserAccount::class], version = 1)
abstract class UserAccountDatabase : RoomDatabase() {

    abstract fun userAccountDao(): UserAccountDao

    companion object {
        private var INSTANCE: UserAccountDatabase? = null

        fun getAppDatabase(context: Context): UserAccountDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    UserAccountDatabase::class.java,
                    "user-database")
                    .build()
            }

            return INSTANCE!!

        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}