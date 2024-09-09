package com.example.mynewapp.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase

@Database(entities = [UserTable::class, Quiz::class], version = 1)
abstract class GamingDatabase:RoomDatabase(){
    abstract val dao:GameAccessDao
}