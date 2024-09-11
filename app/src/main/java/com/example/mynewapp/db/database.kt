package com.example.mynewapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserTable::class, Quiz::class], version = 1)
abstract class GamingDatabase:RoomDatabase(){
    abstract val dao:GameAccessDao
    companion object {
        @Volatile
        private var INSTANCE: GamingDatabase? = null

        fun getDatabase(context: Context): GamingDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GamingDatabase::class.java,
                    "gamingDatabase.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}